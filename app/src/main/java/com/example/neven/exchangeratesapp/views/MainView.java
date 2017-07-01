package com.example.neven.exchangeratesapp.views;

import com.example.neven.exchangeratesapp.models.ExchangeRate;

import java.util.List;

/**
 * Created by Neven on 14.6.2017..
 */
public interface MainView {

    void onDownloadFinished(List<ExchangeRate> listRate);

    void showErrorMessage(String message);

}
