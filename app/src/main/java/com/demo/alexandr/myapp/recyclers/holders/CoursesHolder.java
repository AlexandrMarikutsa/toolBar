package com.demo.alexandr.myapp.recyclers.holders;


import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.demo.alexandr.myapp.R;

public class CoursesHolder extends RecyclerView.ViewHolder {
    public TextView courseName;
    public TextView courseCreateDate;
    public ImageView courseImage;

    public CoursesHolder(View itemView) {
        super(itemView);
        this.courseName = (TextView) itemView.findViewById(R.id.course_name);
        this.courseCreateDate = (TextView) itemView.findViewById(R.id.course_created_date);
        this.courseImage = (ImageView) itemView.findViewById(R.id.course_image);
    }
}
