package com.example.opsched2.Entity;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.util.List;
import java.util.Map;

@Entity
public class Course {
    @Id
    private String name;

    @ElementCollection
    private Map<String, String> majorToSemester; // Map to handle semester per major

    @ElementCollection
    private List<String> prerequisites;

    @ElementCollection
    private List<String> majors; // New field for majors

    public Course() {}

    public Course(String name, Map<String, String> majorToSemester, List<String> prerequisites, List<String> majors) {
        this.name = name;
        this.majorToSemester = majorToSemester;
        this.prerequisites = prerequisites;
        this.majors = majors;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public Map<String, String> getMajorToSemester() {
        return majorToSemester;
    }
    

    public void setName(String name) {
        this.name = name;
    }

    public void setMajorToSemester(Map<String, String> majorToSemester) {
        this.majorToSemester = majorToSemester;
    }

    public void setPrerequisites(List<String> prerequisites) {
        this.prerequisites = prerequisites;
    }

    public String getSemesterForMajor(String major) {
        return majorToSemester.get(major);  // Get the semester for a specific major
    }

    public List<String> getPrerequisites() {
        return prerequisites;
    }

    public List<String> getMajors() {
        return majors;
    }

    public void setMajors(List<String> majors) {
        this.majors = majors;
    }

}