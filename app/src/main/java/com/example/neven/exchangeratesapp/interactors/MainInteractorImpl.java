package com.example.neven.exchangeratesapp.interactors;

import com.example.neven.exchangeratesapp.listeners.MainListener;
import com.example.neven.exchangeratesapp.models.ExchangeRate;
import com.example.neven.exchangeratesapp.network.RestAPI;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by Neven on 29.6.2017..
 */
public class MainInteractorImpl implements MainInteractor {

    private final Retrofit retrofit;

    @Inject
    public MainInteractorImpl(Retrofit retrofit) {
        this.retrofit = retrofit;
    }

    @Override
    public void downloadData(MainListener listener) {

        RestAPI api = retrofit.create(RestAPI.class);

        Observable<List<ExchangeRate>> observable = api.getExchangeRates();

        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        listener::onSuccess,
                        listener::onFailure


                );


    }
}
