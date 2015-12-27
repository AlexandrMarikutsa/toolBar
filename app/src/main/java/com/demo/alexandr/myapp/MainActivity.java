package com.demo.alexandr.myapp;


import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import java.lang.reflect.Field;
import java.util.List;

public class MainActivity extends ToolbarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

                try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        ImageButton btnToolbarButton = null;
        try {
            Toolbar mActionBarToolbar = (Toolbar) findViewById(R.id.toolbar_actionbar);
            Field[] fields = mActionBarToolbar.getClass().getDeclaredFields();
            Field fNavBtn = mActionBarToolbar.getClass().getDeclaredField("mNavButtonView");
            fNavBtn.setAccessible(true);
            btnToolbarButton = (ImageButton) fNavBtn.get(mActionBarToolbar);
            btnToolbarButton.setVisibility(View.INVISIBLE);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_main;
    }
}
