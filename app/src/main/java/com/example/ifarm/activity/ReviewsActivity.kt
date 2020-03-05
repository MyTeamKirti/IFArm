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
import com.example.ifarm.adapter.ChatListAdapter
import com.example.ifarm.interfaces.OnItemClickListner
import com.example.ifarm.model.ChatResult
import kotlinx.android.synthetic.main.activity_reviews.*
import kotlinx.android.synthetic.main.app_bar_home.*
import kotlinx.android.synthetic.main.app_bar_home.tvToolBar
import kotlinx.android.synthetic.main.custom_toolbar_layout.*
import kotlinx.android.synthetic.main.fragment_chat.*

class ReviewsActivity : AppCompatActivity(),OnItemClickListner {

    private var mChatListAdapter:ChatListAdapter? = null
    private var mReviewsList=ArrayList<ChatResult>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStatusBar(this,ContextCompat.getColor(this,R.color.colorPrimary))
        setContentView(R.layout.activity_reviews)
        initialization()
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

    override fun onButtonMainClick(activity_name: String) {

    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }

    override fun onDataClick(text: String, pos: Int, key_text: String) {
    }

    private fun initialization(){
        setToolBar()
        onViewClickListener()
        setAdapter()
    }

    private fun setToolBar(){
        tvToolBar.text="Reviews"
    }

    private fun onViewClickListener(){
        ivBack.setOnClickListener {
            onBackPressed()
        }
    }

    private fun setChatData(){
        val chatResult1= ChatResult(
            "0","Robert Hall","Seasme",
            R.drawable.userreview,"5.0")
        val chatResult2= ChatResult(
            "1","Ella","Wheat",
            R.drawable.user2,"4.6")
        val chatResult3= ChatResult(
            "2","Ruth","Seasme",
            R.drawable.userreview,"4.0")
        val chatResult4= ChatResult(
            "3","Dora","Seasme",
            R.drawable.user2,"2.8")
        val chatResult5= ChatResult(
            "4","Kayla","Corn",
            R.drawable.user2,"2.0")
        val chatResult6= ChatResult(
            "5","Robert Hall","Wheat",
            R.drawable.userreview,"5.0")
        val chatResult7= ChatResult(
            "5","Dora","Wheat",
            R.drawable.userreview,"2.0")
        mReviewsList.add(chatResult1)
        mReviewsList.add(chatResult2)
        mReviewsList.add(chatResult3)
        mReviewsList.add(chatResult4)
        mReviewsList.add(chatResult5)
        mReviewsList.add(chatResult6)
        mReviewsList.add(chatResult7)
    }

    private fun setAdapter(){
        setChatData()
        val mLayoutManager: LinearLayoutManager by lazy(LazyThreadSafetyMode.PUBLICATION) {
            LinearLayoutManager(this) }
        rvReviews.layoutManager = mLayoutManager
        rvReviews.setHasFixedSize(true)
        mChatListAdapter = ChatListAdapter(mReviewsList,this,2)
        rvReviews.adapter = mChatListAdapter
    }
}
