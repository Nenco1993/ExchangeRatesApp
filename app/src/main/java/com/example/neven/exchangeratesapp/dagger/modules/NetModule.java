package com.example.neven.exchangeratesapp.dagger.modules;


import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import javax.inject.Singleton;

/**
 * Created by Neven on 13.6.2017..
 */
@Module
public class NetModule {

    @Provides
    @Singleton
    Retrofit provideRetrofit() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://hnbex.eu/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        return retrofit;
    }



}
