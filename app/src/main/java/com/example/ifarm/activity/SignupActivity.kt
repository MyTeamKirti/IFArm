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
import kotlinx.android.synthetic.main.activity_signup.*

class SignupActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        setSpanable()
    }


    private fun setSpanable() {
        val st = getString(R.string.signupdonthaveaccountlogin)
        val spannableString = SpannableString(st)
        val builder = SpannableStringBuilder()
        //adding click span
        val clickableSpan: ClickableSpan = object : ClickableSpan() {
            override fun onClick(view: View) {
                val intent= Intent(this@SignupActivity,LoginActivity::class.java)
                startActivity(intent)
                finish()
            }
        }

        spannableString.setSpan(clickableSpan, (26), 32, 0)

        spannableString.setSpan(
            ForegroundColorSpan(ContextCompat.getColor(this, R.color.colorPrimary)),
            (26), 32, 0)
        builder.append(spannableString)
        tvSpanSignup.setText(spannableString, TextView.BufferType.SPANNABLE)
        tvSpanSignup.movementMethod = LinkMovementMethod.getInstance()
    }


}
