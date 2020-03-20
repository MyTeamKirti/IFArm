package com.example.ifarm.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import com.example.ifarm.R
import com.example.ifarm.databinding.CustomChatLayoutBinding
import com.example.ifarm.interfaces.OnItemClickListner
import com.example.ifarm.model.ChatResult
import com.svap.beep.abstractclasses.BaseBindingAdapter
import com.svap.beep.abstractclasses.BaseViewHolder
import kotlin.collections.ArrayList

class ChatListAdapter(internal var mChatList:ArrayList<ChatResult>,
                      internal var onItemClick: OnItemClickListner,
                      internal var isComingFrom:Int) :
    BaseBindingAdapter(mChatList) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        context = parent.context
        val binding = CustomChatLayoutBinding.inflate(
            LayoutInflater.from(context), parent, false
        )
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return mChatList.size
    }

    inner class ViewHolder(var mBinding: CustomChatLayoutBinding) : BaseViewHolder(mBinding.root) {
        override
        fun onBind(position: Int) {
            mBinding.model = mChatList[position]
            mBinding.executePendingBindings()
            mBinding.ivAvatar.setImageResource(mChatList[position].imagePath)

            if (isComingFrom==1){
                mBinding.tvRating.visibility= View.GONE
                mBinding.tvTime.visibility=View.VISIBLE
            } else if (isComingFrom==2){
                mBinding.tvRating.visibility= View.VISIBLE
                mBinding.tvTime.visibility=View.GONE
            } else if (isComingFrom==3){
                mBinding.indicatorBuySell.visibility=View.VISIBLE
                mBinding.tvRating.visibility= View.GONE
                mBinding.tvTime.visibility=View.GONE

                if (mBinding.tvMessage.text=="Buyer"){
                    context?.let { ContextCompat.getColor(it, R.color.colorBuyerBlue)
                    }?.let { mBinding.indicatorBuySell.setBackgroundColor(it) }

                    context?.let { ContextCompat.getColor(it, R.color.colorBuyerBlue) }?.let {
                        mBinding.tvMessage.setTextColor(it) }
                }
                else{
                    context?.let {ContextCompat.getColor(it, R.color.colorPrimary)
                    }?.let { mBinding.indicatorBuySell.setBackgroundColor(it) }

                    context?.let { ContextCompat.getColor(it, R.color.colorPrimary) }?.let {
                        mBinding.tvMessage.setTextColor(it) }
                }

            }

            mBinding.root.setOnClickListener {
                //                onItemClick.onDataClick("1",position, AppConstants.NOTIFICATIONCLICK) }
            }
        }
    }
}


