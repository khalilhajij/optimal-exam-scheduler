package com.seniorproj.scheduler.models;

import jakarta.persistence.*;

public class CoursePrerequisites {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @ManyToOne
    @JoinColumn(name = "prerequisite_course_id")
    private Course prerequisite;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Course getPrerequisite() {
        return prerequisite;
    }

    public void setPrerequisite(Course prerequisite) {
        this.prerequisite = prerequisite;
    }

    public CoursePrerequisites(Long id, Course course, Course prerequisite) {
        this.id = id;
        this.course = course;
        this.prerequisite = prerequisite;
    }


    

}
