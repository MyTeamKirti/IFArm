package com.example.ifarm.fragment

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.TypedValue
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.ifarm.R
import com.example.ifarm.activity.HomeActivity
import com.example.ifarm.activity.SellerProductDesActivity
import com.example.ifarm.adapter.SellerHomeListAdapter
import com.example.ifarm.interfaces.OnItemClickListner
import com.example.ifarm.model.ProductData1
import com.example.ifarm.utils.GridSpacingItemDecoration
import kotlinx.android.synthetic.main.app_bar_home.*
import kotlinx.android.synthetic.main.fragment_seller_home.*
import kotlin.math.roundToInt

class SellerHomeFragment : Fragment(),OnItemClickListner {

    private val mParentRef by lazy { activity as HomeActivity }
    private var mCartListAdapter: SellerHomeListAdapter? = null
    private var mCartList=ArrayList<ProductData1>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_seller_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initalization()
    }

    override fun onButtonMainClick(activity_name: String) {

    }

    override fun onDataClick(text: String, pos: Int, key_text: String) {
        val intent=Intent(activity,SellerProductDesActivity::class.java)
        startActivity(intent)
    }

    private fun initalization(){
        setToolBar()
        setAdapter()
    }

    private fun setToolBar(){
        mParentRef.tvToolBar.text="I-Farm"
        mParentRef.ivCartHome.visibility=View.GONE
    }



    private fun setCartData(){
        val data19= ProductData1("0","Sesame",R.drawable.exproduct,"1 kg","\$ 250")
        val data20= ProductData1("1","Hemp",R.drawable.exproduct,"1 kg","\$ 250")
        val data21= ProductData1("2","Pumpkin",R.drawable.exproduct,"1 kg","\$ 250")
        val data22= ProductData1("3","Sesame",R.drawable.exproduct,"1 kg","\$ 250")
        mCartList.add(data19)
        mCartList.add(data20)
        mCartList.add(data21)
        mCartList.add(data22)
        mCartList.add(data22)
        mCartList.add(data19)
        mCartList.add(data20)
        mCartList.add(data21)
        mCartList.add(data22)
        mCartList.add(data22)
        mCartList.add(data19)
        mCartList.add(data20)
        mCartList.add(data21)
        mCartList.add(data22)
        mCartList.add(data22)
        mCartList.add(data22)

    }

    private fun setAdapter(){
        setCartData()
        val mLayoutManager = GridLayoutManager(context, 2)
        rvSellerProducts.layoutManager = mLayoutManager
        mCartListAdapter = SellerHomeListAdapter(mCartList,this)
        rvSellerProducts.adapter = mCartListAdapter
        activity?.let { dpToPx(it, 16) }?.let {
            GridSpacingItemDecoration(
                2,
                it, true
            )
        }?.let { rvSellerProducts?.addItemDecoration(it) }

    }

    private fun dpToPx(context: Context, dp: Int): Int {
        val r = context.resources
        return TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP,
            dp.toFloat(),
            r.displayMetrics
        ).roundToInt()
    }


}
