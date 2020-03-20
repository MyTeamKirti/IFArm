package com.example.ifarm.fragment

import android.Manifest
import android.Manifest.permission.CAMERA
import android.annotation.SuppressLint
import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ifarm.activity.HomeActivity
import kotlinx.android.synthetic.main.app_bar_home.*
import kotlinx.android.synthetic.main.fragment_profile.*
import com.example.ifarm.R
import android.graphics.Bitmap
import android.net.Uri
import android.os.Build
import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat
import androidx.core.content.PermissionChecker.checkSelfPermission
import android.content.DialogInterface
import android.annotation.TargetApi
import android.provider.MediaStore
import android.content.Intent
import android.content.ComponentName
import android.graphics.Matrix
import android.media.ExifInterface
import androidx.appcompat.app.AlertDialog
import com.example.ifarm.activity.FollowersActivity
import com.example.ifarm.activity.SubscriptionActivity
import com.example.ifarm.utils.Constants
import java.io.File
import java.io.IOException


class ProfileFragment : Fragment() {

    var myBitmap: Bitmap? = null
    var picUri: Uri? = null

    private var permissionsToRequest = ArrayList<String>()
    private val permissionsRejected = ArrayList<String>()
    private val permissions = ArrayList<String>()




    private val ALL_PERMISSIONS_RESULT = 107


