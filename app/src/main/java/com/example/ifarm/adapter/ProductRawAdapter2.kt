package com.example.ifarm.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ifarm.activity.CompanyInfoActivity
import com.example.ifarm.activity.CompanyProductsActivity
import com.example.ifarm.activity.ShopDetailsActivity
import com.example.ifarm.databinding.CustomTrendingLayoutBinding
import com.example.ifarm.model.ProductData1
import com.svap.beep.abstractclasses.BaseBindingAdapter
import com.svap.beep.abstractclasses.BaseViewHolder

class ProductRawAdapter2(internal var productList:ArrayList<ProductData1>,
                         internal var currentFrag:Int):
    BaseBindingAdapter(productList) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        context = parent.context
        val binding = CustomTrendingLayoutBinding.inflate(LayoutInflater.from(context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return productList.size
    }

    inner class ViewHolder(var mBinding: CustomTrendingLayoutBinding): BaseViewHolder(mBinding.root){

        override fun onBind(position: Int) {
            mBinding.model = productList[position]
            mBinding.ivTrendingProduct.setImageResource(productList[position].imageURL)
            if(currentFrag==0)
                mBinding.ivNextProduct.visibility=View.GONE
            else
                mBinding.ivNextProduct.visibility=View.VISIBLE

            mBinding.root.setOnClickListener {
//                val intent=Intent(context,CompanyInfoActivity::class.java)
//                context?.startActivity(intent)
                val intent=Intent(context, ShopDetailsActivity::class.java)
                context?.startActivity(intent)
                // onItemClick.onDataClick(categoryList[position]._id,position, Constants.CATEGORYCLICK)
            }
        }
    }


}