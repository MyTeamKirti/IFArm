package com.example.ifarm.activity

import android.annotation.TargetApi
import android.app.Activity
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.core.content.ContextCompat
import com.example.ifarm.R
import kotlinx.android.synthetic.main.activity_product_description.*

class ProductDescriptionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStatusBar(this,ContextCompat.getColor(this,R.color.colorPrimary))
        setContentView(R.layout.activity_product_description)
        initialization()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }

    private fun initialization(){
        onViewClickListener()

    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    fun setStatusBar(activity: Activity, statusBarColor: Int) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val window = activity.window
            //val background = drawable
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.statusBarColor = ContextCompat.getColor(this,R.color.colorPrimary)
        }
    }

    private fun onViewClickListener(){
        buttonAddtoCart.setOnClickListener {
            constraintCartBtn.visibility=View.VISIBLE
            buttonAddtoCart.visibility=View.GONE
        }

        ivBack.setOnClickListener {
            onBackPressed()
        }

        ivminusProduct.setOnClickListener {
            tvQuantityUpdate.text= (tvQuantityUpdate.text.toString().toInt()-1).toString()
        }

        ivPlusProduct.setOnClickListener {
            tvQuantityUpdate.text= (tvQuantityUpdate.text.toString().toInt()+1).toString()
        }
    }
}
