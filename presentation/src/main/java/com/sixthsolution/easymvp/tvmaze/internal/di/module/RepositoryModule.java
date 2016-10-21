package com.sixthsolution.easymvp.tvmaze.internal.di.module;

import com.sixthsolution.easymvp.data.repository.FilmDataRepository;
import com.sixthsolution.easymvp.data.repository.FilmSearchRepository;
import com.sixthsolution.easymvp.domain.repository.FilmRepository;
import com.sixthsolution.easymvp.domain.repository.SearchRepository;

import dagger.Module;
import dagger.Provides;

/**
 * @author MohamadAmin Mohamadi (mohammadi.mohamadamin@gmail.com) on 10/21/16.
 */
@Module
public class RepositoryModule {

    @Provides
    FilmRepository provideFilmRepository(FilmDataRepository repository) {
        return repository;
    }

    @Provides
    SearchRepository provideSearchRepository(FilmSearchRepository repository) {
        return repository;
    }

}
