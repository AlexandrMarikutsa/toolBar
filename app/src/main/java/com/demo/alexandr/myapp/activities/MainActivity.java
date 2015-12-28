package com.demo.alexandr.myapp.activities;


import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.demo.alexandr.myapp.R;

public class MainActivity extends ToolbarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//                try {
//            Thread.sleep(8000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_main;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {

        MenuItem editIcon = menu.findItem(R.id.action_edit);
        editIcon.setVisible(false);

        return true;
    }
}
