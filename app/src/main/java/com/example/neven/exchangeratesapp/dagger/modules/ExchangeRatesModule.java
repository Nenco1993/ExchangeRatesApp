package com.example.neven.exchangeratesapp.dagger.modules;

import com.example.neven.exchangeratesapp.dagger.scopes.ActivityScope;
import com.example.neven.exchangeratesapp.presenters.ExchangeRatesPresenter;
import com.example.neven.exchangeratesapp.presenters.ExchangeRatesPresenterImpl;
import com.example.neven.exchangeratesapp.views.ExchangeRatesView;
import dagger.Module;
import dagger.Provides;

/**
 * Created by Neven on 16.6.2017..
 */
@Module
public class ExchangeRatesModule {

    private final ExchangeRatesView view;

    public ExchangeRatesModule(ExchangeRatesView view) {
        this.view = view;
    }

    @Provides
    @ActivityScope
    ExchangeRatesPresenter provideExchangeRatesPresenter(ExchangeRatesPresenterImpl presenter) {

        return presenter;
    }

    @Provides
    @ActivityScope
    ExchangeRatesView provideView(){

        return view;


    }


}
