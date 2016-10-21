package com.sixthsolution.easymvp.tvmaze.internal.di.module;

import com.sixthsolution.easymvp.domain.executor.PostExecutionThread;
import com.sixthsolution.easymvp.domain.executor.ThreadExecutor;
import com.sixthsolution.easymvp.domain.interactor.base.UseCase;
import com.sixthsolution.easymvp.domain.interactor.impl.ConvertFilmToJsonUseCase;
import com.sixthsolution.easymvp.domain.interactor.impl.GetFilmDetailsUseCase;
import com.sixthsolution.easymvp.domain.interactor.impl.GetFilmListUseCase;
import com.sixthsolution.easymvp.domain.repository.FilmRepository;
import com.sixthsolution.easymvp.tvmaze.model.Constants;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * @author MohamadAmin Mohamadi (mohammadi.mohamadamin@gmail.com) on 10/21/16.
 */
@Module
public class UseCaseModule {

    @Provides
    ConvertFilmToJsonUseCase provideConvertFilmToJsonUseCase(ThreadExecutor threadExecutor,
                                                    PostExecutionThread postExecutionThread) {
        return new ConvertFilmToJsonUseCase(threadExecutor, postExecutionThread);
    }

    @Named(Constants.CONVERT_FILM_TO_JSON)
    @Provides
    UseCase provideConvertFilmToJsonUseCaseRaw(ThreadExecutor threadExecutor,
                                                    PostExecutionThread postExecutionThread) {
        return provideConvertFilmToJsonUseCase(threadExecutor, postExecutionThread);
    }

    @Provides
    GetFilmListUseCase provideGetFilmListUseCase(ThreadExecutor threadExecutor,
                            PostExecutionThread postExecutionThread, FilmRepository repository) {
        return new GetFilmListUseCase(threadExecutor, postExecutionThread, repository);
    }

    @Named(Constants.FILMS_LIST)
    @Provides
    UseCase provideGetFilmListUseCaseRaw(ThreadExecutor threadExecutor,
                            PostExecutionThread postExecutionThread, FilmRepository repository) {
        return provideGetFilmListUseCase(threadExecutor, postExecutionThread, repository);
    }

    @Provides
    GetFilmDetailsUseCase provideGetFilmDetailsUseCase(ThreadExecutor threadExecutor,
                              PostExecutionThread postExecutionThread, FilmRepository repository) {
        return new GetFilmDetailsUseCase(threadExecutor, postExecutionThread, repository);
    }

    @Named(Constants.FILM_DETAIL)
    @Provides
    UseCase provideGetFilmDetailUseCaseRaw(ThreadExecutor threadExecutor,
                              PostExecutionThread postExecutionThread, FilmRepository repository) {
        return provideGetFilmDetailsUseCase(threadExecutor, postExecutionThread, repository);
    }


}
