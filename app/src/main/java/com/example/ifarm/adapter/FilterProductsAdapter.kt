package com.example.ifarm.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.ifarm.databinding.CustomFilterRawLayoutBinding
import com.example.ifarm.interfaces.OnItemClickListner
import com.example.ifarm.model.FilterOptionData
import com.svap.beep.abstractclasses.BaseBindingAdapter
import com.svap.beep.abstractclasses.BaseViewHolder

class FilterProductsAdapter (internal var onItemClick: OnItemClickListner,
                             internal var filterOptionsList:ArrayList<FilterOptionData>):
                             BaseBindingAdapter(filterOptionsList) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        context = parent.context
        val binding =
            CustomFilterRawLayoutBinding.inflate(LayoutInflater.from(context),parent,false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return filterOptionsList.size
    }

    inner class ViewHolder(var mBinding: CustomFilterRawLayoutBinding) :
        BaseViewHolder(mBinding.root) {

        override fun onBind(position: Int) {
            mBinding.model = filterOptionsList[position]
            mBinding.contraintFilter.setOnClickListener {

//                mBinding.checkboxFilter.isChecked = mBinding.checkboxFilter.isChecked==false
//                notifyItemChanged(position)

//                if (lastSelectedPosition == -1) {
//                    lastSelectedPosition = position
//                } else if (lastSelectedPosition != position) {
//                    lastSelectedPosition = position
//                }
//                filterOptionsList[lastSelectedPosition].isChecked = true
//
//                if (mSelectedPosition != lastSelectedPosition) {
//                    filterOptionsList[mSelectedPosition].isChecked = false
//                    notifyItemChanged(mSelectedPosition)
//                }
//                mSelectedPosition = lastSelectedPosition
//                notifyItemChanged(lastSelectedPosition)
//                onItemClick.onDataClick(
//                    filterOptionsList[position].id,
//                    position,
//                    AppConstants.REPORTOPTIONSCLICK
//                )

            }
        }
    }

}

