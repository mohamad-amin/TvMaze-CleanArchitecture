package com.sixthsolution.easymvp.tvmaze.presenter;

import android.text.TextUtils;

import com.sixthsolution.easymvp.domain.entity.Film;
import com.sixthsolution.easymvp.domain.entity.Producer;
import com.sixthsolution.easymvp.domain.entity.Schedule;
import com.sixthsolution.easymvp.domain.interactor.GetFilmDetailsUseCase;
import com.sixthsolution.easymvp.tvmaze.model.Constants;
import com.sixthsolution.easymvp.tvmaze.view.base.FilmDetailView;

import org.parceler.Parcels;

import javax.inject.Inject;

import easymvp.AbstractPresenter;
import rx.Subscriber;
import timber.log.Timber;

/**
 * @author MohamadAmin Mohamadi (mohammadi.mohamadamin@gmail.com) on 10/20/16.
 */
public class FilmDetailPresenter extends AbstractPresenter<FilmDetailView> {

    private GetFilmDetailsUseCase getFilmDetailUseCase;
    private Film film;

    @Inject
    public FilmDetailPresenter(GetFilmDetailsUseCase getFilmDetailUseCase) {
        this.getFilmDetailUseCase = getFilmDetailUseCase;
    }

    private void loadFilmDetail() {

        Timber.i("Loading film's detail from internet");
//        getFilmDetailUseCase.execute(new FilmDetailSubscriber());

        if (getView() == null) {
            return;
        }

        getView().showSummary(film.getSummary());
        getView().showTitle(film.getName());
        getView().showType(film.getType());
        getView().showLanguage(film.getLanguage());
        getView().showRate(film.getRating().getAverage());
        getView().showGenres(TextUtils.join(" | ", film.getGenres()));
        getView().showStatus(film.getStatus());

        Producer producer = film.getNetwork();
        getView().showNetwork(producer.getName() + " -- " + producer.getCountry().getName());

        Schedule schedule = film.getSchedule();
        getView().showSchedule(TextUtils.join(", ", schedule.getDays()) + " at " + schedule.getTime());
        getView().showRuntime(film.getRuntime() + "");

    }

    @Override
    public void onViewAttached(FilmDetailView view) {
        super.onViewAttached(view);
        Timber.i("View attached to FilmDetailPresenter");
        film = Parcels.unwrap(view.getComingIntent().getParcelableExtra(Constants.EXTRA_FILM));
        view.showProgressBar();
        loadFilmDetail();
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
        public void onCompleted() {
            Timber.i("Done loading film's detail");
        }

        @Override
        public void onError(Throwable e) {
            Timber.i(e);
            getView().showErrorView();
        }

        @Override
        public void onNext(Film film) {
            Timber.i("Successfully got film's detail ^_^");
            // TODO: 10/25/16
        }

    }

}
