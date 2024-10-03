package com.example.opsched2;

import ai.timefold.solver.core.api.score.buildin.hardsoft.HardSoftScore;
import ai.timefold.solver.core.api.score.stream.Constraint;
import ai.timefold.solver.core.api.score.stream.ConstraintFactory;
import ai.timefold.solver.core.api.score.stream.ConstraintProvider;

public class ExamConstraintProvider implements ConstraintProvider {

    @Override
    public Constraint[] defineConstraints(ConstraintFactory constraintFactory) {
        return new Constraint[]{           
            prerequisiteExamBeforeDependent(constraintFactory),
            noSameDayAndTimeExams(constraintFactory),
            atLeastOneDayGapForAllSemesters(constraintFactory)
        };
    }
    
    private Constraint prerequisiteExamBeforeDependent(ConstraintFactory constraintFactory) {
        return constraintFactory
            .forEach(Exam.class)
            .join(Exam.class)
            .filter((exam1, exam2) -> 
                exam2.getCourse().getPrerequisites().contains(exam1.getCourse().getName()) &&
                exam1.getTimeSlot().getDay() > exam2.getTimeSlot().getDay()) // Change to '>'
            .penalize(HardSoftScore.ONE_HARD, (exam1, exam2) -> 1)  // Ensure prerequisites are before dependent exams
            .asConstraint("Prerequisite exam after dependent");
    }
    
    

    private Constraint noSameDayAndTimeExams(ConstraintFactory constraintFactory) {
        return constraintFactory
            .forEach(Exam.class)
            .join(Exam.class)
            .filter((exam1, exam2) -> 
                exam1 != exam2 && 
                exam1.getTimeSlot().getDay() == exam2.getTimeSlot().getDay() &&
                exam1.getTimeSlot().getTime().equals(exam2.getTimeSlot().getTime()) &&
                exam1.getCourse().getSemester().equals(exam2.getCourse().getSemester())) // Add semester check
            .penalize(HardSoftScore.ONE_HARD, (exam1, exam2) -> 1)  // Match weight is 1
            .asConstraint("No same day and time exams");
    }
    
    
    

    private Constraint atLeastOneDayGapForAllSemesters(ConstraintFactory constraintFactory) {
        return constraintFactory
            .forEach(Exam.class)
            .join(Exam.class)
            .filter((exam1, exam2) -> 
                exam1 != exam2 && 
                exam1.getCourse().getSemester().equals(exam2.getCourse().getSemester()) &&
                Math.abs(exam1.getTimeSlot().getDay() - exam2.getTimeSlot().getDay()) < 2) // Ensure no exams on consecutive days
            .penalize(HardSoftScore.ONE_HARD, (exam1, exam2) -> 1)
            .asConstraint("At least one full day gap between exams in the same semester");
    }
    
    
}
