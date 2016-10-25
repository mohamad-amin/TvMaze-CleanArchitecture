package com.sixthsolution.easymvp.data.executor;

import javax.inject.Inject;
import javax.inject.Singleton;

import easymvp.executer.UseCaseExecutor;
import rx.Scheduler;
import rx.schedulers.Schedulers;

/**
 * @author MohamadAmin Mohamadi (mohammadi.mohamadamin@gmail.com) on 10/25/16.
 */
public class IoExecutor implements UseCaseExecutor {

    @Inject
    public IoExecutor() {}

    @Override
    public Scheduler getScheduler() {
        return Schedulers.io();
    }
}
