package com.example.neven.exchangeratesapp.fragments;


import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.*;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.bumptech.glide.Glide;
import com.example.neven.exchangeratesapp.MyApplication;
import com.example.neven.exchangeratesapp.R;
import com.example.neven.exchangeratesapp.dagger.modules.CalculatorModule;
import com.example.neven.exchangeratesapp.models.ExchangeRate;
import com.example.neven.exchangeratesapp.presenters.CalculatorPresenter;
import com.example.neven.exchangeratesapp.views.CalculatorView;

import javax.inject.Inject;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class CalculatorFragment extends Fragment implements CalculatorView, AdapterView.OnItemSelectedListener {

    @BindView(R.id.tvResult)
    TextView tvResult;

    @BindView(R.id.etValue)
    EditText etValue;

    @BindView(R.id.ivFromCurrency)
    ImageView ivFromCurrencyLogo;

    @BindView(R.id.sFromCurrency)
    Spinner sFromCurrency;

    @BindView(R.id.ivToCurrency)
    ImageView ivToCurrencyLogo;

    @BindView(R.id.sToCurrency)
    Spinner sToCurrency;

    @BindView(R.id.bCalculate)
    Button bCalculate;

    @Inject
    CalculatorPresenter presenter;

    private String fromCurrency;
    private String toCurrency;
    private List<ExchangeRate> listRate;


    public CalculatorFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_calculator, container, false);
        ButterKnife.bind(this, view);

        ((MyApplication) getActivity().getApplication()).appComponent.newCalculatorSubComponent(new CalculatorModule(this)).inject(this);


        if (getArguments() != null) {

            //noinspection unchecked
            listRate = (List<ExchangeRate>) getArguments().getSerializable("rates");
            presenter.addCurrencies(listRate);

        }


        return view;
    }

    @OnClick(R.id.bCalculate)
    void calculateResult() {

        String value = etValue.getText().toString();

        if (value.isEmpty()) {
            Toast.makeText(getContext(), "fill in the fields", Toast.LENGTH_SHORT).show();
        } else {
            double doubleValue = Double.parseDouble(value);
            presenter.performConversion(listRate, doubleValue, fromCurrency, toCurrency);
            etValue.setText("");
        }

    }


    @Override
    public void onCurrenciesAdded(List<String> listCurrencies) {

        sFromCurrency.setAdapter(new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_dropdown_item, listCurrencies));
        sToCurrency.setAdapter(new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_dropdown_item, listCurrencies));
        sFromCurrency.setOnItemSelectedListener(this);
        sToCurrency.setOnItemSelectedListener(this);

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

        if (!tvResult.getText().toString().equalsIgnoreCase("result")) {

            tvResult.setText("");


        }

        String flagURL;

        switch (adapterView.getId()) {

            case R.id.sFromCurrency:
                fromCurrency = (String) adapterView.getItemAtPosition(i);
                flagURL = "http://s.xe.com/themes/xe/images/flags/big/" + fromCurrency.toLowerCase() + ".png";


                Glide
                        .with(getContext())
                        .load(flagURL)
                        .crossFade()
                        .into(ivFromCurrencyLogo);


                break;
            case R.id.sToCurrency:
                toCurrency = (String) adapterView.getItemAtPosition(i);
                flagURL = "http://s.xe.com/themes/xe/images/flags/big/" + toCurrency.toLowerCase() + ".png";

                Glide
                        .with(getContext())
                        .load(flagURL)
                        .crossFade()
                        .into(ivToCurrencyLogo);

                break;
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

        Toast.makeText(getContext(), "select a currency", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void showResult(double result) {

        tvResult.setTypeface(Typeface.DEFAULT_BOLD);
        tvResult.setText(String.valueOf(result));

    }


}
