package com.sixthsolution.easymvp.tvmaze.internal.di.module;

import com.sixthsolution.easymvp.domain.interactor.GetFilmDetailsUseCase;
import com.sixthsolution.easymvp.domain.interactor.GetFilmsListUseCase;
import com.sixthsolution.easymvp.domain.repository.FilmRepository;

import dagger.Module;
import dagger.Provides;
import easymvp.executer.PostExecutionThread;
import easymvp.executer.UseCaseExecutor;

/**
 * @author MohamadAmin Mohamadi (mohammadi.mohamadamin@gmail.com) on 10/21/16.
 */
@Module
public class UseCaseModule {

    @Provides
    GetFilmsListUseCase provideGetFilmListUseCase(UseCaseExecutor useCaseExecutor,
                               PostExecutionThread postExecutionThread, FilmRepository repository) {
        return new GetFilmsListUseCase(useCaseExecutor, postExecutionThread, repository);
    }

    @Provides
    GetFilmDetailsUseCase provideGetFilmDetailsUseCase(UseCaseExecutor useCaseExecutor,
                               PostExecutionThread postExecutionThread, FilmRepository repository) {
        return new GetFilmDetailsUseCase(useCaseExecutor, postExecutionThread, repository);
    }

}
