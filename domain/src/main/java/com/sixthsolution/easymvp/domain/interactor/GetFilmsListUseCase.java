package com.sixthsolution.easymvp.domain.interactor;

import com.sixthsolution.easymvp.domain.entity.Film;
import com.sixthsolution.easymvp.domain.repository.FilmRepository;

import java.util.List;

import javax.annotation.ParametersAreNullableByDefault;

import easymvp.executer.PostExecutionThread;
import easymvp.executer.UseCaseExecutor;
import easymvp.usecase.ObservableUseCase;
import rx.Observable;

/**
 * @author MohamadAmin Mohamadi (mohammadi.mohamadamin@gmail.com) on 10/24/16.
 */
public class GetFilmsListUseCase extends ObservableUseCase<List<Film>, Integer> {

    private FilmRepository filmRepository;

    public GetFilmsListUseCase(UseCaseExecutor useCaseExecutor,
                               PostExecutionThread postThread, FilmRepository filmRepository) {
        super(useCaseExecutor, postThread);
        this.filmRepository = filmRepository;
    }

    @Override
    protected Observable<List<Film>> interact(@ParametersAreNullableByDefault Integer page) {
        return filmRepository.getFilms(page);
    }

}
