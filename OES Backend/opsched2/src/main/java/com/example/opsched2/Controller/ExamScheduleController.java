package com.example.opsched2.Controller;

import com.example.opsched2.Entity.Exam;
import com.example.opsched2.Entity.ExamSchedule;
import com.example.opsched2.Entity.TimeSlot;
import com.example.opsched2.Repositories.ExamRepository;
import com.example.opsched2.Repositories.TimeSlotRepository;
import ai.timefold.solver.core.api.solver.SolverManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    private ExamSchedule savedSchedule;
    

    @GetMapping("/schedule")
    public List<Exam> getSchedule() throws ExecutionException, InterruptedException {
        if (savedSchedule != null) {
            return savedSchedule.getExamList().stream()
                    .sorted(Comparator.comparing((Exam e) -> e.getTimeSlot().getDay())
                            .thenComparing(e -> e.getTimeSlot().getTime()))
                    .collect(Collectors.toList());
        }
        return List.of();
    }

    @GetMapping("/schedule/exist")
    public boolean scheduleExists() {
        return savedSchedule != null;
    }

    @PostMapping("/schedule/generate")
    public List<Exam> generateSchedule() throws ExecutionException, InterruptedException {
        List<Exam> exams = examRepository.findAll();
        List<TimeSlot> timeSlots = timeSlotRepository.findAll();

        ExamSchedule unsolvedSchedule = new ExamSchedule(exams, timeSlots);
        ExamSchedule solvedSchedule = solverManager.solve(1L, unsolvedSchedule).getFinalBestSolution();

        savedSchedule = solvedSchedule;

        return solvedSchedule.getExamList().stream()
                .sorted(Comparator.comparing((Exam e) -> e.getTimeSlot().getDay())
                        .thenComparing(e -> e.getTimeSlot().getTime()))
                .collect(Collectors.toList());
    }

    @PostMapping("/schedule/save")
    public void saveSchedule(@RequestBody ExamSchedule schedule) {
        savedSchedule = schedule;
    }

    @DeleteMapping("/schedule/delete")
    public void deleteSchedule() {
        savedSchedule = null;
    }
}