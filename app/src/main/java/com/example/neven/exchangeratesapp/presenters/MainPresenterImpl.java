package com.example.neven.exchangeratesapp.presenters;

import com.example.neven.exchangeratesapp.interactors.MainInteractor;
import com.example.neven.exchangeratesapp.listeners.MainListener;
import com.example.neven.exchangeratesapp.models.ExchangeRate;
import com.example.neven.exchangeratesapp.views.MainView;
import retrofit2.HttpException;
import retrofit2.Retrofit;

import javax.inject.Inject;
import java.io.IOException;
import java.util.List;

/**
 * Created by Neven on 14.6.2017..
 */
public class MainPresenterImpl implements MainPresenter, MainListener {

    private final Retrofit retrofit;
    private final MainView view;
    private final MainInteractor interactor;

    @Inject
    public MainPresenterImpl(Retrofit retrofit, MainView view, MainInteractor interactor) {
        this.retrofit = retrofit;
        this.view = view;
        this.interactor = interactor;
    }

    @Override
    public void loadData() {

        interactor.downloadData(this);


    }


    @Override
    public void onFailure(Throwable throwable) {

        if (throwable instanceof IOException) {
            throwable.printStackTrace();
            view.showErrorMessage("Check your internet connection");
        } else if (throwable instanceof HttpException) {
            throwable.printStackTrace();
            view.showErrorMessage("We will be back soon!");
        } else {
            throwable.printStackTrace();
        }

    }

    @Override
    public void onSuccess(List<ExchangeRate> listExchangeRate) {

        view.onDownloadFinished(listExchangeRate);

    }


}
