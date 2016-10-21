package com.sixthsolution.easymvp.tvmaze.presenter;

import com.sixthsolution.easymvp.domain.entity.Film;
import com.sixthsolution.easymvp.domain.interactor.base.UseCase;
import com.sixthsolution.easymvp.tvmaze.model.Constants;
import com.sixthsolution.easymvp.tvmaze.view.base.FilmDetailView;

import javax.inject.Inject;
import javax.inject.Named;

import easymvp.AbstractPresenter;
import rx.Subscriber;

/**
 * @author MohamadAmin Mohamadi (mohammadi.mohamadamin@gmail.com) on 10/20/16.
 */
public class FilmDetailPresenter extends AbstractPresenter<FilmDetailView> {

    UseCase getFilmDetailUseCase;

    @Inject
    public FilmDetailPresenter(@Named(Constants.FILM_DETAIL) UseCase getFilmDetailUseCase) {
        this.getFilmDetailUseCase = getFilmDetailUseCase;
    }

    private void loadFilms() {
        getFilmDetailUseCase.execute(new FilmDetailSubscriber());
    }

    @Override
    public void onViewAttached(FilmDetailView view) {
        super.onViewAttached(view);
        view.showProgressBar();
        loadFilms();
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

    private final class FilmDetailSubscriber extends Subscriber<Film> {

        @Override
        public void onCompleted() {}

        @Override
        public void onError(Throwable e) {
            getView().showErrorView();
        }

        @Override
        public void onNext(Film film) {
            getView().showFilm(film);
        }

    }

}
