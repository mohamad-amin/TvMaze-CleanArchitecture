package com.sixthsolution.easymvp.tvmaze.app;

import android.app.Application;
import android.support.design.BuildConfig;

import com.sixthsolution.easymvp.tvmaze.internal.di.component.ApplicationComponent;
import com.sixthsolution.easymvp.tvmaze.internal.di.component.DaggerApplicationComponent;
import com.sixthsolution.easymvp.tvmaze.internal.di.module.ApplicationModule;
import com.squareup.leakcanary.LeakCanary;

/**
 * @author MohamadAmin Mohamadi (mohammadi.mohamadamin@gmail.com) on 10/19/16.
 */
public class AppController extends Application {

    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        initializeInjector();
        initializeLeakDetector();
    }

    private void initializeInjector() {

        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();

    }

    private void initializeLeakDetector() {
        if (BuildConfig.DEBUG) {
            LeakCanary.install(this);
        }
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }

}
