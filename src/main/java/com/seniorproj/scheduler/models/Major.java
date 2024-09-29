package com.seniorproj.scheduler.models;

import java.util.Set;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

public class Major {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long majorId;

    private String majorName;

    @OneToMany(mappedBy = "major")
    private Set<Course> courses;

    
    public Long getMajorId() {
        return majorId;
    }

    public void setMajorId(Long majorId) {
        this.majorId = majorId;
    }

    public String getMajorName() {
        return majorName;
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }

    

    public Major(Long majorId, String majorName, Set<Course> courses) {
        this.majorId = majorId;
        this.majorName = majorName;
        this.courses = courses;
    }}

