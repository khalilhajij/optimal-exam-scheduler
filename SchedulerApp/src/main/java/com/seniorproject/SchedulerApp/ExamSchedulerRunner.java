package com.seniorproject.SchedulerApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.seniorproject.SchedulerApp.Model.Exam;
import com.seniorproject.SchedulerApp.Model.ExamSchedule;
import com.seniorproject.SchedulerApp.Model.TimeSlot;
import com.seniorproject.SchedulerApp.Repositories.ExamRepository;
import com.seniorproject.SchedulerApp.Repositories.TimeSlotRepository;
import com.seniorproject.SchedulerApp.Service.ExamScheduleService;

import java.util.List;

@Component
public class ExamSchedulerRunner implements CommandLineRunner {

    @Autowired
    private ExamScheduleService examScheduleService;

    @Autowired
    private ExamRepository examRepository;

    @Autowired
    private TimeSlotRepository timeSlotRepository;

    @Override
    public void run(String... args) throws Exception {
        // Load the list of exams and time slots from the database
        List<Exam> examList = examRepository.findAll();
        List<TimeSlot> timeSlotList = timeSlotRepository.findAll();

        // Solve the exam schedule
        ExamSchedule unsolvedExamSchedule = new ExamSchedule();
        unsolvedExamSchedule.setExamList(examList);
        unsolvedExamSchedule.setTimeSlotList(timeSlotList);

        ExamSchedule solvedExamSchedule = examScheduleService.solveExamSchedule(unsolvedExamSchedule);

        // Display or save the solution
        displaySolution(solvedExamSchedule);
    }

    private void displaySolution(ExamSchedule solvedExamSchedule) {
        for (Exam exam : solvedExamSchedule.getExamList()) {
            System.out.println("Exam ID: " + exam.getId() + ", Course: " + exam.getCourse().getCourseName() + ", TimeSlot: " + exam.getTimeSlot().getDay() + " " + exam.getTimeSlot().getTime());
        }
    }
}