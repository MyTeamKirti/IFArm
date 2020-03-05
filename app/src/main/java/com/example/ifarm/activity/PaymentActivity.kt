package com.example.ifarm.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.ifarm.R
import kotlinx.android.synthetic.main.activity_company_products.*
import kotlinx.android.synthetic.main.custom_toolbar_layout.*

class PaymentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment)
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

    private fun setToolBar(){
        tvToolBar.text="Payment"
        ivCart.visibility= View.GONE
    }

    private fun onViewClickListener(){
        ivBack.setOnClickListener {
            onBackPressed()
        }

    }
}
