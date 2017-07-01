package com.example.neven.exchangeratesapp.presenters;

import com.example.neven.exchangeratesapp.models.ExchangeRate;

import java.util.List;

/**
 * Created by Neven on 15.6.2017..
 */
public interface GraphPresenter {

    void loadData(String selectedCurrency);
    void addCurrencies(List<ExchangeRate> listRate);


}
