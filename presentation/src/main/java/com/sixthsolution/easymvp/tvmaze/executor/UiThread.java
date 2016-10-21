package com.sixthsolution.easymvp.tvmaze.executor;

import com.sixthsolution.easymvp.domain.executor.PostExecutionThread;

import javax.inject.Inject;

import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;

/**
 * @author MohamadAmin Mohamadi (mohammadi.mohamadamin@gmail.com) on 10/19/16.
 */
public class UiThread implements PostExecutionThread {

    @Inject
    public UiThread() {}

    @Override
    public Scheduler getScheduler() {
        return AndroidSchedulers.mainThread();
    }

}
