package com.example.neven.exchangeratesapp.activities;

import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.example.neven.exchangeratesapp.MyApplication;
import com.example.neven.exchangeratesapp.R;
import com.example.neven.exchangeratesapp.dagger.modules.MainModule;
import com.example.neven.exchangeratesapp.fragments.CalculatorFragment;
import com.example.neven.exchangeratesapp.fragments.ExchangeRatesFragment;
import com.example.neven.exchangeratesapp.fragments.GraphFragment;
import com.example.neven.exchangeratesapp.models.ExchangeRate;
import com.example.neven.exchangeratesapp.presenters.MainPresenter;

import com.example.neven.exchangeratesapp.views.MainView;


import javax.inject.Inject;
import java.io.Serializable;
import java.util.List;


public class MainActivity extends BaseActivity implements MainView {

    @BindView(R.id.bottom_navigation)
    BottomNavigationView bottomNavigationView;

    @BindView(R.id.progressBar)
    ProgressBar progressBar;

    @Inject
    MainPresenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        ((MyApplication) getApplication()).appComponent.newMainSubComponent(new MainModule(this)).inject(this);
        presenter.loadData();


    }


    @Override
    public void onDownloadFinished(List<ExchangeRate> listRate) {

        progressBar.setVisibility(View.GONE);

        Fragment startingFragment = new CalculatorFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("rates", (Serializable) listRate);
        startingFragment.setArguments(bundle);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, startingFragment).commit();

        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {

            Fragment fragment = null;

            switch (item.getItemId()) {
                case R.id.action_calculator:
                    fragment = new CalculatorFragment();
                    fragment.setArguments(bundle);

                    break;
                case R.id.action_exchange_rates:
                    fragment = new ExchangeRatesFragment();
                    fragment.setArguments(bundle);
                    break;
                case R.id.action_graph:
                    fragment = new GraphFragment();
                    fragment.setArguments(bundle);
                    break;
            }

            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();

            return true;

        });


    }

    @Override
    public void showErrorMessage(String message) {

        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();


    }


}
