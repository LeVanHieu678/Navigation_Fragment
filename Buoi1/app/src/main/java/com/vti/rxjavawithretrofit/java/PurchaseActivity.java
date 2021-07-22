package com.vti.rxjavawithretrofit.java;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.vti.rxjavawithretrofit.MainActivity;
import com.vti.rxjavawithretrofit.R;

public class PurchaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportFragmentManager().beginTransaction().replace(R.id.downloadDoc, new Fragment()).commit();
    }
}
