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
import java.util.Map;

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
                        
                        //new Course("CS101", Map.of("SE", "1st Semester", "CS", "1st Semester", "IS", "2nd Semester"), List.of(), List.of("SE", "CS", "IS"));


                        // SE, CS, and IS Shared Courses
                        new Exam(new Course("CS101", Map.of("SE", "1st Semester", "CS", "1st Semester", "IS", "1st Semester"), List.of(), List.of("SE", "CS", "IS"))),
                        new Exam(new Course("MATH111", Map.of("SE", "1st Semester", "CS", "1st Semester", "IS", "1st Semester"), List.of(), List.of("SE", "CS", "IS"))),
                        new Exam(new Course("ENG101", Map.of("SE", "1st Semester", "CS", "1st Semester", "IS", "1st Semester"), List.of(), List.of("SE", "CS", "IS"))),
                        new Exam(new Course("ISC101", Map.of("SE", "1st Semester", "CS", "1st Semester", "IS", "1st Semester"), List.of(), List.of("SE", "CS", "IS"))),
                        new Exam(new Course("ARAB101", Map.of("SE", "1st Semester", "CS", "1st Semester", "IS", "1st Semester"), List.of(), List.of("SE", "CS", "IS"))),
                        
                        new Exam(new Course("CS102", Map.of("SE", "2nd Semester", "CS", "2nd Semester", "IS", "2nd Semester"), List.of("CS101"), List.of("SE", "CS", "IS"))),
                        new Exam(new Course("CS175", Map.of("SE", "2nd Semester", "CS", "2nd Semester", "IS", "2nd Semester"), List.of(), List.of("SE", "CS", "IS"))),
                        new Exam(new Course("STAT101", Map.of("SE", "2nd Semester", "CS", "2nd Semester", "IS", "2nd Semester"), List.of("MATH111"), List.of("SE", "CS", "IS"))),
                        new Exam(new Course("ENG103", Map.of("SE", "2nd Semester", "CS", "2nd Semester", "IS", "2nd Semester"), List.of("ENG101"), List.of("SE", "CS", "IS"))),
                        new Exam(new Course("ISC103", Map.of("SE", "2nd Semester", "CS", "2nd Semester", "IS", "2nd Semester"), List.of("ISC101"), List.of("SE", "CS", "IS"))),
                        
                        new Exam(new Course("CS285", Map.of("SE", "3rd Semester", "CS", "3rd Semester", "IS", "3rd Semester"), List.of("CS101"), List.of("SE", "CS", "IS"))),
                        new Exam(new Course("CS210", Map.of("SE", "3rd Semester", "CS", "3rd Semester", "IS", "3rd Semester"), List.of("CS102"), List.of("SE", "CS", "IS"))),
                        new Exam(new Course("COM201", Map.of("SE", "3rd Semester", "CS", "3rd Semester", "IS", "3rd Semester"), List.of("ENG101"), List.of("SE", "CS", "IS"))),
                        
                        new Exam(new Course("CS330", Map.of("SE", "4th Semester", "CS", "4th Semester", "IS", "4th Semester"), List.of("CS210"), List.of("SE", "CS", "IS"))),
                        new Exam(new Course("PSY101", Map.of("SE", "4th Semester", "CS", "4th Semester", "IS", "4th Semester"), List.of(), List.of("SE", "CS", "IS"))),
                        new Exam(new Course("ARAB103", Map.of("SE", "5th Semester", "CS", "4th Semester", "IS", "3rd Semester"), List.of(), List.of("SE", "CS", "IS"))),
                                                
                        new Exam(new Course("CS331", Map.of("SE", "5th Semester", "CS", "5th Semester", "IS", "5th Semester"), List.of("CS175"), List.of("SE", "CS", "IS"))),
                        new Exam(new Course("CYS401", Map.of("SE", "5th Semester", "CS", "5th Semester", "IS", "5th Semester"), List.of(), List.of("SE", "CS", "IS"))),
                        new Exam(new Course("ISC203", Map.of("SE", "5th Semester", "CS", "6th Semester", "IS", "7th Semester"), List.of("ISC103"), List.of("SE", "CS", "IS"))),
                        new Exam(new Course("ETHC303", Map.of("SE", "6th Semester", "CS", "5th Semester", "IS", "6th Semester"), List.of(), List.of("SE", "CS", "IS"))),
                        
                        new Exam(new Course("ARAB203", Map.of("SE", "7th Semester", "CS", "7th Semester", "IS", "7th Semester"), List.of("ARAB101"), List.of("SE", "CS", "IS"))),
                        
                        // SE, CS Shared Courses
                        new Exam(new Course("SE201", Map.of("SE", "3rd Semester", "CS", "4th Semester"), List.of("CS102", "ENG103"), List.of("SE", "CS"))),
                        new Exam(new Course("SE371", Map.of("SE", "6th Semester", "CS", "6th Semester"), List.of("CS210"), List.of("SE", "CS"))),
                        new Exam(new Course("MATH113", Map.of("SE", "2nd Semester", "CS", "2nd Semester"), List.of("MATH111"), List.of("SE", "CS"))),
                        new Exam(new Course("CS340", Map.of("SE", "5th Semester", "CS", "5th Semester"), List.of("CS210"), List.of("SE", "CS"))),
                        
                        // IS, CS Shared Courses
                        new Exam(new Course("SCI101", Map.of("CS", "1st Semester", "IS", "1st Semester"), List.of(), List.of("IS", "CS"))),
                        
                        // SE-only Courses
                        new Exam(new Course("CHM101", Map.of("SE", "1st Semester"), List.of(), List.of("SE"))),
                        new Exam(new Course("SE365", Map.of("SE", "4th Semester"), List.of("CS210"), List.of("SE"))),
                        new Exam(new Course("SE311", Map.of("SE", "4th Semester"), List.of("SE201"), List.of("SE"))),
                        new Exam(new Course("SE322", Map.of("SE", "5th Semester"), List.of("SE311"), List.of("SE"))),
                        new Exam(new Course("SE401", Map.of("SE", "6th Semester"), List.of(), List.of("SE"))),
                        new Exam(new Course("SE423", Map.of("SE", "7th Semester"), List.of("CYS401"), List.of("SE"))),
                        new Exam(new Course("SE411", Map.of("SE", "7th Semester"), List.of("SE401"), List.of("SE"))),
                        new Exam(new Course("MATH223", Map.of("SE", "4th Semester"), List.of("MATH113"), List.of("SE"))),
                        
                        // CS-only Courses
                        new Exam(new Course("CS223", Map.of("CS", "3rd Semester"), List.of("CS101", "MATH113"), List.of("CS"))),
                        new Exam(new Course("CS320", Map.of("CS", "4th Semester"), List.of("CS210"), List.of("CS"))),
                        new Exam(new Course("CS311", Map.of("CS", "5th Semester"), List.of("CS285", "CS210"), List.of("CS"))),
                        new Exam(new Course("CS435", Map.of("CS", "6th Semester"), List.of("CS330", "CS331"), List.of("CS"))),
                        
                        // IS-only Courses
                        new Exam(new Course("BUS101", Map.of("IS", "2nd Semester"), List.of(), List.of("IS"))),
                        new Exam(new Course("ACC111", Map.of("IS", "3rd Semester"), List.of(), List.of("IS"))),
                        new Exam(new Course("IS201", Map.of("IS", "3rd Semester"), List.of(), List.of("IS"))),
                        new Exam(new Course("IS205", Map.of("IS", "4th Semester"), List.of(), List.of("IS"))),
                        new Exam(new Course("IS231", Map.of("IS", "4th Semester"), List.of(), List.of("IS"))),
                        new Exam(new Course("IS241", Map.of("IS", "4th Semester"), List.of(), List.of("IS"))),
                        new Exam(new Course("IS321", Map.of("IS", "5th Semester"), List.of(), List.of("IS"))),
                        new Exam(new Course("MKT301", Map.of("IS", "5th Semester"), List.of(), List.of("IS"))),
                        new Exam(new Course("ECON101", Map.of("IS", "5th Semester"), List.of(), List.of("IS"))),
                        new Exam(new Course("IS311", Map.of("IS", "6th Semester"), List.of(), List.of("IS"))),
                        new Exam(new Course("IS361", Map.of("IS", "6th Semester"), List.of(), List.of("IS"))),
                        new Exam(new Course("IS371", Map.of("IS", "6th Semester"), List.of(), List.of("IS"))),
                        new Exam(new Course("COM301", Map.of("IS", "7th Semester"), List.of(), List.of("IS"))),
                        new Exam(new Course("FIN210", Map.of("IS", "7th Semester"), List.of(), List.of("IS")))


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
