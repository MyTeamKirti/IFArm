package com.example.ifarm.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ifarm.interfaces.OnItemClickListner
import com.example.ifarm.model.CategoryResult
import com.example.ifarm.utils.Constants
import com.svap.beep.abstractclasses.BaseBindingAdapter
import com.svap.beep.abstractclasses.BaseViewHolder
import com.example.ifarm.databinding.CustomCategoryTabsBinding
import android.R
import android.R.attr.font
import androidx.core.content.res.ResourcesCompat
import android.graphics.Typeface




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
                mBinding.tabIndicator.visibility= View.VISIBLE
                mBinding.tvCategoryName.setTypeface(null, Typeface.BOLD)

//                val face = Typeface.createFromAsset(context?.assets, "font/sf_ui_display_bold.ttf")
//                mBinding.tvCategoryName.typeface = face

            }
            else {
                mBinding.tabIndicator.visibility= View.GONE
                mBinding.tvCategoryName.setTypeface(null, Typeface.NORMAL)

//                val face = Typeface.createFromAsset(context?.assets, "font/sf_ui_display_regular.ttf")
//                mBinding.tvCategoryName.typeface = face

            }

            if (selectedPosition==-1) {
                if (position == 0) {
                    mBinding.tabIndicator.visibility= View.VISIBLE
                    mBinding.tvCategoryName.setTypeface(null, Typeface.BOLD)

//                    val face = Typeface.createFromAsset(context?.assets, R.)
//                    mBinding.tvCategoryName.typeface = typeface
                }
            }

            mBinding.linearTabButton.setOnClickListener {
                selectedPosition = position
                notifyDataSetChanged()
                onItemClick.onDataClick(categoryList[position]._id,position, Constants.CATEGORYCLICK)
            }
        }
    }

    }

