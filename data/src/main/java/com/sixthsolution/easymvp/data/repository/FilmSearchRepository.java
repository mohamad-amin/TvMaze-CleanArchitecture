package com.sixthsolution.easymvp.data.repository;

import com.sixthsolution.easymvp.data.network.SearchApi;
import com.sixthsolution.easymvp.domain.entity.Film;
import com.sixthsolution.easymvp.domain.entity.People;
import com.sixthsolution.easymvp.domain.repository.SearchRepository;

import java.util.List;

import rx.Observable;

/**
 * @author MohamadAmin Mohamadi (mohammadi.mohamadamin@gmail.com) on 10/18/16.
 */
public class FilmSearchRepository implements SearchRepository {

    private SearchApi searchApi;

    public FilmSearchRepository(SearchApi searchApi) {
        this.searchApi = searchApi;
    }

    @Override
    public Observable<List<Film>> searchFilms(String query) {
        return searchApi.searchFilms(query);
    }

    @Override
    public Observable<Film> singleSearchFilm(String query) {
        return searchApi.singleSearchFilm(query);
    }

    @Override
    public Observable<List<People>> searchPeople(String query) {
        return searchApi.searchPeople(query);
    }

}
