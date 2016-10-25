package com.sixthsolution.easymvp.tvmaze.internal.di.component;

import android.content.Context;

import com.sixthsolution.easymvp.data.network.FilmApi;
import com.sixthsolution.easymvp.data.network.SearchApi;
import com.sixthsolution.easymvp.tvmaze.internal.di.module.ApplicationModule;
import com.sixthsolution.easymvp.tvmaze.internal.di.module.GsonModule;
import com.sixthsolution.easymvp.tvmaze.internal.di.module.NetworkModule;
import com.sixthsolution.easymvp.tvmaze.view.base.BaseActivity;

import dagger.Component;
import easymvp.executer.PostExecutionThread;
import easymvp.executer.UseCaseExecutor;
import rx.Scheduler;

/**
 * @author MohamadAmin Mohamadi (mohammadi.mohamadamin@gmail.com) on 10/21/16.
 */
@Component(
        modules = {ApplicationModule.class, GsonModule.class, NetworkModule.class}
)
public interface ApplicationComponent {

    void inject(BaseActivity activity);

    Context provideContext();
    Scheduler provideScheduler();
    UseCaseExecutor provideUseCaseExecutor();
    PostExecutionThread providePostExecutionThread();

    FilmApi provideFilmApi();
    SearchApi provideSearchApi();

}
