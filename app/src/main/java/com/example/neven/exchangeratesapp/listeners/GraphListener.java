package com.example.neven.exchangeratesapp.listeners;


import com.example.neven.exchangeratesapp.models.ExchangeRate;

import java.util.List;

/**
 * Created by Neven on 29.6.2017..
 */
public interface GraphListener extends BaseListener {

    void onSuccess(List<ExchangeRate> listExchangeRates);

}
