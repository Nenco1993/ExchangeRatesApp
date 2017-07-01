package com.example.neven.exchangeratesapp.presenters;

import com.example.neven.exchangeratesapp.interactors.GraphInteractor;
import com.example.neven.exchangeratesapp.listeners.GraphListener;
import com.example.neven.exchangeratesapp.models.ExchangeRate;
import com.example.neven.exchangeratesapp.views.GraphView;

import retrofit2.HttpException;
import retrofit2.Retrofit;

import javax.inject.Inject;
import java.io.IOException;
import java.util.*;

/**
 * Created by Neven on 15.6.2017..
 */
public class GraphPresenterImpl implements GraphPresenter, GraphListener {

    private final Retrofit retrofit;
    private final GraphView view;
    private final GraphInteractor interactor;
    private String selectedCurrency;
    private int days;
    private int counter = 0;

    @Inject
    public GraphPresenterImpl(Retrofit retrofit, GraphView view, GraphInteractor interactor) {
        this.retrofit = retrofit;
        this.view = view;
        this.interactor = interactor;
    }

    @Override
    public void loadData(String selectedCurrency) {

        days = 0;
        this.selectedCurrency = selectedCurrency;
        interactor.downloadData(this);

    }

    @Override
    public void addCurrencies(List<ExchangeRate> listRate) {

        List<String> listCurrencies = new ArrayList<>();

        for (ExchangeRate rate : listRate) {
            listCurrencies.add(rate.currencyCode);
        }

        view.onCurrenciesAdded(listCurrencies);


    }

    @Override
    public void onFailure(Throwable throwable) {         //execute this only once

        if (counter == 0) {

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

        counter++;


    }

    @Override
    public void onSuccess(List<ExchangeRate> listExchangeRates) {

        for (ExchangeRate rate : listExchangeRates) {
            if (selectedCurrency.equalsIgnoreCase(rate.currencyCode)) {
                view.showGraph(rate.medianRate, days);
                days++;
            }
        }


    }


}
