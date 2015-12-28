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

        courses.add(new TestCourse("Philosophy", "created at 20-12-2015", "#FFC5FD01"));
        courses.add(new TestCourse("History", "created at 10-11-2015", "#FF132CEE"));
        courses.add(new TestCourse("Modern", "created at 22-09-2014", "#FFE90D0D"));
        courses.add(new TestCourse("Art", "created at 05-05-2015", "#FF13EE31"));

        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_courses);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        CoursesAdapter adapter = new CoursesAdapter(courses);
        mRecyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        menu.findItem(R.id.action_edit).setVisible(false);
        return true;
    }
}
