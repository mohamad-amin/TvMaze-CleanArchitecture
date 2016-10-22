package com.sixthsolution.easymvp.tvmaze.internal.di.module;

import com.sixthsolution.easymvp.domain.executor.PostExecutionThread;
import com.sixthsolution.easymvp.domain.interactor.base.UseCase;
import com.sixthsolution.easymvp.domain.interactor.impl.ConvertFilmToJsonUseCase;
import com.sixthsolution.easymvp.domain.interactor.impl.GetFilmDetailsUseCase;
import com.sixthsolution.easymvp.domain.interactor.impl.GetFilmListUseCase;
import com.sixthsolution.easymvp.domain.repository.FilmRepository;
import com.sixthsolution.easymvp.tvmaze.model.Constants;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import rx.Scheduler;

/**
 * @author MohamadAmin Mohamadi (mohammadi.mohamadamin@gmail.com) on 10/21/16.
 */
@Module
public class UseCaseModule {

    @Provides
    ConvertFilmToJsonUseCase provideConvertFilmToJsonUseCase(Scheduler scheduler,
                                                             PostExecutionThread postExecutionThread) {
        return new ConvertFilmToJsonUseCase(scheduler, postExecutionThread);
    }

    @Named(Constants.CONVERT_FILM_TO_JSON)
    @Provides
    UseCase provideConvertFilmToJsonUseCaseRaw(Scheduler scheduler,
                                                    PostExecutionThread postExecutionThread) {
        return provideConvertFilmToJsonUseCase(scheduler, postExecutionThread);
    }

    @Provides
    GetFilmListUseCase provideGetFilmListUseCase(Scheduler scheduler,
                            PostExecutionThread postExecutionThread, FilmRepository repository) {
        return new GetFilmListUseCase(scheduler, postExecutionThread, repository);
    }

    @Named(Constants.FILMS_LIST)
    @Provides
    UseCase provideGetFilmListUseCaseRaw(Scheduler scheduler,
                            PostExecutionThread postExecutionThread, FilmRepository repository) {
        return provideGetFilmListUseCase(scheduler, postExecutionThread, repository);
    }

    @Provides
    GetFilmDetailsUseCase provideGetFilmDetailsUseCase(Scheduler scheduler,
                              PostExecutionThread postExecutionThread, FilmRepository repository) {
        return new GetFilmDetailsUseCase(scheduler, postExecutionThread, repository);
    }

    @Named(Constants.FILM_DETAIL)
    @Provides
    UseCase provideGetFilmDetailUseCaseRaw(Scheduler scheduler,
                              PostExecutionThread postExecutionThread, FilmRepository repository) {
        return provideGetFilmDetailsUseCase(scheduler, postExecutionThread, repository);
    }


}
