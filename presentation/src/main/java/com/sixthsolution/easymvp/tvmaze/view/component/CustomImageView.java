package com.sixthsolution.easymvp.tvmaze.view.component;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

/*
 * This class is obtained from a stack overflow question
 * This view is used in grid views to automatically set proper size to image view.
 */
public class CustomImageView extends ImageView {

    public CustomImageView(Context context) {
        super(context);
    }

    public CustomImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(getMeasuredWidth(), getMeasuredWidth());
    }

}