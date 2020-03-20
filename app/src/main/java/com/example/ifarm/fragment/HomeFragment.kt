package com.example.ifarm.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.ifarm.R
import com.example.ifarm.activity.HomeActivity
import com.example.ifarm.adapter.HomeListAdapter
import com.example.ifarm.interfaces.OnItemClickListner
import com.example.ifarm.model.PostData
import com.example.ifarm.model.ProductData1
import kotlinx.android.synthetic.main.app_bar_home.*
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment(),OnItemClickListner {

    private val mParentRef by lazy { activity as HomeActivity }
    private var mProductsList= ArrayList<PostData>()
    private var mProductDataList1= ArrayList<ProductData1>()
    private var mProductDataList2= ArrayList<ProductData1>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setToolBar()
        setData()
        setAdapter()
    }

    override fun onButtonMainClick(activity_name: String) {

    }

    override fun onDataClick(text: String, pos: Int, key_text: String) {
    }

    private fun setToolBar(){
        mParentRef.tvToolBar.text="I-Farm"
        mParentRef.ivCartHome.setImageResource(R.drawable.ic_cart)
    }

    private fun setData(){
        val data1=ProductData1("0","",R.drawable.seeds1,"","")
        val data2=ProductData1("1","",R.drawable.seeds2,"","")
        val data3=ProductData1("2","",R.drawable.seeds1,"","")

        mProductDataList1.add(data1)
        mProductDataList1.add(data2)
        mProductDataList1.add(data3)

        val data4=ProductData1("0","",R.drawable.nuts1,"","")
        val data5=ProductData1("1","",R.drawable.nuts2,"","")
        val data6=ProductData1("2","",R.drawable.nuts3,"","")
        val data7=ProductData1("3","",R.drawable.nuts1,"","")
        val data8=ProductData1("4","",R.drawable.nuts2,"","")


        mProductDataList2.add(data4)
        mProductDataList2.add(data5)
        mProductDataList2.add(data6)
        mProductDataList2.add(data7)
        mProductDataList2.add(data8)

        val postData1=PostData(mProductDataList1,1,"")
        val postData2=PostData(mProductDataList2,2,"")
        val postData3=PostData(mProductDataList1,1,"")
        mProductsList.add(postData1)
        mProductsList.add(postData2)
        mProductsList.add(postData3)
    }

    private fun setAdapter(){
        val mLayoutManager = LinearLayoutManager(
            context, LinearLayoutManager.VERTICAL, false)
        rvHomeList.layoutManager = mLayoutManager
        val trendingProductAdapter = HomeListAdapter(mProductsList,this,0)
        rvHomeList.adapter = trendingProductAdapter
    }

}
