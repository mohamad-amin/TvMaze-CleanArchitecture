package com.sixthsolution.easymvp.tvmaze.internal.di.module;

import com.sixthsolution.easymvp.domain.interactor.impl.ConvertFilmToJsonUseCase;
import com.sixthsolution.easymvp.tvmaze.view.adapter.IconicFilmAdapter;
import com.sixthsolution.easymvp.tvmaze.view.base.BaseActivity;

import dagger.Module;
import dagger.Provides;

/**
 * @author MohamadAmin Mohamadi (mohammadi.mohamadamin@gmail.com) on 10/21/16.
 */
@Module
public class AdapterModule {

    @Provides
    IconicFilmAdapter provideIconicFilmAdapter(
                        BaseActivity activity, ConvertFilmToJsonUseCase useCase){
        return new IconicFilmAdapter(activity, useCase);
    }

}
