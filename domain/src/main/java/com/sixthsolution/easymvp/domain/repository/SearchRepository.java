package com.sixthsolution.easymvp.domain.repository;


import com.sixthsolution.easymvp.domain.entity.Episode;
import com.sixthsolution.easymvp.domain.entity.Film;
import com.sixthsolution.easymvp.domain.entity.People;

import java.util.List;

import rx.Observable;

/**
 * @author MohamadAmin Mohamadi (mohammadi.mohamadamin@gmail.com) on 10/16/16.
 */
public interface SearchRepository {

    Observable<Film> singleSearchFilm(String query);

    Observable<List<Film>> searchFilms(String query);

    Observable<List<People>> searchPeople(String query);


}
