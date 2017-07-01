package com.example.neven.exchangeratesapp.views;

import java.util.List;

/**
 * Created by Neven on 14.6.2017..
 */
public interface CalculatorView {

    void onCurrenciesAdded( List<String> listCurrencies);
    void showResult(double result);

}
