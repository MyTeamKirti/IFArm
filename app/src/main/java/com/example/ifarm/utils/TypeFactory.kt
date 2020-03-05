package com.example.ifarm.utils

import android.content.Context
import android.graphics.Typeface
import androidx.core.content.res.ResourcesCompat
import com.example.ifarm.R

/**
 * Created by anupamchugh on 11/11/16.
 */

class TypeFactory(context: Context) {

     var sfUIDisplayBold: Typeface? = null
     var sfUIDisplayLight: Typeface? = null
     var sfUIDisplayMedium: Typeface? = null
     var sfUIDisplayRegular: Typeface? = null

    init {
        sfUIDisplayBold = ResourcesCompat.getFont(context, R.font.sf_ui_display_bold)
        sfUIDisplayLight = ResourcesCompat.getFont(context, R.font.sf_ui_display_light)
        sfUIDisplayMedium = ResourcesCompat.getFont(context, R.font.sf_ui_display_medium)
        sfUIDisplayRegular = ResourcesCompat.getFont(context, R.font.sf_ui_display_regular)
    }
}
