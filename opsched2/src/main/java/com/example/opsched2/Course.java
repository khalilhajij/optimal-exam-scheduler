package com.example.opsched2;

import java.util.List;
import java.util.Map;

public class Course {
    private String name;
    private Map<String, String> majorToSemester; // Map to handle semester per major
    private List<String> prerequisites;
    private List<String> majors; // New field for majors

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

    public String getSemesterForMajor(String major) {
        return majorToSemester.get(major);  // Get the semester for a specific major
    }

    public List<String> getPrerequisites() {
        return prerequisites;
    }

    public List<String> getMajors() {
        return majors;
    }
}
