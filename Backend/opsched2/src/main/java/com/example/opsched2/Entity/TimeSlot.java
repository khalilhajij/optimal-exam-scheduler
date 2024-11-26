package com.example.opsched2.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class TimeSlot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int day;
    private String time;

    // Getters, setters, constructors
    public TimeSlot() {
    }

    public TimeSlot(int day, String time) {
        this.day = day;
        this.time = time;
    }

    public Long getId() {
        return id;
    }

    public int getDay() {
        return day;
    }

    public String getTime() {
        return time;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public void setTime(String time) {
        this.time = time;
    }
}