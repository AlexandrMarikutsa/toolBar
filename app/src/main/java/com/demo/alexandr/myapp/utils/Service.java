package com.demo.alexandr.myapp.utils;


import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import java.lang.reflect.Field;

public class Service {
    public static final TextView getAppTitleView(Toolbar toolbar) {
        TextView appTitle = null;
        try {
            Field title = toolbar.getClass().getDeclaredField("mTitleTextView");
            title.setAccessible(true);
            appTitle = (TextView)title.get(toolbar);
            appTitle.setVisibility(View.GONE);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return appTitle;
    }
}