    private val mParentRef by lazy { activity as HomeActivity }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialization()
    }

    private fun initialization(){
        setToolBar()
        onViewClickListener()

        permissions.add(CAMERA)
        permissionsToRequest = findUnAskedPermissions(permissions)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (permissionsToRequest.size > 0){
                ActivityCompat.requestPermissions(activity as Activity,
                    arrayOf(CAMERA),
                    ALL_PERMISSIONS_RESULT)
//
//                requestPermissions(permissionsToRequest,ALL_PERMISSIONS_RESULT)
//                requestPermissions(permissionsToRequest.toArray( permissionsToRequest.size().toa), ALL_PERMISSIONS_RESULT)

            }
        }
    }

    private fun setToolBar(){
        mParentRef.tvToolBar.text="Profile"
        mParentRef.ivCartHome.setImageResource(R.drawable.ic_profile_edit_icon)
    }

    private fun onViewClickListener(){
        constraintExchangeproduct.visibility=View.GONE
        border5.visibility=View.GONE
        cbExchangeProducts.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked){
                cbSell.isChecked=false
//                Toast.makeText(activity,"checked",Toast.LENGTH_SHORT).show()
                constraintExchangeproduct.visibility=View.VISIBLE
                border5.visibility=View.VISIBLE
                tvExchangewithHint.text="Exchange with"
                etExchangeValue.setText("Sesame")
                tvQuantityHint.visibility=View.VISIBLE
                tvExQuantityValue.visibility=View.VISIBLE
            }
            else{
//                Toast.makeText(activity,"unChecked",Toast.LENGTH_SHORT).show()
                constraintExchangeproduct.visibility=View.GONE
                border5.visibility=View.GONE
            }
        }

        cbSell.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked){
                cbExchangeProducts.isChecked=false
//                Toast.makeText(activity,"checked",Toast.LENGTH_SHORT).show()
                constraintExchangeproduct.visibility=View.VISIBLE
                border5.visibility=View.VISIBLE
                tvExchangewithHint.text="Price"
                etExchangeValue.setText("250 KWD")
                tvQuantityHint.visibility=View.GONE
                tvExQuantityValue.visibility=View.GONE
            }
            else{
//                Toast.makeText(activity,"unChecked",Toast.LENGTH_SHORT).show()
                constraintExchangeproduct.visibility=View.GONE
                border5.visibility=View.GONE
            }
        }

        ivExchangeProduct.setOnClickListener {
            startActivityForResult(getPickImageChooserIntent(), 200)
        }

        linearFollowers.setOnClickListener {

            val intent=Intent(activity, SubscriptionActivity::class.java)
//            intent.putExtra(Constants.FOLLOWERS,true)
            startActivity(intent)
        }

        linearFollowing.setOnClickListener {
            val intent=Intent(activity,FollowersActivity::class.java)
            intent.putExtra(Constants.FOLLOWERS,false)
            startActivity(intent)
        }

        buttonSave.setOnClickListener {
            cbExchangeProducts.isChecked=false
            constraintExchangeproduct.visibility=View.GONE
            border5.visibility=View.GONE
        }

    }

    private fun getPickImageChooserIntent(): Intent {

        // Determine Uri of camera image to save.
        val outputFileUri = getCaptureImageOutputUri()
        val allIntents = ArrayList<Intent>()
        val packageManager = activity?.packageManager

        // collect all camera intents
        val captureIntent = Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE)
        val listCam = packageManager?.queryIntentActivities(captureIntent, 0)
        if (listCam != null) {
            for (res in listCam) {
                val intent = Intent(captureIntent)
                intent.component = ComponentName(res.activityInfo.packageName, res.activityInfo.name)
                intent.setPackage(res.activityInfo.packageName)
                if (outputFileUri != null) {
                    intent.putExtra(MediaStore.EXTRA_OUTPUT, outputFileUri)
                }
                allIntents.add(intent)
            }
        }

        // collect all gallery intents
        val galleryIntent = Intent(Intent.ACTION_GET_CONTENT)
        galleryIntent.type = "image/*"
        val listGallery = packageManager?.queryIntentActivities(galleryIntent, 0)
        if (listGallery != null) {
            for (res in listGallery) {
                val intent = Intent(galleryIntent)
                intent.component = ComponentName(res.activityInfo.packageName, res.activityInfo.name)
                intent.setPackage(res.activityInfo.packageName)
                allIntents.add(intent)
            }
        }

        // the main intent is the last in the list (fucking android) so pickup the useless one
        var mainIntent: Intent = allIntents.get(allIntents.size - 1)
        for (intent in allIntents) {
            if (intent.getComponent()!!.getClassName() == "com.android.documentsui.DocumentsActivity") {
                mainIntent = intent
                break
            }
        }
        allIntents.remove(mainIntent)

        // Create a chooser from the main intent
        val chooserIntent = Intent.createChooser(mainIntent, "Select source")

        // Add all other intents
        chooserIntent.putExtra(Intent.EXTRA_INITIAL_INTENTS, allIntents.toTypedArray())

        return chooserIntent
    }


    /**
     * Get URI to image received from capture by camera.
     */
    private fun getCaptureImageOutputUri(): Uri? {
        var outputFileUri: Uri? = null
        val getImage = activity?.getExternalCacheDir()
        if (getImage != null) {
            outputFileUri = Uri.fromFile(File(getImage.getPath(), "profile.png"))
        }
        return outputFileUri
    }

     override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        val bitmap: Bitmap
        if (resultCode == Activity.RESULT_OK) {

            if (getPickImageResultUri(data) != null) {
                picUri = getPickImageResultUri(data)

                try {
                    myBitmap = MediaStore.Images.Media.getBitmap(activity?.contentResolver, picUri)
                    myBitmap = rotateImageIfRequired(myBitmap!!, picUri!!)
                    myBitmap = getResizedBitmap(myBitmap!!, 500)

//                    croppedImageView.setImageBitmap(myBitmap)
                    ivExchangeProduct.setImageBitmap(myBitmap)

                } catch (e: IOException) {
                    e.printStackTrace()
                }


            } else {

                bitmap = (data!!.extras!!.get("data") as Bitmap?)!!

                myBitmap = bitmap
                if (ivExchangeProduct != null) {
                    ivExchangeProduct!!.setImageBitmap(myBitmap)
                }

                ivExchangeProduct.setImageBitmap(myBitmap)

            }

        }

    }

    @Throws(IOException::class)
    private fun rotateImageIfRequired(img: Bitmap, selectedImage: Uri): Bitmap {

        val ei = ExifInterface(selectedImage.path!!)
        val orientation =
            ei.getAttributeInt(ExifInterface.TAG_ORIENTATION, ExifInterface.ORIENTATION_NORMAL)

        when (orientation) {
            ExifInterface.ORIENTATION_ROTATE_90 -> return rotateImage(img, 90)
            ExifInterface.ORIENTATION_ROTATE_180 -> return rotateImage(img, 180)
            ExifInterface.ORIENTATION_ROTATE_270 -> return rotateImage(img, 270)
            else -> return img
        }
    }

    private fun rotateImage(img: Bitmap, degree: Int): Bitmap {
        val matrix = Matrix()
        matrix.postRotate(degree.toFloat())
        val rotatedImg = Bitmap.createBitmap(img, 0, 0, img.width, img.height, matrix, true)
        img.recycle()
        return rotatedImg
    }

    fun getResizedBitmap(image: Bitmap, maxSize: Int): Bitmap {
        var width = image.width
        var height = image.height

        val bitmapRatio = width.toFloat() / height.toFloat()
        if (bitmapRatio > 0) {
            width = maxSize
            height = (width / bitmapRatio).toInt()
        } else {
            height = maxSize
            width = (height * bitmapRatio).toInt()
        }
        return Bitmap.createScaledBitmap(image, width, height, true)
    }


    /**
     * Get the URI of the selected image from [.getPickImageChooserIntent].<br></br>
     * Will return the correct URI for camera and gallery image.
     *
     * @param data the returned data of the activity result
     */
    fun getPickImageResultUri(data: Intent?): Uri? {
        var isCamera = true
        if (data != null) {
            val action = data.action
            isCamera = action != null && action == MediaStore.ACTION_IMAGE_CAPTURE
        }


        return if (isCamera) getCaptureImageOutputUri() else data!!.data
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        // save file url in bundle as it will be null on scren orientation
        // changes
        outState.putParcelable("pic_uri", picUri)
    }

