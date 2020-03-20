package com.example.ifarm.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ifarm.R
import com.example.ifarm.adapter.ShopDetailsAdapter
import com.example.ifarm.interfaces.OnItemClickListner
import com.example.ifarm.model.ChatResult
import kotlinx.android.synthetic.main.activity_shop_details.*
import kotlinx.android.synthetic.main.custom_toolbar_layout.*

class ShopDetailsActivity : AppCompatActivity(),OnItemClickListner {

    private var mShopDetailsAdapter:ShopDetailsAdapter? = null
    private var mShopDetailList=ArrayList<ChatResult>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shop_details)
        initialization()
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }

    override fun onButtonMainClick(activity_name: String) {

    }

    override fun onDataClick(text: String, pos: Int, key_text: String) {
    }

    private fun initialization(){
        setToolBar()
        setAdapter()
        onViewClickListener()
    }

    private fun setToolBar(){
        tvToolBar.text="Plants Shops"
        ivCart.visibility=View.GONE
    }

    private fun setShopsData(){
        val chatResult1= ChatResult(
            "0","Naman Plants","",
            R.drawable.product,"4.5")
        val chatResult2= ChatResult(
            "1","Naman Plants","",
            R.drawable.product,"5.0")
        val chatResult3= ChatResult(
            "2","Naman Plants","",
            R.drawable.product,"2.0")
        val chatResult4= ChatResult(
            "3","Naman Plants","",
            R.drawable.product,"4.5")

        mShopDetailList.add(chatResult1)
        mShopDetailList.add(chatResult2)
        mShopDetailList.add(chatResult3)
        mShopDetailList.add(chatResult4)
    }

    private fun setAdapter(){
        setShopsData()
        val mLayoutManager: LinearLayoutManager by lazy(LazyThreadSafetyMode.PUBLICATION) {
            LinearLayoutManager(this) }
        rvShopDetails.layoutManager = mLayoutManager
        rvShopDetails.setHasFixedSize(true)
        mShopDetailsAdapter = ShopDetailsAdapter(this,mShopDetailList)
        rvShopDetails.adapter = mShopDetailsAdapter
    }

    private fun onViewClickListener(){
        ivBack.setOnClickListener {
            onBackPressed()
        }
    }

}
