package com.example.neven.exchangeratesapp.dagger.components;

import com.example.neven.exchangeratesapp.dagger.modules.CalculatorModule;
import com.example.neven.exchangeratesapp.dagger.scopes.ActivityScope;
import com.example.neven.exchangeratesapp.fragments.CalculatorFragment;
import dagger.Subcomponent;

/**
 * Created by Neven on 13.6.2017..
 */
@ActivityScope
@Subcomponent(modules = {CalculatorModule.class})
public interface CalculatorComponent {

    void inject(CalculatorFragment fragment);

}
