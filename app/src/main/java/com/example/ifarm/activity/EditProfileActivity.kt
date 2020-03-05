package com.example.ifarm.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.ifarm.R
import kotlinx.android.synthetic.main.activity_buyer_info.*
import kotlinx.android.synthetic.main.activity_edit_profile.*
import kotlinx.android.synthetic.main.custom_toolbar_layout.*

class EditProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profile)
        initialization()
    }

    private fun initialization(){
        setToolBar()
        onViewClickListener()
    }

    private fun setToolBar(){
        tvToolBar.text="Edit Profile"
    }

    private fun onViewClickListener(){
        ivBack.setOnClickListener {
            onBackPressed()
        }

        buttonSave.setOnClickListener {
           finish()
        }
    }
}
