package com.example.neven.exchangeratesapp.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.example.neven.exchangeratesapp.MyApplication;

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((MyApplication) getApplication()).appComponent.inject(this);
    }
}
