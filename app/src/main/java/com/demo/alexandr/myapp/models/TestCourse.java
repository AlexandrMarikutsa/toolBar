package com.demo.alexandr.myapp.models;


public class TestCourse {
    private String name;
    private String createdDate;
    private String color;

    public TestCourse(String name, String createdDate, String color) {
        this.name = name;
        this.createdDate = createdDate;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public String getColor() {
        return color;
    }
}
