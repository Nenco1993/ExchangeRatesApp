package com.example.neven.exchangeratesapp.network;

import com.example.neven.exchangeratesapp.models.ExchangeRate;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

import java.util.List;

/**
 * Created by Neven on 13.6.2017..
 */
public interface RestAPI {

    @GET("v1/rates/daily/")
    Observable<List<ExchangeRate>> getExchangeRates();


    @GET("v1/rates/daily/?date=date")
    Observable<List<ExchangeRate>> getExchangeRatesForLast7days(@Query("date") String date);


}
