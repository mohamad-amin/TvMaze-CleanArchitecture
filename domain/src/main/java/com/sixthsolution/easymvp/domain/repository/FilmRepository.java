package com.sixthsolution.easymvp.domain.repository;


import com.sixthsolution.easymvp.domain.entity.Episode;
import com.sixthsolution.easymvp.domain.entity.Film;

import java.util.List;

import rx.Observable;

/**
 * @author MohamadAmin Mohamadi (mohammadi.mohamadamin@gmail.com) on 10/16/16.
 */
public interface FilmRepository {

    Observable<List<Film>> getFilms(int page);

    Observable<Film> getFilm(String filmId);

    Observable<List<Episode>> getFilmEpisodes(String filmId);

    Observable<List<Episode>> getFilmSeasons(String filmId);

}
