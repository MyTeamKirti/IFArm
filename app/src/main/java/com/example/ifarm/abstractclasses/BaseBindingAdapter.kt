package com.svap.beep.abstractclasses

import android.content.Context
import androidx.recyclerview.widget.RecyclerView

abstract class BaseBindingAdapter(var list: ArrayList<*>) : RecyclerView.Adapter<BaseViewHolder>() {
    var context: Context? = null
    var mColorInt = 0
    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.onBind(position)
    }

}