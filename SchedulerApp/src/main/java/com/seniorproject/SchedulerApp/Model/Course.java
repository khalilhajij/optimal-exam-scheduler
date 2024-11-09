package com.seniorproject.SchedulerApp.Model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int courseId;
    private String courseName;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "course_prerequisites",
        joinColumns = @JoinColumn(name = "course_id"),
        inverseJoinColumns = @JoinColumn(name = "prerequisite_id")
    )
    private List<Course> prerequisites = new ArrayList<>();

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "course_majors",
        joinColumns = @JoinColumn(name = "course_id"),
        inverseJoinColumns = @JoinColumn(name = "major_id")
    )
    private List<Major> associatedMajor = new ArrayList<>();

    public Course() {
    }

    public Course(int courseId, String courseName, List<Course> prerequisites, List<Major> associatedMajor) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.prerequisites = prerequisites;
        this.associatedMajor = associatedMajor;
    }

    public String getSemesterForMajor(Major major) {
        // Implement logic to get the semester for the given major
        return "semester"; // Placeholder
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public List<Course> getPrerequisites() {
        return prerequisites;
    }

    public void setPrerequisites(List<Course> prerequisites) {
        this.prerequisites = prerequisites;
    }

    public List<Major> getAssociatedMajor() {
        return associatedMajor;
    }

    public void setAssociatedMajor(List<Major> associatedMajor) {
        this.associatedMajor = associatedMajor;
    }
}
