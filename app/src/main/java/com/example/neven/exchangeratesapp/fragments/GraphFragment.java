package com.example.neven.exchangeratesapp.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.*;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.example.neven.exchangeratesapp.MyApplication;
import com.example.neven.exchangeratesapp.R;
import com.example.neven.exchangeratesapp.dagger.modules.GraphModule;
import com.example.neven.exchangeratesapp.models.ExchangeRate;
import com.example.neven.exchangeratesapp.presenters.GraphPresenter;
import com.example.neven.exchangeratesapp.utils.CustomMarkerUtils;
import com.example.neven.exchangeratesapp.views.GraphView;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.*;
import com.github.mikephil.charting.data.*;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class GraphFragment extends Fragment implements GraphView, AdapterView.OnItemSelectedListener {

    @BindView(R.id.graph)
    BarChart graph;

    @BindView(R.id.sGraph)
    Spinner spinnerGraph;

    @BindView(R.id.progressBarGraph)
    ProgressBar progressBar;

    @Inject
    GraphPresenter presenter;

    private List<BarEntry> entries;

    public GraphFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_graph, container, false);
        ButterKnife.bind(this, view);

        ((MyApplication) getActivity().getApplication()).appComponent.newGraphSubComponent(new GraphModule(this)).inject(this);

        if (getArguments() != null) {

            //noinspection unchecked
            List<ExchangeRate> listRate = (List<ExchangeRate>) getArguments().getSerializable("rates");
            presenter.addCurrencies(listRate);

        }

        return view;
    }

    @Override
    public void showGraph(String medianRate, float days) {

        entries.add(new BarEntry(days, Float.parseFloat(medianRate)));

        if (days == 7) {    //got all values, execute this once.

            BarDataSet set = new BarDataSet(entries, "Median rate       0 - 7 days ago");
            BarData data = new BarData(set);

            data.setBarWidth(0.9f);
            data.setDrawValues(false);

            CustomMarkerUtils marker = new CustomMarkerUtils(getContext(), R.layout.my_marker_view);
            graph.setMarker(marker);

            graph.getXAxis().setPosition(XAxis.XAxisPosition.BOTTOM);
            graph.getXAxis().setDrawGridLines(false);

            graph.getAxisLeft().setDrawLabels(true);
            graph.getAxisLeft().setDrawAxisLine(true);
            graph.getAxisLeft().setDrawGridLines(true);

            graph.getAxisRight().setEnabled(false);

            graph.setDragEnabled(true);
            graph.getDescription().setEnabled(false);
            graph.setPinchZoom(false);
            graph.setData(data);
            graph.setFitBars(true);
            graph.invalidate();

            progressBar.setVisibility(View.GONE);

        }

    }


    @Override
    public void onCurrenciesAdded(List<String> listCurrencies) {

        spinnerGraph.setAdapter(new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_dropdown_item, listCurrencies));
        spinnerGraph.setOnItemSelectedListener(this);

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

        String selectedCurrency = (String) adapterView.getItemAtPosition(i);
        entries = new ArrayList<>();
        presenter.loadData(selectedCurrency);
        progressBar.setVisibility(View.VISIBLE);

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

        Toast.makeText(getContext(), "select a currency", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void showErrorMessage(String message) {

        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();

    }
}

