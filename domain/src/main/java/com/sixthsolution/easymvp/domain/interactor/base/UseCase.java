package com.sixthsolution.easymvp.domain.interactor.base;

import com.sixthsolution.easymvp.domain.executor.PostExecutionThread;

import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
import rx.Subscription;
import rx.subscriptions.Subscriptions;

/**
 * @author MohamadAmin Mohamadi (mohammadi.mohamadamin@gmail.com) on 10/16/16.
 */
public abstract class UseCase {

    private final Scheduler scheduler;
    private final PostExecutionThread postExecutionThread;
    private Subscription subscription = Subscriptions.empty();

    protected UseCase(Scheduler scheduler, PostExecutionThread postExecutionThread) {
        this.scheduler = scheduler;
        this.postExecutionThread = postExecutionThread;
    }

    protected abstract Observable getTask();

    @SuppressWarnings("unchecked")
    public void execute(Subscriber useCaseSubscriber) {
        this.subscription = getTask()
                .subscribeOn(scheduler)
                .observeOn(postExecutionThread.getScheduler())
                .subscribe(useCaseSubscriber);
    }

    public void unsubscribe() {
        if (!subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }
    }

}
