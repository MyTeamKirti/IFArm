package com.example.ifarm.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.ifarm.activity.ProductDescriptionActivity
import com.example.ifarm.databinding.CustomCartRawlayoutBinding
import com.example.ifarm.interfaces.OnItemClickListner
import com.example.ifarm.model.CartResult
import com.svap.beep.abstractclasses.BaseBindingAdapter
import com.svap.beep.abstractclasses.BaseViewHolder

class CartListAdapter(internal var mCartist:ArrayList<CartResult>,
                      internal var onItemClick: OnItemClickListner) :
    BaseBindingAdapter(mCartist) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        context = parent.context
        val binding = CustomCartRawlayoutBinding.inflate(
            LayoutInflater.from(context), parent, false
        )
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return mCartist.size
    }

    inner class ViewHolder(var mBinding: CustomCartRawlayoutBinding) : BaseViewHolder(mBinding.root) {
        override
        fun onBind(position: Int) {
            mBinding.model=mCartist[position]
            mBinding.executePendingBindings()
            mBinding.ivCartProduct.setImageResource(mCartist[position].image)

            mBinding.root.setOnClickListener {
                val intent= Intent(context, ProductDescriptionActivity::class.java)
                context?.startActivity(intent)
                //onItemClick.onDataClick("1",position, AppConstants.NOTIFICATIONCLICK) }
            }

            mBinding.ivminusProduct.setOnClickListener {
                mBinding.tvQuantityUpdate.text= (mBinding.tvQuantityUpdate.text.toString().toInt()-1).toString()
            }

            mBinding.ivPlusProduct.setOnClickListener {
                mBinding.tvQuantityUpdate.text= (mBinding.tvQuantityUpdate.text.toString().toInt()+1).toString()
            }
        }


    }
}

