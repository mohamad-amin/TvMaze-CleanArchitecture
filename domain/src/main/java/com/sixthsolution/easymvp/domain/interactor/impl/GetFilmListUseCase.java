package com.sixthsolution.easymvp.domain.interactor.impl;

import com.sixthsolution.easymvp.domain.executor.PostExecutionThread;
import com.sixthsolution.easymvp.domain.interactor.base.UseCase;
import com.sixthsolution.easymvp.domain.repository.FilmRepository;

import rx.Observable;
import rx.Scheduler;

/**
 * @author MohamadAmin Mohamadi (mohammadi.mohamadamin@gmail.com) on 10/17/16.
 */
public class GetFilmListUseCase extends UseCase {

    private FilmRepository filmRepository;
    private int page;

    public GetFilmListUseCase(Scheduler scheduler,
                              PostExecutionThread postThread, FilmRepository filmRepository) {
        super(scheduler, postThread);
        this.filmRepository = filmRepository;
    }

    private void setPage(int page) {
        this.page = page;
    }

    @Override
    protected Observable getTask() {
        return filmRepository.getFilms(page);
    }

}
