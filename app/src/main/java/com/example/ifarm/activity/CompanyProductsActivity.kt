package com.example.ifarm.activity

import android.annotation.SuppressLint
import android.annotation.TargetApi
import android.app.Activity
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.LinearLayout
import androidx.annotation.NonNull
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ifarm.R
import com.example.ifarm.adapter.CompanyProductsAdpter
import com.example.ifarm.adapter.FilterProductsAdapter
import com.example.ifarm.interfaces.OnItemClickListner
import com.example.ifarm.model.CartResult
import com.example.ifarm.model.FilterOption
import com.example.ifarm.model.FilterOptionData
import com.google.android.material.bottomsheet.BottomSheetBehavior
import kotlinx.android.synthetic.main.activity_company_products.*
import kotlinx.android.synthetic.main.bottomsheet_filter_product.*
import kotlinx.android.synthetic.main.custom_toolbar_layout.*

class CompanyProductsActivity : AppCompatActivity(),OnItemClickListner {

    var mFilterSheetBehavior:BottomSheetBehavior<CoordinatorLayout>? = null
    private var mCompanyProductsAdpter: CompanyProductsAdpter? = null
    private var mFilterProductsAdpter: FilterProductsAdapter? = null
    private var mProductList=ArrayList<CartResult>()
    private var mFilteredList=ArrayList<FilterOptionData>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStatusBar(this,ContextCompat.getColor(this,R.color.colorPrimary))
        setContentView(R.layout.activity_company_products)
        initialization()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        if (mFilterSheetBehavior?.state == BottomSheetBehavior.STATE_EXPANDED){
            mFilterSheetBehavior?.isHideable=true
            mFilterSheetBehavior?.state = BottomSheetBehavior.STATE_HIDDEN
            dimFilterBlackBg.visibility = View.GONE
        }
        else
        finish()
    }

    override fun onButtonMainClick(activity_name: String) {

    }

    override fun onDataClick(text: String, pos: Int, key_text: String) {
    }

    private fun initialization(){
        setToolBar()
        onBottomSheetView()
        onViewClickListener()
        setAdapter()
        mFilterSheetBehavior?.isHideable=true
        mFilterSheetBehavior?.state = BottomSheetBehavior.STATE_HIDDEN

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

    private fun setToolBar(){
        tvToolBar.text="Company Products"
        ivCart.visibility=View.VISIBLE
    }

    fun onBottomSheetView(){
        mFilterSheetBehavior= BottomSheetBehavior.from(bottomSheetFilterProd)
        mFilterSheetBehavior?.state = BottomSheetBehavior.STATE_HIDDEN

        mFilterSheetBehavior?.setBottomSheetCallback(object: BottomSheetBehavior.BottomSheetCallback() {
            @SuppressLint("SwitchIntDef")
            override fun onStateChanged(@NonNull bottomSheet: View, newState:Int) {
                when (newState) {
                    BottomSheetBehavior.STATE_HIDDEN -> {
                        dimFilterBlackBg.visibility= View.GONE

                    }
                    BottomSheetBehavior.STATE_EXPANDED -> {
//                        hideKeyboard(this@AvatarDetailActivity)
                        dimFilterBlackBg.visibility = View.VISIBLE
                    }
                    BottomSheetBehavior.STATE_COLLAPSED -> {
                        dimFilterBlackBg.visibility = View.VISIBLE
                    }
                    BottomSheetBehavior.STATE_DRAGGING -> {
                        dimFilterBlackBg.visibility = View.VISIBLE
                    }
                    BottomSheetBehavior.STATE_SETTLING -> {
                        dimFilterBlackBg.visibility = View.VISIBLE
                    }
                }
            }
            override fun onSlide(@NonNull bottomSheet: View, slideOffset:Float) {
//                dimFilterBlackBg.visibility = View.VISIBLE
//                dimFilterBlackBg.alpha = slideOffset
            }
        })
    }

    private fun onViewClickListener(){

        ivBack.setOnClickListener {
            onBackPressed()
        }

        tvViewCart.setOnClickListener {
            val intent=Intent(this,CartActivity::class.java)
            startActivity(intent)
        }

        tvFilter.setOnClickListener {
            mFilterSheetBehavior?.state = BottomSheetBehavior.STATE_EXPANDED
            dimFilterBlackBg.visibility = View.VISIBLE
        }

        buttonApply.setOnClickListener {
            mFilterSheetBehavior?.isHideable=true
            mFilterSheetBehavior?.state = BottomSheetBehavior.STATE_HIDDEN
            dimFilterBlackBg.visibility = View.GONE
        }
        buttonCancel.setOnClickListener {
            mFilterSheetBehavior?.isHideable=true
            mFilterSheetBehavior?.state = BottomSheetBehavior.STATE_HIDDEN
            dimFilterBlackBg.visibility = View.GONE
        }
    }

    private fun setProductsData(){
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
        mProductList.add(cartResult1)
        mProductList.add(cartResult2)
        mProductList.add(cartResult3)
        mProductList.add(cartResult4)


    }

    private fun setFilteredProductsList(){
        val filterData1=FilterOptionData("0","Seeds",false)
        val filterData2=FilterOptionData("1","Plants",false)
        val filterData3=FilterOptionData("2","Pumpkins",false)
        mFilteredList.add(filterData1)
        mFilteredList.add(filterData2)
        mFilteredList.add(filterData3)
        mFilteredList.add(filterData1)
        mFilteredList.add(filterData2)
        mFilteredList.add(filterData3)
    }

    private fun setAdapter(){
        setProductsData()
        setFilteredProductsList()
        val mLayoutManager: LinearLayoutManager by lazy(LazyThreadSafetyMode.PUBLICATION) {
            LinearLayoutManager(this) }
        rvProductList.layoutManager = mLayoutManager
        rvProductList.setHasFixedSize(true)
        mCompanyProductsAdpter = CompanyProductsAdpter(mProductList,this)
        rvProductList.adapter = mCompanyProductsAdpter

        val mLayoutManager1: LinearLayoutManager by lazy(LazyThreadSafetyMode.PUBLICATION) {
            LinearLayoutManager(this) }
        rvFilterProducts.layoutManager = mLayoutManager1
        rvFilterProducts.setHasFixedSize(true)
        mFilterProductsAdpter = FilterProductsAdapter(this,mFilteredList)
        rvFilterProducts.adapter = mFilterProductsAdpter



    }
}
