package com.sixthsolution.easymvp.tvmaze.presenter;

import com.sixthsolution.easymvp.domain.entity.Film;
import com.sixthsolution.easymvp.domain.interactor.GetFilmsListUseCase;
import com.sixthsolution.easymvp.tvmaze.view.base.FilmsListView;

import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import easymvp.RxPresenter;
import easymvp.boundary.RxUseCase;
import rx.Subscriber;
import rx.Subscription;
import timber.log.Timber;

/**
 * @author MohamadAmin Mohamadi (mohammadi.mohamadamin@gmail.com) on 10/20/16.
 */
public class FilmsListPresenter extends RxPresenter<FilmsListView> {

    private GetFilmsListUseCase getFilmsListUseCase;
    private List<Film> data = Collections.emptyList();

    @Inject
    public FilmsListPresenter(GetFilmsListUseCase getFilmsListUseCase) {
        this.getFilmsListUseCase = getFilmsListUseCase;
    }

    private void loadFilms() {
        Timber.i("Going to load films");
        Subscription subscription = RxUseCase.with(getFilmsListUseCase)
                .execute(0)
                .noMapper()
//                .observeOn(getFilmsListUseCase.getUseCaseExecutor())
//                .subscribeOn(getFilmsListUseCase.getPostExecutionThread())
                .subscribe(new FilmsListSubscriber());
        addSubscription(subscription);
    }

    public void reload() {
        Timber.i("Reload called");
        getView().showProgressBar();
        loadFilms();
    }

    @Override
    public void onViewAttached(FilmsListView view) {
        super.onViewAttached(view);
        // Todo: Create a data store
        if (data.size() == 0) {
            reload();
        }
        Timber.i("OnViewAttached");
    }

    @Override
    public void onViewDetached() {
        super.onViewDetached();
    }

    @Override
    public void onDestroyed() {
        super.onDestroyed();
    }

    @Override
    public boolean isViewAttached() {
        return super.isViewAttached();
    }

    private final class FilmsListSubscriber extends Subscriber<List<Film>> {

        @Override
        public void onCompleted() {
            Timber.i("UseCase execution completed");
        }

        @Override
        public void onError(Throwable e) {
            Timber.d(e);
            getView().showErrorView();
        }

        @Override
        public void onNext(List<Film> films) {
            FilmsListPresenter.this.data = films;
            Timber.i("Films List Downloaded ^_^");
            getView().showFilms(films);
        }

    }

}
