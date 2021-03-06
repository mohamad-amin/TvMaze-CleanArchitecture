package com.sixthsolution.easymvp.tvmaze.view.base;

import android.content.Intent;

/**
 * @author MohamadAmin Mohamadi (mohammadi.mohamadamin@gmail.com) on 10/20/16.
 */
public interface BaseView {

    void showToast(String message);
    void showErrorView();
    void showProgressBar();
    Intent getComingIntent();

}
