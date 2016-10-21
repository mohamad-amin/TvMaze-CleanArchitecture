package com.sixthsolution.easymvp.tvmaze.internal.di.module;

import android.app.Activity;

import com.sixthsolution.easymvp.tvmaze.view.base.BaseActivity;

import dagger.Module;
import dagger.Provides;

/**
 * @author MohamadAmin Mohamadi (mohammadi.mohamadamin@gmail.com) on 10/21/16.
 */
@Module
public class ActivityModule {

    private BaseActivity activity;

    public ActivityModule(BaseActivity activity) {
        this.activity = activity;
    }

    @Provides
    public BaseActivity provideBaseActivity() {
        return activity;
    }

    @Provides
    public Activity provideActivity() {
        return activity;
    }

}
