package com.example.ifarm.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ifarm.databinding.CustomDrawerItemBinding
import com.example.ifarm.interfaces.OnItemClickListner
import com.example.ifarm.utils.Constants
import com.svap.beep.abstractclasses.BaseBindingAdapter
import com.svap.beep.abstractclasses.BaseViewHolder
import kotlin.collections.ArrayList

class NavigationDrawerAdapter(internal var mDrawerItemsList:ArrayList<String>,
                              internal var mDrawerIconsList:ArrayList<Int>,
                              internal var onItemClick: OnItemClickListner) :
    BaseBindingAdapter(mDrawerItemsList) {


    override fun onCreateViewHolder(parent: ViewGroup,viewType: Int): BaseViewHolder {
        context = parent.context
        val binding = CustomDrawerItemBinding.inflate(
            LayoutInflater.from(context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return mDrawerItemsList.size
    }

    inner class ViewHolder(var mBinding: CustomDrawerItemBinding): BaseViewHolder(mBinding.root)
    {
        override
        fun onBind(position: Int) {

             mBinding.tvDrawerItem.text=mDrawerItemsList[position]
             mBinding.executePendingBindings()

            mBinding.ivDrawerItem.setImageResource(mDrawerIconsList[position])

            if (mDrawerItemsList.size-1==position)
                mBinding.ivNext.visibility=View.GONE
            else
                mBinding.ivNext.visibility=View.VISIBLE


            mBinding.root.setOnClickListener {
                onItemClick.onDataClick("1",position,Constants.NAVIGATIONITEMCLICK)
                }
        }
    }
}