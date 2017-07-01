package com.example.neven.exchangeratesapp.dagger.components;

import com.example.neven.exchangeratesapp.dagger.modules.GraphModule;
import com.example.neven.exchangeratesapp.dagger.scopes.ActivityScope;
import com.example.neven.exchangeratesapp.fragments.GraphFragment;
import dagger.Subcomponent;

/**
 * Created by Neven on 15.6.2017..
 */
@ActivityScope
@Subcomponent(modules = GraphModule.class)
public interface GraphComponent {

    void inject(GraphFragment fragment);

}
