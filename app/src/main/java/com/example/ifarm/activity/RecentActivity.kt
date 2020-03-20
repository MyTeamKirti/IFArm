package com.example.ifarm.activity

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.TypedValue
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import com.example.ifarm.R
import com.example.ifarm.adapter.CommunityListAdapter
import com.example.ifarm.interfaces.OnItemClickListner
import com.example.ifarm.model.ProductData1
import com.example.ifarm.utils.GridSpacingItemDecoration
import kotlinx.android.synthetic.main.activity_recent.*
import kotlinx.android.synthetic.main.custom_toolbar_layout.*
import kotlin.math.roundToInt

class RecentActivity : AppCompatActivity(), OnItemClickListner {

    private var mRecentActivitiesListAdapter: CommunityListAdapter? = null
    private var mRecentActivitiesList=ArrayList<ProductData1>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recent)
        initalization()
    }

    override fun onButtonMainClick(activity_name: String) {

    }

    override fun onDataClick(text: String, pos: Int, key_text: String) {
//        val intent= Intent(activity, SellerProductDesActivity::class.java)
//        startActivity(intent)
    }

    private fun initalization(){
        setToolBar()
        setAdapter()
    }

    private fun setToolBar(){
        tvToolBar.text="Recent Activity"
        appBarLayout.elevation= 0F
        ivCart.visibility= View.GONE
    }



    private fun setCartData(){
        val data19= ProductData1("0","Sesame",R.drawable.sesame,"1 kg","Seeds")
        val data20= ProductData1("1","Hemp",R.drawable.hemp,"1 kg","Plants")
        val data21= ProductData1("2","Pumpkin",R.drawable.sesame,"1 kg","Seeds")
        val data22= ProductData1("3","Sesame",R.drawable.hemp,"1 kg","Plants")
        mRecentActivitiesList.add(data19)
        mRecentActivitiesList.add(data20)
        mRecentActivitiesList.add(data21)
        mRecentActivitiesList.add(data22)
        mRecentActivitiesList.add(data22)
        mRecentActivitiesList.add(data19)
        mRecentActivitiesList.add(data20)
        mRecentActivitiesList.add(data21)
        mRecentActivitiesList.add(data22)
        mRecentActivitiesList.add(data22)
        mRecentActivitiesList.add(data19)
        mRecentActivitiesList.add(data20)
        mRecentActivitiesList.add(data21)
        mRecentActivitiesList.add(data22)
        mRecentActivitiesList.add(data22)
        mRecentActivitiesList.add(data22)
    }
    
    private fun setAdapter(){
        setCartData()
        
        val mLayoutManager1 = GridLayoutManager(this, 2)
        rvRecentActivities.layoutManager = mLayoutManager1
        mRecentActivitiesListAdapter = CommunityListAdapter(mRecentActivitiesList,this)
        rvRecentActivities.adapter = mRecentActivitiesListAdapter
        dpToPx(this, 16)?.let {
            GridSpacingItemDecoration(
                2,
                it, true
            )
        }.let { rvRecentActivities?.addItemDecoration(it) }

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