//     fun onRestoreInstanceState(savedInstanceState: Bundle) {
//        super.onRestoreInstanceState(savedInstanceState)
//
//        // get the file url
//        picUri = savedInstanceState.getParcelable("pic_uri")
//    }

    private fun findUnAskedPermissions(wanted: ArrayList<String>): ArrayList<String> {
        val result = ArrayList<String>()

        for (perm in wanted) {
            if (!hasPermission(perm)) {
                result.add(perm)
            }
        }

        return result
    }

    @SuppressLint("WrongConstant")
    private fun hasPermission(permission: String): Boolean {
        if (canMakeSmores()) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                return checkSelfPermission(activity as Activity,permission) == PackageManager.PERMISSION_GRANTED
            }
        }
        return true
    }

    private fun showMessageOKCancel(message: String, okListener: DialogInterface.OnClickListener) {
        activity?.let {
            AlertDialog.Builder(it)
                .setMessage(message)
                .setPositiveButton("OK", okListener)
                .setNegativeButton("Cancel", null)
                .create()
                .show()
        }
    }

    private fun canMakeSmores(): Boolean {
        return Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP_MR1
    }

    @TargetApi(Build.VERSION_CODES.M)
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {

        when (requestCode) {

            ALL_PERMISSIONS_RESULT -> {
                for (perms in permissionsToRequest) {
                    if (hasPermission(perms)) {

                    } else {

                        permissionsRejected.add(perms)
                    }
                }

                if (permissionsRejected.size > 0) {


                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        if (shouldShowRequestPermissionRationale(permissionsRejected.get(0))) {
                            showMessageOKCancel("These permissions are mandatory for the application. Please allow access.",
                                DialogInterface.OnClickListener { dialog, which ->
                                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

                                        //Log.d("API123", "permisionrejected " + permissionsRejected.size());

                                        requestPermissions(
                                            permissionsRejected.toArray(
                                                arrayOfNulls<String>(
                                                    permissionsRejected.size
                                                )
                                            ), ALL_PERMISSIONS_RESULT
                                        )
                                    }
                                })
                            return
                        }
                    }

                }
            }
        }

    }

}
