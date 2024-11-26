package com.example.opsched2.Controller;

import com.example.opsched2.Entity.Exam;
import com.example.opsched2.Entity.ExamSchedule;
import com.example.opsched2.Entity.TimeSlot;
import com.example.opsched2.Repositories.ExamRepository;
import com.example.opsched2.Repositories.TimeSlotRepository;
import ai.timefold.solver.core.api.solver.SolverManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class ExamScheduleController {

    @Autowired
    private SolverManager<ExamSchedule, Long> solverManager;

    @Autowired
    private ExamRepository examRepository;

    @Autowired
    private TimeSlotRepository timeSlotRepository;

    @GetMapping("/schedule")
    public List<Exam> getSchedule() throws ExecutionException, InterruptedException {
        // Fetch data from the database
        List<Exam> exams = examRepository.findAll();
        List<TimeSlot> timeSlots = timeSlotRepository.findAll();

        // Create a problem instance
        ExamSchedule problem = new ExamSchedule(exams, timeSlots);

        // Solve the problem
        ExamSchedule solution = solverManager.solve(1L, problem).getFinalBestSolution();

        // Sort the exams by day and time
        return solution.getExamList().stream()
                .sorted(Comparator.comparing((Exam e) -> e.getTimeSlot().getDay())
                        .thenComparing(e -> e.getTimeSlot().getTime()))
                .collect(Collectors.toList());
    }
}
