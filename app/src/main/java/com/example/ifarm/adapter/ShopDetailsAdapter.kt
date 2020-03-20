package com.example.ifarm.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ifarm.databinding.CustomChatLayoutBinding
import com.example.ifarm.databinding.CustomShopdetailRawLayoutBinding
import com.example.ifarm.interfaces.OnItemClickListner
import com.example.ifarm.model.ChatResult
import com.svap.beep.abstractclasses.BaseBindingAdapter
import com.svap.beep.abstractclasses.BaseViewHolder

class ShopDetailsAdapter(internal var onItemClick: OnItemClickListner,
                         internal var mShopDetailList:ArrayList<ChatResult>) :
    BaseBindingAdapter(mShopDetailList) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        context = parent.context
        val binding = CustomShopdetailRawLayoutBinding.inflate(
            LayoutInflater.from(context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return mShopDetailList.size
    }

    inner class ViewHolder(var mBinding: CustomShopdetailRawLayoutBinding) : BaseViewHolder(mBinding.root) {
        override
        fun onBind(position: Int) {
            mBinding.model = mShopDetailList[position]
            mBinding.executePendingBindings()
            mBinding.ivAvatar.setImageResource(mShopDetailList[position].imagePath)

            mBinding.root.setOnClickListener {
            }
        }
    }
}
