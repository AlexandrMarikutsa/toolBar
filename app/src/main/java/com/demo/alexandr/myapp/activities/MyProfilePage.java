package com.demo.alexandr.myapp.activities;


import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

import com.demo.alexandr.myapp.R;
import com.demo.alexandr.myapp.utils.Service;

public class MyProfilePage extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_profile_page);

        changeToolbarTitle();
    }

    private void changeToolbarTitle() {
        TextView appTitle = Service.getAppTitleView(toolbar);
        appTitle.setVisibility(View.GONE);
        toolbarTitle.setVisibility(View.VISIBLE);
        toolbarTitle.setText(R.string.toolbar_title_profile);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        menu.findItem(R.id.action_search).setVisible(false);
        menu.findItem(R.id.action_add).setVisible(false);
        return true;
    }
}
