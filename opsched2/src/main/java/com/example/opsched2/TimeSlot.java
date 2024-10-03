package com.example.opsched2;

public class TimeSlot {
    private int day;
    private String time;

    public TimeSlot(int day, String time) {
        this.day = day;
        this.time = time;
    }

    public int getDay() {
        return day;
    }

    public String getTime() {
        return time;
    }
}
