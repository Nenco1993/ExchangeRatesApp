package com.example.neven.exchangeratesapp.views;

import java.util.List;

/**
 * Created by Neven on 15.6.2017..
 */
public interface GraphView {

    void showGraph(String medianRate, float days);
    void onCurrenciesAdded(List<String> listCurrencies);
    void showErrorMessage(String message);


}
