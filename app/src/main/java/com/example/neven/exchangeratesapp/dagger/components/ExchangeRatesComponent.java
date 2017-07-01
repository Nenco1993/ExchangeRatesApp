package com.example.neven.exchangeratesapp.dagger.components;

import com.example.neven.exchangeratesapp.dagger.modules.ExchangeRatesModule;
import com.example.neven.exchangeratesapp.dagger.scopes.ActivityScope;
import com.example.neven.exchangeratesapp.fragments.ExchangeRatesFragment;
import dagger.Subcomponent;

/**
 * Created by Neven on 16.6.2017..
 */
@ActivityScope
@Subcomponent(modules = ExchangeRatesModule.class)
public interface ExchangeRatesComponent {

    void inject(ExchangeRatesFragment fragment);

}
