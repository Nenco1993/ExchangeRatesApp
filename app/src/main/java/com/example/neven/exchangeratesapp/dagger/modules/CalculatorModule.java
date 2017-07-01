package com.example.neven.exchangeratesapp.dagger.modules;

import com.example.neven.exchangeratesapp.dagger.scopes.ActivityScope;
import com.example.neven.exchangeratesapp.presenters.CalculatorPresenter;
import com.example.neven.exchangeratesapp.presenters.CalculatorPresenterImpl;
import com.example.neven.exchangeratesapp.views.CalculatorView;
import dagger.Module;
import dagger.Provides;

/**
 * Created by Neven on 13.6.2017..
 */
@Module
public class CalculatorModule {

    private final CalculatorView view;

    public CalculatorModule(CalculatorView view) {
        this.view = view;
    }

    @Provides
    @ActivityScope
    CalculatorPresenter provideCalculatorPresenter(CalculatorPresenterImpl presenter) {

        return presenter;
    }

    @Provides
    @ActivityScope
    CalculatorView provideCalculatorView(){

        return view;


    }
}
