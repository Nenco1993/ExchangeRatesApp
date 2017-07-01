package com.example.neven.exchangeratesapp.interactors;

import com.example.neven.exchangeratesapp.listeners.GraphListener;
import com.example.neven.exchangeratesapp.models.ExchangeRate;
import com.example.neven.exchangeratesapp.network.RestAPI;
import com.example.neven.exchangeratesapp.utils.DateUtils;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

import javax.inject.Inject;
import java.util.*;

/**
 * Created by Neven on 29.6.2017..
 */
public class GraphInteractorImpl implements GraphInteractor {

    private final Retrofit retrofit;
    private DateUtils dateUtils;

    @Inject
    public GraphInteractorImpl(Retrofit retrofit, DateUtils dateUtils) {
        this.retrofit = retrofit;
        this.dateUtils = dateUtils;
    }

    @Override
    public void downloadData(GraphListener listener) {   // working on a better way to do this

        RestAPI api = retrofit.create(RestAPI.class);

        List<String> listDates = dateUtils.getDates();  // this list contains last 7 days.

        for (String date : listDates) {

            Observable<List<ExchangeRate>> observable = api.getExchangeRatesForLast7days(date);

            observable.subscribeOn(Schedulers.single())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(
                            listener::onSuccess,
                            listener::onFailure

                    );
        }


    }


}
