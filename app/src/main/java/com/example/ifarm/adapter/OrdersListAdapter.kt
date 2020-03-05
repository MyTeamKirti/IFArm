package com.example.ifarm.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.ifarm.databinding.CustomOrderRawlayoutBinding
import com.example.ifarm.interfaces.OnItemClickListner
import com.example.ifarm.model.CartResult
import com.svap.beep.abstractclasses.BaseBindingAdapter
import com.svap.beep.abstractclasses.BaseViewHolder

class OrdersListAdapter(internal var mOrdersList:ArrayList<CartResult>,
                        internal var onItemClick: OnItemClickListner
) :
    BaseBindingAdapter(mOrdersList) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        context = parent.context
        val binding = CustomOrderRawlayoutBinding.inflate(
            LayoutInflater.from(context), parent, false
        )
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return mOrdersList.size
    }

    inner class ViewHolder(var mBinding: CustomOrderRawlayoutBinding) : BaseViewHolder(mBinding.root) {
        override
        fun onBind(position: Int) {
            mBinding.model=mOrdersList[position]
            mBinding.executePendingBindings()
            mBinding.ivOrderProduct.setImageResource(mOrdersList[position].image)

            mBinding.root.setOnClickListener {
                //                onItemClick.onDataClick("1",position, AppConstants.NOTIFICATIONCLICK) }
            }

        }
    }
}
