package com.example.ifarm.fragment

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.TypedValue
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ifarm.R
import com.example.ifarm.activity.HomeActivity
import com.example.ifarm.activity.SellerProductDesActivity
import com.example.ifarm.adapter.CommunityListAdapter
import com.example.ifarm.adapter.CommunityTabRVAdapter
import com.example.ifarm.interfaces.OnItemClickListner
import com.example.ifarm.model.CategoryResult
import com.example.ifarm.model.ProductData1
import com.example.ifarm.utils.GridSpacingItemDecoration
import kotlinx.android.synthetic.main.app_bar_home.*
import kotlinx.android.synthetic.main.fragment_community.*
import kotlin.math.roundToInt

class CommunityFragment : Fragment(), OnItemClickListner {

    private val mParentRef by lazy { activity as HomeActivity }
    private var mCommunityListAdapter: CommunityListAdapter? = null
    private var mCommunityList=ArrayList<ProductData1>()
    private val mCategoryList = ArrayList<CategoryResult>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_community, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
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
        mParentRef.tvToolBar.text="Community"
        mParentRef.appBarLayout.elevation= 0F
        mParentRef.ivCartHome.visibility=View.GONE
    }



    private fun setCartData(){
        val data19= ProductData1("0","Sesame",R.drawable.sesame,"1 kg","250 kwd")
        val data20= ProductData1("1","Hemp",R.drawable.hemp,"1 kg","250 kwd")
        val data21= ProductData1("2","Pumpkin",R.drawable.sesame,"1 kg","250 kwd")
        val data22= ProductData1("3","Sesame",R.drawable.hemp,"1 kg","250 kwd")
        mCommunityList.add(data19)
        mCommunityList.add(data20)
        mCommunityList.add(data21)
        mCommunityList.add(data22)
        mCommunityList.add(data22)
        mCommunityList.add(data19)
        mCommunityList.add(data20)
        mCommunityList.add(data21)
        mCommunityList.add(data22)
        mCommunityList.add(data22)
        mCommunityList.add(data19)
        mCommunityList.add(data20)
        mCommunityList.add(data21)
        mCommunityList.add(data22)
        mCommunityList.add(data22)
        mCommunityList.add(data22)
    }

    private fun setCategoryData(){
        val category1= CategoryResult("0","Sell")
        val category2= CategoryResult("1","Community Market")
        mCategoryList.add(category1)
        mCategoryList.add(category2)
    }

    private fun setAdapter(){
        setCategoryData()
        setCartData()

        //categories adapter
        val mLayoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        rvCommunityCategories.layoutManager = mLayoutManager
        val categoryAdapter = CommunityTabRVAdapter(mCategoryList, this)
        rvCommunityCategories.adapter = categoryAdapter

        val mLayoutManager1 = GridLayoutManager(context, 2)
        rvCommunityProducts.layoutManager = mLayoutManager1
        mCommunityListAdapter = CommunityListAdapter(mCommunityList,this)
        rvCommunityProducts.adapter = mCommunityListAdapter
        activity?.let { dpToPx(it, 16) }?.let {
            GridSpacingItemDecoration(
                2,
                it, true
            )
        }?.let { rvCommunityProducts?.addItemDecoration(it) }

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
