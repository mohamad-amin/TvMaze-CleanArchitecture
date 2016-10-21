package com.sixthsolution.easymvp.tvmaze.internal.di.module;

import com.sixthsolution.easymvp.data.network.FilmApi;
import com.sixthsolution.easymvp.data.network.SearchApi;
import com.sixthsolution.easymvp.tvmaze.model.Constants;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;

/**
 * Created by mohamadamin on 8/27/16.
 */
@Module
public class NetworkModule {

    @Provides
    FilmApi provideShowsApi(Retrofit retrofit) {
        return retrofit.create(FilmApi.class);
    }

    @Provides
    SearchApi provideSearchApi(Retrofit retrofit) {
        return retrofit.create(SearchApi.class);
    }

    @Provides
    Retrofit provideRetrofit(
            @Named(Constants.GSON_UNDERLINE_FACTORY) Converter.Factory converterFactory) {
        return new Retrofit.Builder()
                .baseUrl(Constants.TV_MAZE_URL_SELF)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(converterFactory)
                .build();
    }

}
