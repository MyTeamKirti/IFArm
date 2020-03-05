package com.example.ifarm.utils;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatButton;
import com.example.ifarm.R;

public class CustomButton extends AppCompatButton {

    private TypeFactory mFontFactory;

    public CustomButton(Context context, AttributeSet attrs) {
        super(context, attrs);

        applyCustomFont(context, attrs);
    }

    public CustomButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        applyCustomFont(context, attrs);
    }

    public CustomButton(Context context) {
        super(context);
    }

    private void applyCustomFont(Context context, AttributeSet attrs) {
        TypedArray array = context.getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.CustomTextView,
                0, 0);
        int typefaceType;
        try {
            typefaceType = array.getInteger(R.styleable.CustomTextView_font_name, 0);
        } finally {
            array.recycle();
        }
        if (!isInEditMode()) {
            setTypeface(getTypeFace(typefaceType));
        }

    }

    private Typeface getTypeFace(int type) {
        if (mFontFactory == null)
            mFontFactory = new TypeFactory(getContext());

        switch (type) {
            case Constants.bold:
                return mFontFactory.getSfUIDisplayBold();

            case Constants.light:
                return mFontFactory.getSfUIDisplayLight();

            case Constants.medium:
                return mFontFactory.getSfUIDisplayMedium();

            default:
                return mFontFactory.getSfUIDisplayRegular();
        }
    }

    interface Constants {
        int bold = 1,
                medium = 2,
                light = 5;
    }
}

