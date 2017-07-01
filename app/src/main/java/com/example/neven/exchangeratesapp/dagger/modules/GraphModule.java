package com.example.neven.exchangeratesapp.dagger.modules;

import com.example.neven.exchangeratesapp.dagger.scopes.ActivityScope;
import com.example.neven.exchangeratesapp.interactors.GraphInteractor;
import com.example.neven.exchangeratesapp.interactors.GraphInteractorImpl;
import com.example.neven.exchangeratesapp.presenters.GraphPresenter;
import com.example.neven.exchangeratesapp.presenters.GraphPresenterImpl;
import com.example.neven.exchangeratesapp.utils.DateUtils;
import com.example.neven.exchangeratesapp.views.GraphView;
import dagger.Module;
import dagger.Provides;

/**
 * Created by Neven on 15.6.2017..
 */
@Module
public class GraphModule {

    private final GraphView view;

    public GraphModule(GraphView view) {
        this.view = view;
    }

    @Provides
    @ActivityScope
    GraphView provideView() {

        return view;
    }

    @Provides
    @ActivityScope
    GraphPresenter provideGraphPresenter(GraphPresenterImpl presenter) {

        return presenter;
    }

    @Provides
    @ActivityScope
    GraphInteractor provideGraphInteractor(GraphInteractorImpl interactor) {

        return interactor;
    }

    @Provides
    @ActivityScope
    DateUtils provideDateUtils(){

        return new DateUtils();
    }

}
