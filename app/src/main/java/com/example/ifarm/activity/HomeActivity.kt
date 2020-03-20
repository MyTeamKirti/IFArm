package com.example.ifarm.activity

import android.annotation.SuppressLint
import android.annotation.TargetApi
import android.app.Activity
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.WindowManager
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ifarm.R
import com.example.ifarm.adapter.NavigationDrawerAdapter
import com.example.ifarm.fragment.*
import com.example.ifarm.interfaces.OnItemClickListner
import com.example.ifarm.utils.AppPreferences
import com.example.ifarm.utils.Constants
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.app_bar_home.*
import kotlinx.android.synthetic.main.content_home.*

class HomeActivity : AppCompatActivity(),OnItemClickListner {

    private var mDrawerIconList=ArrayList<Int>()
    private var mDrawerItemList=ArrayList<String>()
    private var doubleBackToExitPressed = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStatusBar(this,ContextCompat.getColor(this,R.color.colorPrimary))
        setContentView(R.layout.activity_home)
        initialization()
    }

    override fun onBackPressed() {
//        val fragments = supportFragmentManager.backStackEntryCount
//        if (fragments == 1) {
//            if (!doubleBackToExitPressed) {
//                this.doubleBackToExitPressed = true
//                Toast.makeText(this,resources.getString(R.string.back_exit_msg),Toast.LENGTH_SHORT).show()
////                showToast(resources.getString(R.string.back_exit_msg))
//            } else {
//                super.onBackPressed()
//                finish()
//            }
//        } else if (supportFragmentManager.backStackEntryCount > 1) {
//            supportFragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE)
////            loadFragment(HomeFragment(),"",supportFragmentManager.bace)
//            bottom_navigation.menu.getItem(0).isChecked = true
//        } else {
//            super.onBackPressed()
//        }
    }

    override fun onButtonMainClick(activity_name: String) {

    }

    @SuppressLint("WrongConstant")
    override fun onDataClick(text: String, pos: Int, key_text: String) {
        if (key_text == Constants.NAVIGATIONITEMCLICK) {
            when (pos) {
                0 -> {
                    val intent = Intent(this, OrderHistoryActivity::class.java)
                    startActivity(intent)
                }
                1 -> {
                    val intent = Intent(this, ReviewsActivity::class.java)
                    startActivity(intent)
                }
                2 -> {
                    val intent = Intent(this, AboutUsActivity::class.java)
                    startActivity(intent)
                }
                3 -> {
                    val intent = Intent(this, ContactusActivity::class.java)
                    startActivity(intent)
                }
                4 -> {
                    val intent = Intent(this, FAQActivity::class.java)
                    startActivity(intent)
                }
                5 -> {
                    val intent = Intent(this, RegistrationActivity::class.java)
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
                    startActivity(intent)
                    finish()
                }
            }
        }

    }

    @SuppressLint("WrongConstant")
    override fun onResume() {
        super.onResume()
    }

    private fun initialization(){
        setDrawerItems()
        setAdapter()
        navigateToHome()
        onViewClickListener()
        setBottomNavigationListener()
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

    private fun setDrawerItems(){
        mDrawerItemList.add("Order History")
        mDrawerItemList.add("Review")
        mDrawerItemList.add("About us")
        mDrawerItemList.add("Contact us")
        mDrawerItemList.add("FAQ's")
        mDrawerItemList.add("Log Out")

        mDrawerIconList.add(R.drawable.ic_orderhistory)
        mDrawerIconList.add(R.drawable.ic_review)
        mDrawerIconList.add(R.drawable.ic_aboutus)
        mDrawerIconList.add(R.drawable.ic_contactus)
        mDrawerIconList.add(R.drawable.ic_faqs)
        mDrawerIconList.add(R.drawable.ic_logout)
    }

    private fun setAdapter(){
        val mLayoutManager: LinearLayoutManager by lazy(LazyThreadSafetyMode.PUBLICATION) {
            LinearLayoutManager(this) }
        rvNavigationItems.layoutManager = mLayoutManager
        rvNavigationItems.setHasFixedSize(true)
        val navigationDrawerAdapter = NavigationDrawerAdapter(
            mDrawerItemList,mDrawerIconList,this)
        rvNavigationItems.adapter = navigationDrawerAdapter
    }

    private fun loadFragment(fragment: Fragment, fragmentTag:String,position: Int) {
        // load fragment
        if(!fragment.isAdded) {
            Log.d("fragmentTag",fragmentTag)
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.nav_host_fragment, fragment,fragmentTag)
            transaction.addToBackStack("HomeActivity")
            transaction.commit()
        }
        bottom_navigation.menu.getItem(position).isChecked = true
    }

    private fun setBottomNavigationListener(){
        bottom_navigation.menu.getItem(0).isChecked=true
        bottom_navigation.itemIconTintList=null

        bottom_navigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.navigationHome -> {
                        navigateToHome()
                }
                R.id.navigationShops -> {
                        loadFragment(ShopsFragment(),"",1)
                }
                R.id.navigationCommunity -> {
                        loadFragment(CommunityFragment(),"",2)
                }

                R.id.navigationProfie -> {
                    loadFragment(ProfileFragment(),"",3)
                }
            }
            false
        }
    }

    @SuppressLint("WrongConstant")
    private fun onViewClickListener(){
        ivNavigation.setOnClickListener {
            if(!drawerLayout.isDrawerOpen(Gravity.START))
                drawerLayout.openDrawer(Gravity.START)
            else
                drawerLayout.closeDrawer(Gravity.END)
        }
        ivCartHome.setOnClickListener {
            if (bottom_navigation.selectedItemId==R.id.navigationProfie){
                val intent=Intent(this,EditProfileActivity::class.java)
                startActivity(intent)
            }else{
                val intent=Intent(this,CartActivity::class.java)
                startActivity(intent)
            }
        }
    }

    private fun navigateToHome(){
        if (AppPreferences.readInteger(this, Constants.USERTYPE,0)==1)
            loadFragment(SellerHomeFragment(),"seller",0)
        else
            loadFragment(HomeFragment(),"Home",0)
    }
}
