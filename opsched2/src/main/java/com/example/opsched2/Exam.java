package com.example.opsched2;

import ai.timefold.solver.core.api.domain.entity.PlanningEntity;
import ai.timefold.solver.core.api.domain.variable.PlanningVariable;

@PlanningEntity
public class Exam {
    private Course course;
    private TimeSlot timeSlot;

    public Exam() {}  // Default constructor required by Timefold

    public Exam(Course course) {
        this.course = course;
    }

    public Course getCourse() {
        return course;
    }

    @PlanningVariable(valueRangeProviderRefs = "timeSlotRange")
    public TimeSlot getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(TimeSlot timeSlot) {
        this.timeSlot = timeSlot;
    }
}
