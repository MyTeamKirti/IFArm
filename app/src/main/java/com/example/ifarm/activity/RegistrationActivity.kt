package com.example.ifarm.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ifarm.R
import com.example.ifarm.utils.AppPreferences
import com.example.ifarm.utils.Constants
import kotlinx.android.synthetic.main.activity_registration.*

class RegistrationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)
        onViewClickListener()
    }


    private fun onViewClickListener(){
        constraintGreen.setOnClickListener {
            AppPreferences.writeInteger(this, Constants.USERTYPE,1)
            val intent= Intent(this,HomeActivity::class.java)
            startActivity(intent)
        }

        constraintBlue.setOnClickListener {
            AppPreferences.writeInteger(this, Constants.USERTYPE,2)
            val intent= Intent(this,HomeActivity::class.java)
            startActivity(intent)
        }

    }
}
