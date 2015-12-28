package com.demo.alexandr.myapp.activities;


import android.os.Bundle;
import android.view.Menu;

import com.demo.alexandr.myapp.R;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

//    @Override
//    protected int getLayoutResource() {
//        return R.layout.activity_main;
//    }
//
//    @Override
//    public boolean onPrepareOptionsMenu(Menu menu) {
//
//        menu.findItem(R.id.action_edit).setVisible(false);
//        return true;
//    }
}
