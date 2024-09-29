package com.seniorproj.scheduler.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class StudentCourses {

    
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Id
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    private int enrollSemester;

    public StudentCourses(Course course, int enrollSemester, Long id, Student student) {
        this.course = course;
        this.enrollSemester = enrollSemester;
        this.id = id;
        this.student = student;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public int getEnrollSemester() {
        return enrollSemester;
    }

    public void setEnrollSemester(int enrollSemester) {
        this.enrollSemester = enrollSemester;
    }


    

}
