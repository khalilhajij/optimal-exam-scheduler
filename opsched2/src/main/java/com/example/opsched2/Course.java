package com.example.opsched2;

import java.util.List;

public class Course {
    private String name;
    private String semester;
    private List<String> prerequisites;

    public Course(String name, String semester, List<String> prerequisites) {
        this.name = name;
        this.semester = semester;
        this.prerequisites = prerequisites;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public String getSemester() {
        return semester;
    }

    public List<String> getPrerequisites() {
        return prerequisites;
    }
}


