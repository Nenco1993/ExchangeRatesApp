package com.example.neven.exchangeratesapp.dagger.components;

import com.example.neven.exchangeratesapp.activities.MainActivity;
import com.example.neven.exchangeratesapp.dagger.modules.MainModule;
import com.example.neven.exchangeratesapp.dagger.scopes.ActivityScope;
import dagger.Subcomponent;

/**
 * Created by Neven on 14.6.2017..
 */
@ActivityScope
@Subcomponent(modules = MainModule.class)
public interface MainComponent {

    void inject(MainActivity activity);


}
