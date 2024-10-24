package com.example.opsched2;

import java.util.List;

public class Student {
    private int studentId;
    private String firstName;
    private String surName;
    private List<Course> enrolledCourses;

    public Student(int studentId, String firstName, String surName, List<Course> enrolledCourses) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.surName = surName;
        this.enrolledCourses = enrolledCourses;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public List<Course> getEnrolledCourses() {
        return enrolledCourses;
    }

    public void setEnrolledCourses(List<Course> enrolledCourses) {
        this.enrolledCourses = enrolledCourses;
    }

    
    // Constructors, getters, setters, etc.
    
}
