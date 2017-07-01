package com.example.neven.exchangeratesapp.presenters;

import com.example.neven.exchangeratesapp.models.ExchangeRate;

import java.util.List;

/**
 * Created by Neven on 13.6.2017..
 */
public interface CalculatorPresenter {

    void addCurrencies(List<ExchangeRate> listRate);
    void performConversion(List<ExchangeRate> listRate, double value, String fromCurrency, String toCurrency);


}
