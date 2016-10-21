package com.sixthsolution.easymvp.tvmaze.presenter;

import com.sixthsolution.easymvp.domain.entity.Film;
import com.sixthsolution.easymvp.domain.interactor.base.UseCase;
import com.sixthsolution.easymvp.tvmaze.model.Constants;
import com.sixthsolution.easymvp.tvmaze.view.base.FilmsListView;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import easymvp.AbstractPresenter;
import rx.Subscriber;

/**
 * @author MohamadAmin Mohamadi (mohammadi.mohamadamin@gmail.com) on 10/20/16.
 */
public class FilmsListPresenter extends AbstractPresenter<FilmsListView> {

    UseCase getFilmsListUseCase;

    @Inject
    public FilmsListPresenter(@Named(Constants.FILMS_LIST) UseCase getFilmsListUseCase) {
        this.getFilmsListUseCase = getFilmsListUseCase;
    }

    private void loadFilms() {
        getFilmsListUseCase.execute(new FilmsListSubscriber());
    }

    public void reload() {
        getView().showProgressBar();
        loadFilms();
    }

    @Override
    public void onViewAttached(FilmsListView view) {
        super.onViewAttached(view);
        reload();
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
        public void onCompleted() {}

        @Override
        public void onError(Throwable e) {
            getView().showErrorView();
        }

        @Override
        public void onNext(List<Film> films) {
            getView().showFilms(films);
        }

    }

}
