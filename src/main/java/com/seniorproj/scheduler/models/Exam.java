package com.seniorproj.scheduler.models;

import java.util.UUID;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class Exam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID examId;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    private String examType;
    private int duration;
    private boolean isShared;

    public Exam(Course course, int duration, UUID examId, String examType, boolean isShared) {
        this.course = course;
        this.duration = duration;
        this.examId = examId;
        this.examType = examType;
        this.isShared = isShared;
    }

    public UUID getExamId() {
        return examId;
    }

    public void setExamId(UUID examId) {
        this.examId = examId;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public String getExamType() {
        return examType;
    }

    public void setExamType(String examType) {
        this.examType = examType;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public boolean isIsShared() {
        return isShared;
    }

    public void setIsShared(boolean isShared) {
        this.isShared = isShared;
    }




}
