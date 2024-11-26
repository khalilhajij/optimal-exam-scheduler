package com.example.opsched2;

import ai.timefold.solver.core.api.solver.SolverManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.opsched2.Entity.Exam;
import com.example.opsched2.Entity.ExamSchedule;
import com.example.opsched2.Entity.TimeSlot;
import com.example.opsched2.Repositories.ExamRepository;
import com.example.opsched2.Repositories.TimeSlotRepository;

import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

@SpringBootApplication
@Controller
public class Opsched2Application {

    public static void main(String[] args) {
        SpringApplication.run(Opsched2Application.class, args);
    }

    @Autowired
    SolverManager<ExamSchedule, Long> solverManager;

    @Autowired
    private ExamRepository examRepository;

    @Autowired
    private TimeSlotRepository timeSlotRepository;

    @GetMapping("/")
    public String schedule(Model model) throws ExecutionException, InterruptedException {
        // Fetch data from the database
        List<Exam> exams = examRepository.findAll();
        List<TimeSlot> timeSlots = timeSlotRepository.findAll();

        // Create a problem instance
        ExamSchedule problem = new ExamSchedule(exams, timeSlots);

        // Solve the problem
        ExamSchedule solution = solverManager.solve(1L, problem).getFinalBestSolution();

        // Sort the exams by day and time
        List<Exam> sortedExams = solution.getExamList().stream()
                .sorted(Comparator.comparing((Exam e) -> e.getTimeSlot().getDay())
                        .thenComparing(e -> e.getTimeSlot().getTime()))
                .collect(Collectors.toList());

        // Add the sorted exam list to the model
        model.addAttribute("examList", sortedExams);

        // Return the Thymeleaf template name (schedule.html)
        return "schedule";
    }
}