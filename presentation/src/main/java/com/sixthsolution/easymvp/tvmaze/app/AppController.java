package com.sixthsolution.easymvp.tvmaze.app;

import android.app.Application;
import android.support.design.BuildConfig;

import com.sixthsolution.easymvp.tvmaze.internal.di.component.ApplicationComponent;
import com.sixthsolution.easymvp.tvmaze.internal.di.component.DaggerApplicationComponent;
import com.sixthsolution.easymvp.tvmaze.internal.di.component.DaggerDataComponent;
import com.sixthsolution.easymvp.tvmaze.internal.di.component.DataComponent;
import com.sixthsolution.easymvp.tvmaze.internal.di.module.ApplicationModule;
import com.squareup.leakcanary.LeakCanary;

import timber.log.Timber;

/**
 * @author MohamadAmin Mohamadi (mohammadi.mohamadamin@gmail.com) on 10/19/16.
 */
public class AppController extends Application {

    private ApplicationComponent applicationComponent;
    private DataComponent dataComponent;

    @Override
    public void onCreate() {

        super.onCreate();

        Timber.plant(new Timber.DebugTree());
        Timber.i("Initialized Timber with DebugTree");

        initializeInjector();
        initializeLeakDetector();

    }

    private void initializeInjector() {

        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
        Timber.i("Initialized application component");

        dataComponent = DaggerDataComponent.builder()
                .applicationComponent(applicationComponent)
                .build();
        Timber.i("Initialized data component");

    }

    private void initializeLeakDetector() {
        if (BuildConfig.DEBUG) {
            Timber.i("Installing leak canary in debug build for detecting memory leaks");
            LeakCanary.install(this);
        }
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }

    public DataComponent getDataComponent() {
        return dataComponent;
    }

}
