package com.example.ifarm.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.ifarm.activity.ProductDescriptionActivity
import com.example.ifarm.databinding.CustomCartRawlayoutBinding
import com.example.ifarm.databinding.CustomCompanyProductsRawlayoutBinding
import com.example.ifarm.interfaces.OnItemClickListner
import com.example.ifarm.model.CartResult
import com.svap.beep.abstractclasses.BaseBindingAdapter
import com.svap.beep.abstractclasses.BaseViewHolder
import kotlinx.android.synthetic.main.custom_company_products_rawlayout.view.*

class CompanyProductsAdpter(internal var mProductList:ArrayList<CartResult>,
                            internal var onItemClick: OnItemClickListner) :
    BaseBindingAdapter(mProductList) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        context = parent.context
        val binding = CustomCompanyProductsRawlayoutBinding.inflate(
            LayoutInflater.from(context), parent, false
        )
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return mProductList.size
    }

    inner class ViewHolder(var mBinding: CustomCompanyProductsRawlayoutBinding) : BaseViewHolder(mBinding.root) {
        override
        fun onBind(position: Int) {
            mBinding.model=mProductList[position]
            mBinding.executePendingBindings()
            mBinding.ivCartProduct.setImageResource(mProductList[position].image)

            mBinding.root.tvProductName.setOnClickListener {
                val intent=Intent(context,ProductDescriptionActivity::class.java)
                context?.startActivity(intent)
                //                onItemClick.onDataClick("1",position, AppConstants.NOTIFICATIONCLICK) }
            }

            mBinding.root.ivCartProduct.setOnClickListener {
                val intent=Intent(context,ProductDescriptionActivity::class.java)
                context?.startActivity(intent)
                //                onItemClick.onDataClick("1",position, AppConstants.NOTIFICATIONCLICK) }
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