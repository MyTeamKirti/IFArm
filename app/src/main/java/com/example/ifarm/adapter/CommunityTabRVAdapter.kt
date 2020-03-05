package com.example.ifarm.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.ifarm.databinding.CustomCategoryTabsBinding
import com.example.ifarm.interfaces.OnItemClickListner
import com.example.ifarm.model.CategoryResult
import com.example.ifarm.utils.Constants
import com.svap.beep.abstractclasses.BaseBindingAdapter
import com.svap.beep.abstractclasses.BaseViewHolder
import kotlinx.android.synthetic.main.custom_category_tabs.view.*


class CommunityTabRVAdapter(internal var categoryList:ArrayList<CategoryResult>,
                            internal var onItemClick: OnItemClickListner):
    BaseBindingAdapter(categoryList) {

    var selectedPosition = -1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
            context = parent.context
            val binding = CustomCategoryTabsBinding.inflate(LayoutInflater.from(context), parent, false)
            return ViewHolder(binding)
        }

        override fun getItemCount(): Int {
            return categoryList.size
        }

    inner class ViewHolder(var mBinding: CustomCategoryTabsBinding):BaseViewHolder(mBinding.root){

        override fun onBind(position: Int) {
            mBinding.model = categoryList[position]


            if (selectedPosition == position) {
            }
            else {
            }

            if (selectedPosition==-1) {
                if (position == 0) {
                }
            }

            mBinding.root.linearTabButton.setOnClickListener {
                selectedPosition = position
                notifyDataSetChanged()
                onItemClick.onDataClick(categoryList[position]._id,position, Constants.CATEGORYCLICK)
            }
        }
    }

    }

