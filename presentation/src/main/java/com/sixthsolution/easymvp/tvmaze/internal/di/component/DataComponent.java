package com.sixthsolution.easymvp.tvmaze.internal.di.component;

import com.sixthsolution.easymvp.domain.interactor.GetFilmDetailsUseCase;
import com.sixthsolution.easymvp.domain.interactor.GetFilmsListUseCase;
import com.sixthsolution.easymvp.tvmaze.internal.di.module.RepositoryModule;
import com.sixthsolution.easymvp.tvmaze.internal.di.module.UseCaseModule;

import dagger.Component;

/**
 * @author MohamadAmin Mohamadi (mohammadi.mohamadamin@gmail.com) on 10/21/16.
 */
@Component(
        modules = {RepositoryModule.class, UseCaseModule.class},
        dependencies = ApplicationComponent.class
)
public interface DataComponent {

    GetFilmDetailsUseCase provideGetFilmDetailsUseCase();
    GetFilmsListUseCase provideGetFilmListUseCase();

}
