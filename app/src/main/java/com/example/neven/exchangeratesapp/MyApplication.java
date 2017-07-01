package com.example.neven.exchangeratesapp;

import android.app.Application;
import com.example.neven.exchangeratesapp.dagger.components.AppComponent;
import com.example.neven.exchangeratesapp.dagger.components.DaggerAppComponent;

/**
 * Created by Neven on 13.6.2017..
 */
public class MyApplication extends Application {

    public AppComponent appComponent;


    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.create();
    }
}
