package com.example.ifarm.adapter

import android.util.SparseBooleanArray
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import com.example.ifarm.R
import com.example.ifarm.databinding.CustomSubscriptionRawLayoutBinding
import com.example.ifarm.model.SubscriptionResult
import com.svap.beep.abstractclasses.BaseBindingAdapter
import com.svap.beep.abstractclasses.BaseViewHolder

class SubscriptionPlanAdapter(internal var onItemClick: OnRecyclerViewItemClickListener,
                              private var mSubscriptionsList:ArrayList<SubscriptionResult>):
    BaseBindingAdapter(mSubscriptionsList) {

        private var mSelectedCount=0
        private val mSparseBooleanArray = SparseBooleanArray()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        context = parent.context
        val binding = CustomSubscriptionRawLayoutBinding.inflate(
            LayoutInflater.from(context), parent, false
        )
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return mSubscriptionsList.size
    }

    inner class ViewHolder(var mBinding: CustomSubscriptionRawLayoutBinding) : BaseViewHolder(mBinding.root) {
        override
        fun onBind(position: Int) {
            mBinding.model = mSubscriptionsList[position]
            mBinding.executePendingBindings()

            if (mSubscriptionsList[position].isSelectedInterest)
            mSparseBooleanArray.put(position, true)

//            Glide.with(context).load(categoryPojoList[position].selectedImagePath).placeholder(R.drawable.load_img).into(holder.itemView.ivCategory)

        mBinding.constraintSubscription.setOnClickListener {
            if (!mSparseBooleanArray.get(position))
            {
                mSparseBooleanArray.put(position, true)
                mSubscriptionsList[position].isSelectedInterest=true
                mSelectedCount++
                onItemClick.selectedItemCount("0",position,mSelectedCount) // calling the method in main activity Because: in our case mainActivity our created interface for clicklisteners
                notifyItemChanged(position)

            }
            else // if clicked item is already selected
            {
                if (mSubscriptionsList[position].isSelectedInterest)
                    mSubscriptionsList[position].isSelectedInterest=false
                mSparseBooleanArray.put(position,false)
                mSelectedCount--
                onItemClick.selectedItemCount("0",position,mSelectedCount) // calling the method in main activity Because: in our case mainActivity our created interface for clicklisteners
                notifyItemChanged(position)
            }
        }
        setBackgroundSelected(position,mBinding)

        mBinding.root.setOnClickListener {
                //                onItemClick.onDataClick("1",position, AppConstants.NOTIFICATIONCLICK) }
            }
        }
    }

    private fun setBackgroundSelected(position:Int,mBinding: CustomSubscriptionRawLayoutBinding){
        if (mSparseBooleanArray.get(position)) {
            mBinding.constraintSubscription.background= context?.let {
                ContextCompat.getDrawable(it, R.drawable.button_fillbg) }
            context?.let { ContextCompat.getColor(it,R.color.colorWhite) }?.let {
                mBinding.tvSubsciptionValue.setTextColor(it) }
            context?.let { ContextCompat.getColor(it,R.color.colorWhite) }?.let {
                mBinding.tvSubscriptionWeek.setTextColor(it) }
            context?.let { ContextCompat.getColor(it,R.color.colorWhite) }?.let {
                mBinding.tvPriceValue.setTextColor(it) }
        }
        else{
            mBinding.constraintSubscription.background= context?.let {
                ContextCompat.getDrawable(it, R.drawable.rectangle_radiuswhite_bg) }

            context?.let { ContextCompat.getColor(it,R.color.colorTextGrey) }?.let {
                mBinding.tvSubsciptionValue.setTextColor(it) }
            context?.let { ContextCompat.getColor(it,R.color.colorTextGrey) }?.let {
                mBinding.tvSubscriptionWeek.setTextColor(it) }
            context?.let { ContextCompat.getColor(it,R.color.colorPrimary) }?.let {
                mBinding.tvPriceValue.setTextColor(it) }

//            context.let { Glide.with(it).load(categoryPojoList[position].unselectedImagePath).into(holder.itemView.ivCategory) }
        }
    }

    interface OnRecyclerViewItemClickListener {
        fun selectedItemCount(id:String,position: Int,count: Int)
    }
}
