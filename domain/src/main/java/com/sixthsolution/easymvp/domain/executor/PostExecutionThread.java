package com.sixthsolution.easymvp.domain.executor;

import rx.Scheduler;

/**
 * @author MohamadAmin Mohamadi (mohammadi.mohamadamin@gmail.com) on 10/16/16.
 */
public interface PostExecutionThread {

    Scheduler getScheduler();

}
