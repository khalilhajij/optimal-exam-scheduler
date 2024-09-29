package com.seniorproj.scheduler.models;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class ConflictingLog {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID conflictId;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "course_id_1")
    private Course course1;

    @ManyToOne
    @JoinColumn(name = "course_id_2")
    private Course course2;

    private String conflictType;
    private LocalDate conflictDate;
    private boolean resolved;

    public UUID getConflictId() {
        return conflictId;
    }

    public void setConflictId(UUID conflictId) {
        this.conflictId = conflictId;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse1() {
        return course1;
    }

    public void setCourse1(Course course1) {
        this.course1 = course1;
    }

    public Course getCourse2() {
        return course2;
    }

    public void setCourse2(Course course2) {
        this.course2 = course2;
    }

    public String getConflictType() {
        return conflictType;
    }

    public void setConflictType(String conflictType) {
        this.conflictType = conflictType;
    }

    public LocalDate getConflictDate() {
        return conflictDate;
    }

    public void setConflictDate(LocalDate conflictDate) {
        this.conflictDate = conflictDate;
    }

    public boolean isResolved() {
        return resolved;
    }

    public void setResolved(boolean resolved) {
        this.resolved = resolved;
    }

    public ConflictingLog(UUID conflictId, Student student, Course course1, Course course2, String conflictType,
            LocalDate conflictDate, boolean resolved) {
        this.conflictId = conflictId;
        this.student = student;
        this.course1 = course1;
        this.course2 = course2;
        this.conflictType = conflictType;
        this.conflictDate = conflictDate;
        this.resolved = resolved;
    }


    
}
