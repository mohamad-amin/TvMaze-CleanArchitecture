package com.sixthsolution.easymvp.data.repository;

import com.sixthsolution.easymvp.data.network.FilmApi;
import com.sixthsolution.easymvp.domain.entity.Episode;
import com.sixthsolution.easymvp.domain.entity.Film;
import com.sixthsolution.easymvp.domain.repository.FilmRepository;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;

/**
 * @author MohamadAmin Mohamadi (mohammadi.mohamadamin@gmail.com) on 10/17/16.
 */
public class FilmDataRepository implements FilmRepository {

    private FilmApi filmApi;

    @Inject
    public FilmDataRepository(FilmApi filmApi) {
        this.filmApi = filmApi;
    }

    @Override
    public Observable<List<Film>> getFilms(int page) {
        return filmApi.getFilms(page);
    }

    @Override
    public Observable<Film> getFilm(String filmId) {
        return filmApi.getFilm(filmId);
    }

    @Override
    public Observable<List<Episode>> getFilmEpisodes(String filmId) {
        return filmApi.getEpisodes(filmId);
    }

    @Override
    public Observable<List<Episode>> getFilmSeasons(String filmId) {
        return filmApi.getSeasons(filmId);
    }

}
