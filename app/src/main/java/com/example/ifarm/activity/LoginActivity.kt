package com.example.ifarm.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.SpannableString
import android.text.SpannableStringBuilder
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.text.style.ForegroundColorSpan
import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.example.ifarm.R
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        setSpanable()
        navigateIntents()
    }

    private fun setSpanable() {
        val st = getString(R.string.signupdonthaveaccount)
        val spannableString = SpannableString(st)
        val builder = SpannableStringBuilder()
        //adding click span
        val clickableSpan: ClickableSpan = object : ClickableSpan() {
            override fun onClick(view: View) {
               val intent=Intent(this@LoginActivity,SignupActivity::class.java)
               startActivity(intent)
            }
        }

        spannableString.setSpan(clickableSpan, (26), 33, 0)

        spannableString.setSpan(
            ForegroundColorSpan(ContextCompat.getColor(this, R.color.colorPrimary)),
            (26
                    ), 33, 0
        )
        builder.append(spannableString)
        tvSpanSignup.setText(spannableString, TextView.BufferType.SPANNABLE)
        tvSpanSignup.movementMethod = LinkMovementMethod.getInstance()
    }


    private fun navigateIntents(){
        buttonLogin.setOnClickListener {
            val intent=Intent(this@LoginActivity,HomeActivity::class.java)
            startActivity(intent)
        }
    }

}
