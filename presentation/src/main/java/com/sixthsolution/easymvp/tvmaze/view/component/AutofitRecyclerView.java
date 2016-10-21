package com.sixthsolution.easymvp.tvmaze.view.component;

import android.content.Context;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.AttributeSet;

import com.marshalchen.ultimaterecyclerview.UltimateRecyclerView;
import com.sixthsolution.easymvp.tvmaze.R;

/*
 * A recycler view that automatically chooses span count to best fit the device's screen size.
 */
public class AutofitRecyclerView extends UltimateRecyclerView {

    private StaggeredGridLayoutManager manager;
    private int columnWidth;

    public AutofitRecyclerView(Context context, AttributeSet attrs){
        super(context, attrs);
        init();
    }

    public AutofitRecyclerView(Context context) {
        super(context);
        init();
    }

    public AutofitRecyclerView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init() {
        columnWidth = (int) getResources().getDimension(R.dimen.column_width);
        manager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        setLayoutManager(manager);
    }

    @Override
    protected void onMeasure(int widthSpec, int heightSpec) {
        super.onMeasure(widthSpec, heightSpec);
        if (columnWidth > 0) {
            int spanCount = Math.max(1, getMeasuredWidth() / columnWidth);
            manager.setSpanCount(spanCount);
        }
    }

}
