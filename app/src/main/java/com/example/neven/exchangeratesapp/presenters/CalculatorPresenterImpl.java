package com.example.neven.exchangeratesapp.presenters;

import com.example.neven.exchangeratesapp.models.ExchangeRate;
import com.example.neven.exchangeratesapp.views.CalculatorView;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Neven on 13.6.2017..
 */
public class CalculatorPresenterImpl implements CalculatorPresenter {

    private final CalculatorView view;

    @Inject
    public CalculatorPresenterImpl(CalculatorView view) {

        this.view = view;
    }

    @Override
    public void performConversion(List<ExchangeRate> listRate, double value, String fromCurrency, String toCurrency) {

        double valueToKuna = 0;

        for (ExchangeRate rate : listRate) {
            if (rate.currencyCode.equalsIgnoreCase(fromCurrency)) {

                double fromMedianRate = Double.parseDouble(rate.medianRate);
                valueToKuna = value * fromMedianRate;

            }
        }

        for (ExchangeRate rate : listRate) {

            if (rate.currencyCode.equalsIgnoreCase(toCurrency)) {

                double toMedianRate = Double.parseDouble(rate.medianRate);
                double result = valueToKuna / toMedianRate;
                view.showResult(result);

            }
        }


    }

    @Override
    public void addCurrencies(List<ExchangeRate> listRate) {

        List<String> listCurrencies = new ArrayList<>();

        for (ExchangeRate rate : listRate) {
            listCurrencies.add(rate.currencyCode);
        }

        view.onCurrenciesAdded(listCurrencies);


    }


}
