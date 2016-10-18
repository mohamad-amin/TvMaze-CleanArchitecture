package com.sixthsolution.easymvp.data.network;

import com.sixthsolution.easymvp.domain.entity.Episode;
import com.sixthsolution.easymvp.domain.entity.Film;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * @author MohamadAmin Mohamadi (mohammadi.mohamadamin@gmail.com) on 10/17/16.
 */
public interface FilmApi {

    @GET("/shows")
    Observable<List<Film>> getFilms(@Query("page") int page);

    @GET("/shows/{id}")
    Observable<Film> getFilm(@Path("id") String id);

    @GET("/shows/{id}/episodes")
    Observable<List<Episode>> getEpisodes(@Path("id") String id);

    // Todo: Season
    @GET("/shows/{id}/seasons")
    Observable<List<Episode>> getSeasons(@Path("id") String id);

}
