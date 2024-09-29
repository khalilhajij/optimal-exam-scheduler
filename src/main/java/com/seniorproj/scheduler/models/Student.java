package com.seniorproj.scheduler.models;

import java.util.UUID;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class Student {
    
  
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private UUID id;
  
    @Id
    private Long studentId;
    private String firstName;
    private String fatherName;
    private String surName;

    @ManyToOne
    @JoinColumn(name = "major_id")
    private Major major;

    private int semester;

    public Student(UUID id, String fatherName, String firstName, Major major, int semester, Long studentId, String surName) {
        this.id = id;
        this.fatherName = fatherName;
        this.firstName = firstName;
        this.major = major;
        this.semester = semester;
        this.studentId = studentId;
        this.surName = surName;
    }

    public UUID getId(){
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public Major getMajor() {
        return major;
    }

    public void setMajor(Major major) {
        this.major = major;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

   


}
