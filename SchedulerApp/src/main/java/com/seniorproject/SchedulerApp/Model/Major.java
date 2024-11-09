package com.seniorproject.SchedulerApp.Model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "majors")
public class Major {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int majorId;
    private String majorName;

    @ManyToMany
    @JoinTable(
        name = "major_courses",
        joinColumns = @JoinColumn(name = "major_id"),
        inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private List<Course> courses = new ArrayList<>();

    public Major() {
    }

    public Major(int majorId, String majorName, List<Course> courses) {
        this.majorId = majorId;
        this.majorName = majorName;
        this.courses = courses;
    }

    public int getMajorId() {
        return majorId;
    }

    public void setMajorId(int majorId) {
        this.majorId = majorId;
    }

    public String getMajorName() {
        return majorName;
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}
