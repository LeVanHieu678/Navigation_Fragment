package com.vti.rxjavawithretrofit.java;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public  class ParentsActivity extends AppCompatActivity {
    private  String varOfParent = "Variable of Parents";
    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
        class NestedClass {
          void foo(){
             varOfParent  = "Test";
          }

    }
}
