package com.demo.alexandr.myapp.recyclers.adapters;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.demo.alexandr.myapp.R;
import com.demo.alexandr.myapp.recyclers.holders.CoursesHolder;

import java.util.ArrayList;
import java.util.List;

public class CoursesAdapter extends RecyclerView.Adapter<CoursesHolder> {
    private List mItems = new ArrayList<>();

    public CoursesAdapter(List<?> items) {
        mItems.addAll(items);
    }

    @Override
    public CoursesHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new CoursesHolder(LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.course_list_item, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(CoursesHolder coursesHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }
}