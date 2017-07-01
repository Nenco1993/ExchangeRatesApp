package com.example.neven.exchangeratesapp.interactors;

import com.example.neven.exchangeratesapp.listeners.GraphListener;

/**
 * Created by Neven on 29.6.2017..
 */
public interface GraphInteractor {

    void downloadData(GraphListener listener);

}
