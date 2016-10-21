package com.sixthsolution.easymvp.tvmaze.internal.di.component;

import com.sixthsolution.easymvp.domain.interactor.base.UseCase;
import com.sixthsolution.easymvp.domain.interactor.impl.ConvertFilmToJsonUseCase;
import com.sixthsolution.easymvp.domain.interactor.impl.GetFilmDetailsUseCase;
import com.sixthsolution.easymvp.domain.interactor.impl.GetFilmListUseCase;
import com.sixthsolution.easymvp.tvmaze.internal.di.module.RepositoryModule;
import com.sixthsolution.easymvp.tvmaze.internal.di.module.UseCaseModule;
import com.sixthsolution.easymvp.tvmaze.model.Constants;

import javax.inject.Named;

import dagger.Component;

/**
 * @author MohamadAmin Mohamadi (mohammadi.mohamadamin@gmail.com) on 10/21/16.
 */
@Component(
        modules = {RepositoryModule.class, UseCaseModule.class},
        dependencies = ApplicationComponent.class
)
public interface DataComponent {

    ConvertFilmToJsonUseCase proideConvertFilmToJsonUseCase();
    GetFilmDetailsUseCase provideGetFilmDetailsUseCase();
    GetFilmListUseCase provideGetFilmListUseCase();

    @Named(Constants.FILM_DETAIL)
    UseCase provideFilmDetailUseCase();

    @Named(Constants.FILMS_LIST)
    UseCase provideFilmsListUseCase();

    @Named(Constants.CONVERT_FILM_TO_JSON)
    UseCase provideConvertFilmToJsonUseCase();

}
