package com.sixthsolution.easymvp.tvmaze.internal.di.module;

import android.content.Context;

import com.sixthsolution.easymvp.domain.executor.PostExecutionThread;
import com.sixthsolution.easymvp.tvmaze.app.AppController;
import com.sixthsolution.easymvp.tvmaze.executor.UiThread;

import dagger.Module;
import dagger.Provides;
import rx.Scheduler;
import rx.schedulers.Schedulers;

/**
 * @author MohamadAmin Mohamadi (mohammadi.mohamadamin@gmail.com) on 10/21/16.
 */
@Module
public class ApplicationModule {

    private final AppController appController;

    public ApplicationModule(AppController appController) {
        this.appController = appController;
    }

    @Provides
    Context provideApplicationContext() {
        return appController;
    }

    @Provides
    Scheduler provideScheduler() {
        return Schedulers.io();
    }

    @Provides
    PostExecutionThread providePostExecutionThread(UiThread uiThread) {
        return uiThread;
    }

}
