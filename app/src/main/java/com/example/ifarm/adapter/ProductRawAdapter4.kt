package com.example.ifarm.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.ifarm.activity.BuyerInfoActivity
import com.example.ifarm.activity.CompanyProductsActivity
import com.example.ifarm.activity.ProductDescriptionActivity
import com.example.ifarm.activity.ShopDetailsActivity
import com.example.ifarm.databinding.CustomRawRatedproductLayoutBinding
import com.example.ifarm.model.ProductData1
import com.svap.beep.abstractclasses.BaseBindingAdapter
import com.svap.beep.abstractclasses.BaseViewHolder

class ProductRawAdapter4(internal var productList:ArrayList<ProductData1>):
    BaseBindingAdapter(productList) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        context = parent.context
        val binding = CustomRawRatedproductLayoutBinding.inflate(LayoutInflater.from(context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return productList.size
    }

    inner class ViewHolder(var mBinding: CustomRawRatedproductLayoutBinding): BaseViewHolder(mBinding.root){

        override fun onBind(position: Int) {
            mBinding.model = productList[position]
            mBinding.ivRatedProducts.setImageResource(productList[position].imageURL)


            mBinding.root.setOnClickListener {
//                val intent= Intent(context, CompanyProductsActivity::class.java)
//                context?.startActivity(intent)
                val intent=Intent(context, ShopDetailsActivity::class.java)
                context?.startActivity(intent)
                //                onItemClick.onDataClick(categoryList[position]._id,position, Constants.CATEGORYCLICK)
            }
        }
    }
}