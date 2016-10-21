package com.sixthsolution.easymvp.tvmaze.internal.di.module;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sixthsolution.easymvp.tvmaze.model.Constants;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import retrofit2.Converter;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by mohamadamin on 8/27/16.
 */
@Module
public class GsonModule {

    @Named(Constants.GSON_UNDERLINE_FACTORY)
    @Provides
    Converter.Factory getGsonConverterFactory(@Named(Constants.GSON_UNDERLINE_POLICY) Gson gson) {
        return GsonConverterFactory.create(gson);
    }

    @Named(Constants.GSON_UNDERLINE_POLICY)
    @Provides
    Gson getUnderlineGson() {
        return new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();
    }

}
