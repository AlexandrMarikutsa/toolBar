package com.demo.alexandr.myapp.activities;


import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;

import com.demo.alexandr.myapp.R;
import com.demo.alexandr.myapp.models.TestCourse;
import com.demo.alexandr.myapp.recyclers.adapters.CoursesAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {

    public static final List<TestCourse> courses = new ArrayList<>();

    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        courses

        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_courses);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {

        menu.findItem(R.id.action_edit).setVisible(false);
        return true;
    }
}
