package com.example.ifarm.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.ifarm.activity.ShopDetailsActivity
import com.example.ifarm.databinding.CustomRawRatedproductLayoutBinding
import com.example.ifarm.databinding.CustomTopRatedproductsRawlayoutBinding
import com.example.ifarm.model.ProductData1
import com.svap.beep.abstractclasses.BaseBindingAdapter
import com.svap.beep.abstractclasses.BaseViewHolder

class ProductRawAdapter5(internal var productList:ArrayList<ProductData1>):
                                BaseBindingAdapter(productList) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        context = parent.context
        val binding = CustomTopRatedproductsRawlayoutBinding.inflate(LayoutInflater.from(context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return productList.size
    }

    inner class ViewHolder(var mBinding: CustomTopRatedproductsRawlayoutBinding): BaseViewHolder(mBinding.root){

        override fun onBind(position: Int) {
            mBinding.model = productList[position]
            mBinding.ivProduct.setImageResource(productList[position].imageURL)

            mBinding.root.setOnClickListener {
                val intent= Intent(context, ShopDetailsActivity::class.java)
                context?.startActivity(intent)
//                onItemClick.onDataClick(categoryList[position]._id,position, Constants.CATEGORYCLICK)
            }
        }
    }
}