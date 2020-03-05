package com.example.ifarm.activity

import android.annotation.TargetApi
import android.app.Activity
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import androidx.core.content.ContextCompat
import com.example.ifarm.R
import kotlinx.android.synthetic.main.activity_company_info.*
import kotlinx.android.synthetic.main.custom_toolbar_layout.*

class CompanyInfoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStatusBar(this,ContextCompat.getColor(this,R.color.colorPrimary))
        setContentView(R.layout.activity_company_info)
        initialization()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }


    private fun initialization(){
        setToolBar()
        onViewClickListener()
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
        tvToolBar.text="Company Information"
    }

    private fun onViewClickListener(){
        ivBack.setOnClickListener {
            onBackPressed()
        }

        buttonProducts.setOnClickListener {
            val intent= Intent(this,CompanyProductsActivity::class.java)
            startActivity(intent)
        }

    }

}
