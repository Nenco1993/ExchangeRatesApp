package com.example.neven.exchangeratesapp.dagger.components;

import com.example.neven.exchangeratesapp.activities.BaseActivity;
import com.example.neven.exchangeratesapp.dagger.modules.*;
import dagger.Component;

import javax.inject.Singleton;

/**
 * Created by Neven on 13.6.2017..
 */
@Singleton
@Component(modules = {NetModule.class})
public interface AppComponent {

    void inject(BaseActivity activity);
    MainComponent newMainSubComponent(MainModule module);
    CalculatorComponent newCalculatorSubComponent(CalculatorModule module);
    GraphComponent newGraphSubComponent(GraphModule module);
    ExchangeRatesComponent newExchangeRatesSubComponent(ExchangeRatesModule module);



}
