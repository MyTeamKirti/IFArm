package com.example.ifarm.activity

import android.annotation.TargetApi
import android.app.Activity
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ifarm.R
import com.example.ifarm.adapter.CartListAdapter
import com.example.ifarm.interfaces.OnItemClickListner
import com.example.ifarm.model.CartResult
import kotlinx.android.synthetic.main.activity_cart.*
import kotlinx.android.synthetic.main.custom_toolbar_layout.*

class CartActivity : AppCompatActivity(),OnItemClickListner {

    private var mCartListAdapter:CartListAdapter? = null
    private var mCartList=ArrayList<CartResult>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStatusBar(this,ContextCompat.getColor(this,R.color.colorPrimary))
        setContentView(R.layout.activity_cart)
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

    private fun initialization(){
        setToolBar()
        onViewClickListener()
        setAdapter()
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    fun setStatusBar(activity: Activity, statusBarColor: Int) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val window = activity.window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.statusBarColor = ContextCompat.getColor(this,R.color.colorPrimary)
        }
    }

    private fun setToolBar(){
        tvToolBar.text="Cart"

    }

    private fun onViewClickListener(){
        ivBack.setOnClickListener {
            onBackPressed()
        }

        buttonBuy.setOnClickListener {
            val intent=Intent(this,PaymentActivity::class.java)
            startActivity(intent)
        }
    }

    private fun setCartData(){
        val cartResult1= CartResult(
            "0","Britannica Sesame","Daman Seeds",
            "1 kilogram","$ 250",R.drawable.product,
            "February 17/02-2020 ","05:30 pm")
        val cartResult2= CartResult(
            "0","Britannica Sesame","Daman Seeds",
            "1 kilogram","$ 250",R.drawable.product,
            "February 17/02-2020 ","05:30 pm")
        val cartResult3= CartResult(
            "0","Britannica Sesame","Daman Seeds",
            "1 kilogram","$ 250",R.drawable.product,
            "February 17/02-2020 ","05:30 pm")
        val cartResult4= CartResult(
            "0","Britannica Sesame","Daman Seeds",
            "1 kilogram","$ 250",R.drawable.product,
            "February 17/02-2020 ","05:30 pm")
        mCartList.add(cartResult1)
        mCartList.add(cartResult2)
        mCartList.add(cartResult3)
        mCartList.add(cartResult4)
    }

    private fun setAdapter(){
        setCartData()
        val mLayoutManager: LinearLayoutManager by lazy(LazyThreadSafetyMode.PUBLICATION) {
            LinearLayoutManager(this) }
        rvCartList.layoutManager = mLayoutManager
        rvCartList.setHasFixedSize(true)
        mCartListAdapter = CartListAdapter(mCartList,this)
        rvCartList.adapter = mCartListAdapter
    }
}
