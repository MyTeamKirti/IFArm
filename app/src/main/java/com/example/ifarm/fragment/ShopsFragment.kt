package com.example.ifarm.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ifarm.R
import com.example.ifarm.activity.HomeActivity
import com.example.ifarm.activity.ShopDetailsActivity
import com.example.ifarm.adapter.HomeListAdapter
import com.example.ifarm.adapter.CommunityTabRVAdapter
import com.example.ifarm.interfaces.OnItemClickListner
import com.example.ifarm.model.CategoryResult
import com.example.ifarm.model.PostData
import com.example.ifarm.model.ProductData1
import kotlinx.android.synthetic.main.app_bar_home.*
import kotlinx.android.synthetic.main.fragment_shops.*

class ShopsFragment : Fragment(),OnItemClickListner {

    private val mParentRef by lazy { activity as HomeActivity }
    private val mCategoryList = ArrayList<CategoryResult>()
    private var mProductsList= ArrayList<PostData>()
    private var mProductDataList1= ArrayList<ProductData1>()
    private var mProductDataList2= ArrayList<ProductData1>()
    private var mProductDataList3= ArrayList<ProductData1>()
    private var mProductDataList4= ArrayList<ProductData1>()
    private var mProductDataList5= ArrayList<ProductData1>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_shops, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialization()
    }

    override fun onButtonMainClick(activity_name: String) {
    }

    override fun onDataClick(text: String, pos: Int, key_text: String) {

    }

    private fun initialization(){
        setToolBar()
        setAdapter()
    }

    private fun setToolBar(){
        mParentRef.tvToolBar.text="Shops"
        mParentRef.appBarLayout.elevation= 0F
        mParentRef.ivCartHome.setImageResource(R.drawable.ic_cart)

    }

    private fun setCategoryData(){
        val category1=CategoryResult("0","Company Shops")
        val category2=CategoryResult("1","Nursery Shops")
        val category3=CategoryResult("2","Farmer Shops")
        val category4=CategoryResult("3","Farmer Shops")
        mCategoryList.add(category1)
        mCategoryList.add(category2)
        mCategoryList.add(category3)
        mCategoryList.add(category4)
    }

    private fun setAdapter(){
        setCategoryData()
        setProductsData()

        //categories adapter
        val mLayoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        rvShopsCategories.layoutManager = mLayoutManager
        val categoryAdapter = CommunityTabRVAdapter(mCategoryList, this)
        rvShopsCategories.adapter = categoryAdapter

        //products adapter
        val mLayoutManager1 = LinearLayoutManager(
            context, LinearLayoutManager.VERTICAL, false)
        rvShopsList.layoutManager = mLayoutManager1
        val trendingProductAdapter = HomeListAdapter(mProductsList,this,1)
        rvShopsList.adapter = trendingProductAdapter

    }

    private fun setProductsData(){
        val data1= ProductData1("0","Daman Seeds",R.drawable.group_4786,"","")
        val data2= ProductData1("1","Seedz",R.drawable.group_4787,"","")
        val data3= ProductData1("2","Daman Seeds",R.drawable.group_4786,"","")

        mProductDataList1.add(data1)
        mProductDataList1.add(data2)
        mProductDataList1.add(data3)

        val data4= ProductData1("0","Seeds",R.drawable.group_4788,"","")
        val data5= ProductData1("1","Plants",R.drawable.group_4789,"","")
        val data6= ProductData1("2","Seedling",R.drawable.rectangle_24,"","")
        val data7= ProductData1("3","Seeds",R.drawable.group_4788,"","")
        val data8= ProductData1("4","Plants",R.drawable.group_4789,"","")

        mProductDataList2.add(data4)
        mProductDataList2.add(data5)
        mProductDataList2.add(data6)
        mProductDataList2.add(data7)
        mProductDataList2.add(data8)

        val data9= ProductData1("0","Sesame",R.drawable.exproduct,"1 kg","Wheat/Corn/Seedlings")
        val data10= ProductData1("1","Hemp",R.drawable.exproduct,"1 kg","Wheat/Corn/Seedlings")
        val data11= ProductData1("2","Pumpkin",R.drawable.exproduct,"1 kg","Wheat/Corn/Seedlings")
        val data12= ProductData1("3","Sesame",R.drawable.exproduct,"1 kg","Wheat/Corn/Seedlings")
        val data13= ProductData1("4","Hemp",R.drawable.exproduct,"1 kg","Wheat/Corn/Seedlings")

        mProductDataList3.add(data9)
        mProductDataList3.add(data10)
        mProductDataList3.add(data11)
        mProductDataList3.add(data12)
        mProductDataList3.add(data13)

        val data14= ProductData1("0","Sesame",R.drawable.sesame,"","")
        val data15= ProductData1("1","Hemp",R.drawable.hemp,"","")
        val data16= ProductData1("2","Pumpkin",R.drawable.pumpkin,"","")
        val data17= ProductData1("3","Sesame",R.drawable.sesame,"","")
        val data18= ProductData1("4","Hemp",R.drawable.hemp,"","")

        mProductDataList4.add(data14)
        mProductDataList4.add(data15)
        mProductDataList4.add(data16)
        mProductDataList4.add(data17)
        mProductDataList4.add(data18)

        val data19= ProductData1("0","Sesame",R.drawable.sesame,"1 kg","\$ 250")
        val data20= ProductData1("1","Hemp",R.drawable.hemp,"1 kg","\$ 250")
        val data21= ProductData1("2","Pumpkin",R.drawable.pumpkin,"1 kg","\$ 250")
        val data22= ProductData1("3","Sesame",R.drawable.sesame,"1 kg","\$ 250")
        val data23= ProductData1("4","Hemp",R.drawable.hemp,"1 kg","\$ 250")

        mProductDataList5.add(data19)
        mProductDataList5.add(data20)
        mProductDataList5.add(data21)
        mProductDataList5.add(data22)
        mProductDataList5.add(data23)

        val postData1= PostData(mProductDataList2,2,"Browse Category")
        val postData2= PostData(mProductDataList1,1,"Trending Shops")
        val postData3= PostData(mProductDataList3,3,"Exchange Products ")
        val postData4= PostData(mProductDataList4,4,"Trending Products ")
        val postData5= PostData(mProductDataList5,5,"Top Rated Shops")
        val postData6= PostData(mProductDataList5,4,"Top Rated Products")
        val postData7= PostData(mProductDataList5,5,"Top Seeds")
        val postData8= PostData(mProductDataList5,5,"Top Plants")


        mProductsList.add(postData1)
        mProductsList.add(postData2)
        mProductsList.add(postData3)
        mProductsList.add(postData4)
        mProductsList.add(postData5)
        mProductsList.add(postData6)
        mProductsList.add(postData7)
        mProductsList.add(postData8)

    }

}
