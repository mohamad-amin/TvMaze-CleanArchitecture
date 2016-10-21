package com.sixthsolution.easymvp.domain.interactor.impl;

import com.google.gson.Gson;
import com.sixthsolution.easymvp.domain.entity.Film;
import com.sixthsolution.easymvp.domain.executor.PostExecutionThread;
import com.sixthsolution.easymvp.domain.executor.ThreadExecutor;
import com.sixthsolution.easymvp.domain.interactor.base.UseCase;

import rx.Observable;
import rx.functions.Func0;

/**
 * @author MohamadAmin Mohamadi (mohammadi.mohamadamin@gmail.com) on 10/21/16.
 */
public class ConvertFilmToJsonUseCase extends UseCase {

    private Film film;
    private Gson gson;

    public ConvertFilmToJsonUseCase(ThreadExecutor threadExecutor, PostExecutionThread postThread) {
        super(threadExecutor, postThread);
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public void setGson(Gson gson) {
        this.gson = gson;
    }

    @Override
    protected Observable<String> getTask() {
        return Observable.defer(new Func0<Observable<String>>() {
            @Override
            public Observable<String> call() {
                return Observable.just(convert());
            }
        });
    }

    private String convert() {
        return gson.toJson(film);
    }

}
