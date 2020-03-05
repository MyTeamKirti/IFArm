package com.example.ifarm.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.ifarm.activity.CompanyProductsActivity
import com.example.ifarm.databinding.CustomCategoryLayoutBinding
import com.example.ifarm.model.ProductData1
import com.svap.beep.abstractclasses.BaseBindingAdapter
import com.svap.beep.abstractclasses.BaseViewHolder
import kotlinx.android.synthetic.main.custom_category_tabs.view.*

class ProductRawAdapter1(internal var productList:ArrayList<ProductData1>):
    BaseBindingAdapter(productList) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        context = parent.context
        val binding = CustomCategoryLayoutBinding.inflate(LayoutInflater.from(context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return productList.size
    }

    inner class ViewHolder(var mBinding: CustomCategoryLayoutBinding): BaseViewHolder(mBinding.root){

        override fun onBind(position: Int) {
            mBinding.model = productList[position]
            mBinding.ivCategoryHome.setImageResource(productList[position].imageURL)

            mBinding.root.setOnClickListener {
                val intent=Intent(context,CompanyProductsActivity::class.java)
                context?.startActivity(intent)
//                onItemClick.onDataClick(categoryList[position]._id,position, Constants.CATEGORYCLICK)
            }
        }
    }


}