package com.example.neven.exchangeratesapp.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import com.example.neven.exchangeratesapp.MyApplication;
import com.example.neven.exchangeratesapp.R;
import com.example.neven.exchangeratesapp.adapters.ExchangeRatesAdapter;
import com.example.neven.exchangeratesapp.adapters.Item;
import com.example.neven.exchangeratesapp.dagger.modules.ExchangeRatesModule;
import com.example.neven.exchangeratesapp.models.ExchangeRate;
import com.example.neven.exchangeratesapp.presenters.ExchangeRatesPresenter;
import com.example.neven.exchangeratesapp.views.ExchangeRatesView;

import javax.inject.Inject;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ExchangeRatesFragment extends Fragment implements ExchangeRatesView {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    @Inject
    ExchangeRatesPresenter presenter;


    public ExchangeRatesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_exchange_rates, container, false);
        ButterKnife.bind(this, view);

        ((MyApplication) getActivity().getApplication()).appComponent.newExchangeRatesSubComponent(new ExchangeRatesModule(this)).inject(this);

        if (getArguments() != null) {

            //noinspection unchecked
            List<ExchangeRate> listRate = (List<ExchangeRate>) getArguments().getSerializable("rates");
            presenter.addDataToList(listRate);

        }

        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(manager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        DividerItemDecoration mDividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(), DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(mDividerItemDecoration);


        return view;
    }

    @Override
    public void showData(List<Item> listItem) {

        ExchangeRatesAdapter adapter = new ExchangeRatesAdapter(listItem, getContext());
        recyclerView.setAdapter(adapter);


    }
}
