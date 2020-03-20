package com.example.ifarm.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.ifarm.databinding.CustomCommunityRawLayoutBinding
import com.example.ifarm.databinding.CustomSellerhomeRawlayoutBinding
import com.example.ifarm.interfaces.OnItemClickListner
import com.example.ifarm.model.ProductData1
import com.example.ifarm.utils.Constants
import com.svap.beep.abstractclasses.BaseBindingAdapter
import com.svap.beep.abstractclasses.BaseViewHolder


class CommunityListAdapter(internal var productList:ArrayList<ProductData1>,
                            internal var onItemClick: OnItemClickListner
):
    BaseBindingAdapter(productList) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        context = parent.context
        val binding = CustomCommunityRawLayoutBinding.inflate(LayoutInflater.from(context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return productList.size
    }

    inner class ViewHolder(var mBinding: CustomCommunityRawLayoutBinding): BaseViewHolder(mBinding.root){

        override fun onBind(position: Int) {
            mBinding.model = productList[position]
            mBinding.ivProduct.setImageResource(productList[position].imageURL)


            mBinding.root.setOnClickListener {
                onItemClick.onDataClick("",position, Constants.CATEGORYCLICK)
            }
        }
    }
}
