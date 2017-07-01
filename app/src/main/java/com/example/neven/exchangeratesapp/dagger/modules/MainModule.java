package com.example.neven.exchangeratesapp.dagger.modules;

import com.example.neven.exchangeratesapp.dagger.scopes.ActivityScope;
import com.example.neven.exchangeratesapp.interactors.MainInteractor;
import com.example.neven.exchangeratesapp.interactors.MainInteractorImpl;
import com.example.neven.exchangeratesapp.presenters.MainPresenter;
import com.example.neven.exchangeratesapp.presenters.MainPresenterImpl;
import com.example.neven.exchangeratesapp.views.MainView;
import dagger.Module;
import dagger.Provides;

/**
 * Created by Neven on 14.6.2017..
 */
@Module
public class MainModule {

    private final MainView view;

    public MainModule(MainView view) {
        this.view = view;
    }

    @Provides
    @ActivityScope
    MainPresenter provideMainPresenter(MainPresenterImpl presenter) {

        return presenter;
    }

    @Provides
    @ActivityScope
    MainView provideView() {


        return view;
    }

    @Provides
    @ActivityScope
    MainInteractor provideMainInteractor(MainInteractorImpl interactor) {

        return interactor;
    }

}
