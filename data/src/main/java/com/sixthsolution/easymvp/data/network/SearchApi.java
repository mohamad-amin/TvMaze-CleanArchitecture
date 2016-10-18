package com.sixthsolution.easymvp.data.network;

import com.sixthsolution.easymvp.domain.entity.Episode;
import com.sixthsolution.easymvp.domain.entity.Film;
import com.sixthsolution.easymvp.domain.entity.People;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * @author MohamadAmin Mohamadi (mohammadi.mohamadamin@gmail.com) on 10/17/16.
 */
public interface SearchApi {

    @GET("/search/shows")
    Observable<List<Film>> searchFilms(@Query("q") String query);

    @GET("/singlesearch/shows")
    Observable<Film> singleSearchFilm(@Query("q") String query);

    @GET("/search/people")
    Observable<List<People>> searchPeople(@Query("q") String query);

}
