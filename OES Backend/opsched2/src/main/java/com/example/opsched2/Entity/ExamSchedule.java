package com.example.opsched2.Entity;

import ai.timefold.solver.core.api.domain.solution.PlanningSolution;
import ai.timefold.solver.core.api.domain.solution.PlanningEntityCollectionProperty;
import ai.timefold.solver.core.api.domain.solution.PlanningScore;
import ai.timefold.solver.core.api.domain.valuerange.ValueRangeProvider;
import ai.timefold.solver.core.api.score.buildin.hardsoft.HardSoftScore;

import java.util.List;

@PlanningSolution
public class ExamSchedule {

    private List<Exam> examList;
    private List<TimeSlot> timeSlotList;

    @PlanningScore
    private HardSoftScore score;

    // Default constructor required by Timefold
    public ExamSchedule() {
    }

    public ExamSchedule(List<Exam> examList, List<TimeSlot> timeSlotList) {
        this.examList = examList;
        this.timeSlotList = timeSlotList;
    }

    // Planning entities: the list of exams
    @PlanningEntityCollectionProperty
    public List<Exam> getExamList() {
        return examList;
    }

    // Value range provider for time slots
    @ValueRangeProvider(id = "timeSlotRange")
    public List<TimeSlot> getTimeSlotList() {
        return timeSlotList;
    }

    public HardSoftScore getScore() {
        return score;
    }

    public void setScore(HardSoftScore score) {
        this.score = score;
    }
}