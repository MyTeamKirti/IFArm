package com.example.ifarm.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ifarm.R
import com.example.ifarm.activity.BuyerInfoActivity
import com.example.ifarm.activity.ShopDetailsActivity
import com.example.ifarm.databinding.CustomExchangeLayoutBinding
import com.example.ifarm.databinding.CustomTrendingLayoutBinding
import com.example.ifarm.model.ProductData1
import com.svap.beep.abstractclasses.BaseBindingAdapter
import com.svap.beep.abstractclasses.BaseViewHolder
import kotlinx.android.synthetic.main.custom_exchange_layout.view.*
import kotlinx.android.synthetic.main.custom_trending_layout.view.*

class ProductRawAdapter3(internal var productList:ArrayList<ProductData1>):
    BaseBindingAdapter(productList) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        context = parent.context
        val binding = CustomExchangeLayoutBinding.inflate(LayoutInflater.from(context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return productList.size
    }

    inner class ViewHolder(var mBinding: CustomExchangeLayoutBinding): BaseViewHolder(mBinding.root){

        override fun onBind(position: Int) {
            mBinding.model = productList[position]
            mBinding.ivProduct.setImageResource(productList[position].imageURL)

            mBinding.root.setOnClickListener {
//                val intent= Intent(context, BuyerInfoActivity::class.java)
//                context?.startActivity(intent)
                val intent=Intent(context, ShopDetailsActivity::class.java)
                context?.startActivity(intent)
                //                onItemClick.onDataClick(categoryList[position]._id,position, Constants.CATEGORYCLICK)
            }
        }
    }


}