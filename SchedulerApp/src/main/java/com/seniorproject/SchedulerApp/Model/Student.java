package com.seniorproject.SchedulerApp.Model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;
    private String firstName;
    private String surName;

    @ManyToOne
    @JoinColumn(name = "major_id")
    private Major majorid;

    @ManyToMany
    private List<Course> enrolledCourses = new ArrayList<>();

    public Student() {
    }

    public Student(Long studentId, String firstName, String surName, Major majorid, List<Course> enrolledCourses) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.surName = surName;
        this.majorid = majorid;
        this.enrolledCourses = enrolledCourses;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
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

    public Major getMajorid() {
        return majorid;
    }

    public void setMajorid(Major majorid) {
        this.majorid = majorid;
    }

    public List<Course> getEnrolledCourses() {
        return enrolledCourses;
    }

    public void setEnrolledCourses(List<Course> enrolledCourses) {
        this.enrolledCourses = enrolledCourses;
    }
}
