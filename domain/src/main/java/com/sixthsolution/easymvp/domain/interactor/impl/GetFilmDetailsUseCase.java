package com.sixthsolution.easymvp.domain.interactor.impl;

import com.sixthsolution.easymvp.domain.executor.PostExecutionThread;
import com.sixthsolution.easymvp.domain.executor.ThreadExecutor;
import com.sixthsolution.easymvp.domain.interactor.base.UseCase;
import com.sixthsolution.easymvp.domain.repository.FilmRepository;

import rx.Observable;

/**
 * @author MohamadAmin Mohamadi (mohammadi.mohamadamin@gmail.com) on 10/17/16.
 */
public class GetFilmDetailsUseCase extends UseCase {

    private FilmRepository filmRepository;
    private String filmId;

    protected GetFilmDetailsUseCase(ThreadExecutor threadExecutor, PostExecutionThread postThread,
                                    FilmRepository filmRepository, String filmId) {
        super(threadExecutor, postThread);
        this.filmRepository = filmRepository;
        this.filmId = filmId;
    }

    @Override
    protected Observable getTask() {
        return filmRepository.getFilm(filmId);
    }

}