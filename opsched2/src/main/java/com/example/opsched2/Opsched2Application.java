package com.example.opsched2;

import ai.timefold.solver.core.api.solver.SolverManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller; // Changed from RestController
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

@SpringBootApplication
@Controller // Changed from RestController
public class Opsched2Application {

    public static void main(String[] args) {
        SpringApplication.run(Opsched2Application.class, args);
    }

    @Autowired
    SolverManager<ExamSchedule, Long> solverManager;

    @GetMapping("/")
    public String schedule(Model model) throws ExecutionException, InterruptedException {
        // Create a problem instance
        ExamSchedule problem = new ExamSchedule(
                List.of(
                        new Exam(new Course("CS101", "1st Semester", List.of())),
                        new Exam(new Course("CHM101", "1st Semester", List.of())),
                        new Exam(new Course("MATH111", "1st Semester", List.of())),
                        new Exam(new Course("ENG101", "1st Semester", List.of())),
                        new Exam(new Course("ISC101", "1st Semester", List.of())),
                        new Exam(new Course("ARAB101", "1st Semester", List.of())),

                        new Exam(new Course("CS102", "2nd Semester", List.of("CS101"))),
                        new Exam(new Course("CS175", "2nd Semester", List.of())),
                        new Exam(new Course("MATH113", "2nd Semester", List.of("MATH111"))),
                        new Exam(new Course("STAT101", "2nd Semester", List.of("MATH111"))),
                        new Exam(new Course("ENG103", "2nd Semester", List.of("ENG101"))),
                        new Exam(new Course("ISC103", "2nd Semester", List.of("ISC101"))),

                        new Exam(new Course("CS285", "3rd Semester", List.of("CS101"))),
                        new Exam(new Course("SE201", "3rd Semester", List.of("CS102"))),
                        new Exam(new Course("PHY105", "3rd Semester", List.of())),
                        new Exam(new Course("COM201", "3rd Semester", List.of("ENG101"))),
                        new Exam(new Course("ISC105", "3rd Semester", List.of("ISC103"))),
                        new Exam(new Course("CS210", "3rd Semester", List.of("CS102"))),

                        new Exam(new Course("SE365", "4th Semester", List.of("CS210"))),
                        new Exam(new Course("SE311", "4th Semester", List.of("SE201"))),
                        new Exam(new Course("CS330", "4th Semester", List.of("CS210"))),
                        new Exam(new Course("PHY205", "4th Semester", List.of("PHY105"))),
                        new Exam(new Course("PSY101", "4th Semester", List.of())),
                        new Exam(new Course("MATH223", "4th Semester", List.of("MATH113"))),

                        new Exam(new Course("CS340", "5th Semester", List.of("CS210"))),
                        new Exam(new Course("CS331", "5th Semester", List.of("CS175"))),
                        new Exam(new Course("SE322", "5th Semester", List.of("SE311"))),
                        new Exam(new Course("CYS401", "5th Semester", List.of())),
                        new Exam(new Course("ISC203", "5th Semester", List.of("ISC103"))),
                        new Exam(new Course("ARAB103", "5th Semester", List.of("ARAB101"))),

                        new Exam(new Course("MATH221", "6th Semester", List.of("MATH113"))),
                        new Exam(new Course("SE371", "6th Semester", List.of("CS210"))),
                        new Exam(new Course("ETHC303", "6th Semester", List.of("CYS401"))),
                        new Exam(new Course("SE401", "6th Semester", List.of())),

                        new Exam(new Course("SE423", "7th Semester", List.of("CYS401"))),
                        new Exam(new Course("SE411", "7th Semester", List.of("SE401"))),
                        new Exam(new Course("ARAB203", "7th Semester", List.of("ARAB101")))
                ),
                List.of(
                        new TimeSlot(0, "08:30"),
                        new TimeSlot(1, "12:30"),
                        new TimeSlot(2, "16:00"),
                        new TimeSlot(3, "08:30"),
                        new TimeSlot(4, "12:30"),
                        new TimeSlot(5, "16:00"),
                        new TimeSlot(6, "08:30"),
                        new TimeSlot(7, "12:30"),
                        new TimeSlot(8, "16:00"),
                        new TimeSlot(9, "08:30"),
                        new TimeSlot(10, "12:30"),
                        new TimeSlot(11, "16:00")
                )
        );

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
