package com.example.ifarm.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.ifarm.R
import com.example.ifarm.utils.SPALSH_DELAY

class SplashActivity : AppCompatActivity() {

    private lateinit var mdelayHandler: Handler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        startSplsh()
    }

    private fun startSplsh(){
        mdelayHandler = Handler()
        mdelayHandler.postDelayed({
            navigateIntent()
        }, SPALSH_DELAY)

    }

    private fun navigateIntent(){
        val intent=Intent(this,RegistrationActivity::class.java)
        startActivity(intent)
        finish()
    }
}
