package com.seniorproject.SchedulerApp;

import com.seniorproject.SchedulerApp.Model.Exam;

import ai.timefold.solver.core.api.score.buildin.hardsoft.HardSoftScore;
import ai.timefold.solver.core.api.score.stream.Constraint;
import ai.timefold.solver.core.api.score.stream.ConstraintFactory;
import ai.timefold.solver.core.api.score.stream.ConstraintProvider;

public class ExamConstraintProvider implements ConstraintProvider {

    @Override
    public Constraint[] defineConstraints(ConstraintFactory constraintFactory) {
        return new Constraint[]{           
            prerequisiteExamBeforeDependent(constraintFactory),
            noSameDayAndTimeExamsForSameMajor(constraintFactory),
            atLeastOneDayGapForAllSemesters(constraintFactory)
        };
    }
    
    private Constraint prerequisiteExamBeforeDependent(ConstraintFactory constraintFactory) {
        return constraintFactory
            .forEach(Exam.class)
            .join(Exam.class)
            .filter((exam1, exam2) -> 
                exam2.getCourse().getPrerequisites().stream()
                    .anyMatch(prerequisite -> prerequisite.getCourseName().equals(exam1.getCourse().getCourseName())) &&
                exam1.getCourse().getAssociatedMajor().stream().anyMatch(major -> exam2.getCourse().getAssociatedMajor().contains(major)) &&  // Match on any major
                exam1.getTimeSlot().getDay() > exam2.getTimeSlot().getDay())  // Ensure prerequisite comes before, unless on the same day
            .penalize(HardSoftScore.ONE_HARD)
            .asConstraint("Prerequisite exam must come before dependent exam for shared majors unless same day");
    }
    
    private Constraint noSameDayAndTimeExamsForSameMajor(ConstraintFactory constraintFactory) {
        return constraintFactory
            .forEach(Exam.class)
            .join(Exam.class)
            .filter((exam1, exam2) -> 
                !exam1.equals(exam2) &&
                exam1.getCourse().getAssociatedMajor().stream().anyMatch(major -> 
                    exam2.getCourse().getAssociatedMajor().contains(major) &&  // Match on any shared major
                    exam1.getCourse().getSemesterForMajor(major).equals(exam2.getCourse().getSemesterForMajor(major))) &&  // Same semester for that major
                exam1.getTimeSlot().getDay() == exam2.getTimeSlot().getDay() && 
                exam1.getTimeSlot().getTime().equals(exam2.getTimeSlot().getTime()))  // Same day and time
            .penalize(HardSoftScore.ONE_HARD)
            .asConstraint("No same day and time exams for shared majors and same semester");
    }
    
    private Constraint atLeastOneDayGapForAllSemesters(ConstraintFactory constraintFactory) {
        return constraintFactory
            .forEach(Exam.class)
            .join(Exam.class)
            .filter((exam1, exam2) -> 
                !exam1.equals(exam2) && 
                exam1.getCourse().getAssociatedMajor().stream().anyMatch(major -> 
                    exam2.getCourse().getAssociatedMajor().contains(major) &&  // Match on any shared major
                    exam1.getCourse().getSemesterForMajor(major).equals(exam2.getCourse().getSemesterForMajor(major))) &&  // Same semester for that major
                Math.abs(exam1.getTimeSlot().getDay() - exam2.getTimeSlot().getDay()) < 2)  // Ensure no consecutive day exams
            .penalize(HardSoftScore.ONE_SOFT)
            .asConstraint("At least one full day gap between exams for shared majors in the same semester");
    }
}