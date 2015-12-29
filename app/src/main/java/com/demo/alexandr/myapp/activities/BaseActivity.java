package com.demo.alexandr.myapp.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.TextView;

import com.demo.alexandr.myapp.R;
import com.demo.alexandr.myapp.constants.StringConstants;
import com.mikepenz.iconics.typeface.FontAwesome;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.Badgeable;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.Nameable;

public class BaseActivity extends AppCompatActivity {
    private Drawer.Result drawerResult = null;

    public Toolbar toolbar;
    public TextView toolbarTitle;

    private View layoutContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.base_layout);

        layoutContainer = findViewById(R.id.containerView);
        initToolbar();
    }

    @Override
    public void setContentView(int layoutResID) {
        setContentView(getLayoutInflater().inflate(layoutResID, null));
    }

    @Override
    public void setContentView(View view) {
        if (view != null) {
            setContentView(view, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT));
        }
    }

    @Override
    public void setContentView(View view, ViewGroup.LayoutParams params) {
        if (layoutContainer != null) {
            try {
                ViewGroup viewGroup = (ViewGroup) layoutContainer;
                viewGroup.removeAllViews();
            } catch (Exception e) {
                Log.e(BaseActivity.class.getSimpleName(), "setContentView", e);
            } finally {
                ((ViewGroup) layoutContainer).addView(view, params);
            }
        }
    }

    public void initToolbar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar_actionbar);
        toolbar.setTitleTextColor(getResources().getColor(R.color.black));
        toolbarTitle = (TextView) findViewById(R.id.toolbarTitle);
        toolbarTitle.setVisibility(View.INVISIBLE);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        initDrawer();
    }

    public void initDrawer() {

        drawerResult = new Drawer()
                .withActivity(this)
                .withToolbar(toolbar)
                .withActionBarDrawerToggle(true)
                .withHeader(R.layout.drawer_header)
                .addDrawerItems(
                        new PrimaryDrawerItem().withName(R.string.drawer_item_inbox).withIcon(FontAwesome.Icon.faw_envelope_o).withIdentifier(1),
                        new PrimaryDrawerItem().withName(R.string.drawer_item_notifications).withIcon(FontAwesome.Icon.faw_bell),
                        new PrimaryDrawerItem().withName(R.string.drawer_item_my_courses).withIcon(FontAwesome.Icon.faw_edit).withIdentifier(2),
                        new DividerDrawerItem(),
                        new PrimaryDrawerItem().withName(R.string.drawer_item_my_profile).withIcon(FontAwesome.Icon.faw_male).withIdentifier(3),
                        new DividerDrawerItem(),
                        new PrimaryDrawerItem().withName(R.string.drawer_item_settings).withIcon(FontAwesome.Icon.faw_cog).withIdentifier(4),
                        new DividerDrawerItem(),
                        new PrimaryDrawerItem().withName(R.string.drawer_item_my_groups).withIcon(FontAwesome.Icon.faw_group).withIdentifier(5),
                        new DividerDrawerItem(),
                        new PrimaryDrawerItem().withName(R.string.drawer_item_share).withIcon(FontAwesome.Icon.faw_share).withIdentifier(6),
                        new DividerDrawerItem(),
                        new PrimaryDrawerItem().withName(R.string.drawer_item_archived_courses).withIcon(FontAwesome.Icon.faw_archive).withIdentifier(7))
                .withOnDrawerListener(new Drawer.OnDrawerListener() {
                    @Override
                    public void onDrawerOpened(View drawerView) {
                        // Скрываем клавиатуру при открытии Navigation Drawer
                        drawerView.setBackgroundColor(getResources().getColor(R.color.toolbar_color));
                        InputMethodManager inputMethodManager = (InputMethodManager) BaseActivity.this.getSystemService(Activity.INPUT_METHOD_SERVICE);
                        inputMethodManager.hideSoftInputFromWindow(BaseActivity.this.getCurrentFocus().getWindowToken(), 0);
                        toolbar.setVisibility(View.INVISIBLE);
                    }

                    @Override
                    public void onDrawerClosed(View drawerView) {
                        toolbar.setVisibility(View.VISIBLE);
                    }
                })
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    // Обработка клика
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id, IDrawerItem drawerItem) {
                        if (drawerItem instanceof Nameable) {

                            switch (BaseActivity.this.getString(((Nameable) drawerItem).getNameRes())) {
                                case StringConstants.INBOX:
                                    break;

                                case StringConstants.ARCHIVED_COURSES:
                                    break;

                                case StringConstants.MY_COURSES:
                                    break;

                                case StringConstants.MY_GROUPS:
                                    break;

                                case StringConstants.MY_PROFILE:
                                    startActivity(new Intent(BaseActivity.this, MyProfilePage.class));
                                    break;

                                case StringConstants.NOTIFICATIONS:
                                    break;

                                case StringConstants.SHARE:
                                    break;
                            }

//                            Toast.makeText(BaseActivity.this, BaseActivity.this.getString(((Nameable) drawerItem).getNameRes()), Toast.LENGTH_SHORT).show();
                        }
//                        if (drawerItem instanceof Badgeable) {
//                            Badgeable badgeable = (Badgeable) drawerItem;
//                            if (badgeable.getBadge() != null) {
//                                // учтите, не делайте так, если ваш бейдж содержит символ "+"
//                                try {
//                                    int badge = Integer.valueOf(badgeable.getBadge());
//                                    if (badge > 0) {
//                                        drawerResult.updateBadge(String.valueOf(badge - 1), position);
//                                    }
//                                } catch (Exception e) {
//                                    Log.d("test", "Не нажимайте на бейдж, содержащий плюс! :)");
//                                }
//                            }
//                        }
                    }
                })
//                .withOnDrawerItemLongClickListener(new Drawer.OnDrawerItemLongClickListener() {
//                    @Override
//                    // Обработка длинного клика, например, только для SecondaryDrawerItem
//                    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id, IDrawerItem drawerItem) {
//                        if (drawerItem instanceof SecondaryDrawerItem) {
//                            Toast.makeText(BaseActivity.this, BaseActivity.this.getString(((SecondaryDrawerItem) drawerItem).getNameRes()), Toast.LENGTH_SHORT).show();
//                        }
//                        return false;
//                    }
//                })
                .build();
    }

    @Override
    public void onBackPressed() {
        // Закрываем Navigation Drawer по нажатию системной кнопки "Назад" если он открыт
        if (drawerResult.isDrawerOpen()) {
            drawerResult.closeDrawer();
        } else {
            super.onBackPressed();
        }
    }

    // Заглушка, работа с меню
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);

        return true;
    }

    // Заглушка, работа с меню
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }

        return super.onOptionsItemSelected(item);
    }
}
