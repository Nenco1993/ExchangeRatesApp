package com.example.neven.exchangeratesapp.presenters;

import com.example.neven.exchangeratesapp.models.ExchangeRate;

import java.util.List;

/**
 * Created by Neven on 16.6.2017..
 */
public interface ExchangeRatesPresenter {

    void addDataToList(List<ExchangeRate> listRate);
}
