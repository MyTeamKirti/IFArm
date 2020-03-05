package com.example.ifarm.activity

import android.annotation.TargetApi
import android.app.Activity
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ifarm.R
import com.example.ifarm.adapter.OrdersListAdapter
import com.example.ifarm.interfaces.OnItemClickListner
import com.example.ifarm.model.CartResult
import kotlinx.android.synthetic.main.activity_order_history.*
import kotlinx.android.synthetic.main.custom_toolbar_layout.*

class OrderHistoryActivity : AppCompatActivity(),OnItemClickListner {

    private var mOrderListAdapter:OrdersListAdapter? = null
    private var mOrdersList=ArrayList<CartResult>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStatusBar(this,ContextCompat.getColor(this,R.color.colorPrimary))
        setContentView(R.layout.activity_order_history)
        initialization()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }

    override fun onButtonMainClick(activity_name: String) {

    }

    override fun onDataClick(text: String, pos: Int, key_text: String) {
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    fun setStatusBar(activity: Activity, statusBarColor: Int) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val window = activity.window
            //val background = drawable
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.statusBarColor = ContextCompat.getColor(this,R.color.colorPrimary)
//            window.navigationBarColor = activity.resources.getColor(android.R.color.black)
        }
    }

    private fun initialization(){
        setToolBar()
        onViewClickListener()
        setAdapter()
    }


    private fun setToolBar(){
        tvToolBar.text="Order History"
    }

    private fun setChatData(){
        val cartResult1= CartResult(
            "0","Britannica Sesame","Daman Seeds",
            "1 kilogram","$ 250",R.drawable.orderhistory,
            "February 17/02-2020 ","05:30 pm")
        val cartResult2= CartResult(
            "0","Britannica Sesame","Daman Seeds",
            "1 kilogram","$ 250",R.drawable.orderhistory,
            "February 17/02-2020 ","05:30 pm")
        val cartResult3= CartResult(
            "0","Britannica Sesame","Daman Seeds",
            "1 kilogram","$ 250",R.drawable.orderhistory,
            "February 17/02-2020 ","05:30 pm")
        val cartResult4= CartResult(
            "0","Britannica Sesame","Daman Seeds",
            "1 kilogram","$ 250",R.drawable.orderhistory,
            "February 17/02-2020 ","05:30 pm")
        mOrdersList.add(cartResult1)
        mOrdersList.add(cartResult2)
        mOrdersList.add(cartResult3)
        mOrdersList.add(cartResult4)
    }

    private fun setAdapter(){
        setChatData()
        val mLayoutManager: LinearLayoutManager by lazy(LazyThreadSafetyMode.PUBLICATION) {
            LinearLayoutManager(this) }
        rvOrderList.layoutManager = mLayoutManager
        rvOrderList.setHasFixedSize(true)
        mOrderListAdapter = OrdersListAdapter(mOrdersList,this)
        rvOrderList.adapter = mOrderListAdapter
    }

    private fun onViewClickListener(){
        ivBack.setOnClickListener {
            onBackPressed()
        }
    }

}
