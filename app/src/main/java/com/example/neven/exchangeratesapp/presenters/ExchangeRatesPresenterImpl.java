package com.example.neven.exchangeratesapp.presenters;

import com.example.neven.exchangeratesapp.adapters.ChildItem;
import com.example.neven.exchangeratesapp.adapters.HeaderItem;
import com.example.neven.exchangeratesapp.adapters.Item;
import com.example.neven.exchangeratesapp.models.ExchangeRate;
import com.example.neven.exchangeratesapp.views.ExchangeRatesView;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Neven on 16.6.2017..
 */
public class ExchangeRatesPresenterImpl implements ExchangeRatesPresenter {

    private final ExchangeRatesView view;

    @Inject
    public ExchangeRatesPresenterImpl(ExchangeRatesView view) {
        this.view = view;
    }

    @Override
    public void addDataToList(List<ExchangeRate> listRate) {

        List<Item> listItems = new ArrayList<>();

        listItems.add(new HeaderItem(null, null, null, null));
        for (ExchangeRate singleRate : listRate) {

            listItems.add(new ChildItem(singleRate.medianRate, singleRate.buyingRate, singleRate.sellingRate, singleRate.currencyCode));

        }

        view.showData(listItems);


    }
}
