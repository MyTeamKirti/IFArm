package com.example.ifarm.activity

import android.annotation.TargetApi
import android.app.Activity
import android.content.Context
import android.graphics.drawable.Drawable
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.TypedValue
import android.view.WindowManager
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import com.example.ifarm.R
import com.example.ifarm.adapter.SellerHomeListAdapter
import com.example.ifarm.adapter.SubscriptionPlanAdapter
import com.example.ifarm.interfaces.OnItemClickListner
import com.example.ifarm.model.SubscriptionResult
import com.example.ifarm.utils.GridSpacingItemDecoration
import kotlinx.android.synthetic.main.activity_subscription.*
import kotlin.math.roundToInt

class SubscriptionActivity : AppCompatActivity(),SubscriptionPlanAdapter.OnRecyclerViewItemClickListener {

    private var mSubscriptionAdapter: SubscriptionPlanAdapter? = null
    var mSubscriptionsList:ArrayList<SubscriptionResult> = ArrayList()
    private var mSelectedItemCount: Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStatusBar(this,ContextCompat.getColor(this,R.color.colorPrimary))
        setContentView(R.layout.activity_subscription)
        initalization()
    }

    override fun selectedItemCount(id: String, position: Int, count: Int) {
        mSelectedItemCount = count
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    fun setStatusBar(activity: Activity, statusBarColor: Int) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val window = activity.window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.statusBarColor = ContextCompat.getColor(this,R.color.colorPrimary)
        }
    }

    private fun initalization(){
        setData()
        setAdapter()
    }

    private fun setData(){
        val subscriptionResult1=SubscriptionResult("0","1","0.250 KD",true)
        val subscriptionResult2=SubscriptionResult("0","2","0.450 KD",false)
        val subscriptionResult3=SubscriptionResult("0","3","0.650 KD",false)
        val subscriptionResult4=SubscriptionResult("0","4","0.800 KD",false)
        mSubscriptionsList.add(subscriptionResult1)
        mSubscriptionsList.add(subscriptionResult2)
        mSubscriptionsList.add(subscriptionResult3)

    }

    private fun setAdapter(){
        val mLayoutManager = GridLayoutManager(this, 2)
        rvSubsciptions.layoutManager = mLayoutManager
        mSubscriptionAdapter = SubscriptionPlanAdapter(this,mSubscriptionsList)
        rvSubsciptions.adapter = mSubscriptionAdapter
        GridSpacingItemDecoration(
            2, dpToPx(this, 16), true
        ).let { rvSubsciptions?.addItemDecoration(it) }

    }

     private fun dpToPx(context: Context, dp: Int): Int {
        val r = context.resources
        return TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP,
            dp.toFloat(),
            r.displayMetrics
        ).roundToInt()
    }

}
