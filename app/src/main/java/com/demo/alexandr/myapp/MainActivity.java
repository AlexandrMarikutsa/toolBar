package com.demo.alexandr.myapp;


import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends ToolbarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        toolbar.findViewById(R.id.action_search).setVisibility(View.INVISIBLE);
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_main;
    }
}
