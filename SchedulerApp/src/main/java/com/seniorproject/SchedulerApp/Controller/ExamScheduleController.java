package com.seniorproject.SchedulerApp.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.seniorproject.SchedulerApp.Model.ExamSchedule;
import com.seniorproject.SchedulerApp.Service.ExamScheduleService;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/exam-schedule")
public class ExamScheduleController {

    private static final Logger logger = Logger.getLogger(ExamScheduleController.class.getName());

    private final ExamScheduleService examScheduleService;

    public ExamScheduleController(ExamScheduleService examScheduleService) {
        this.examScheduleService = examScheduleService;
        logger.info("ExamScheduleService: " + (examScheduleService != null));
    }

    @PostMapping("/solve")
    public ResponseEntity<ExamSchedule> solveExamSchedule(@RequestBody ExamSchedule unsolvedExamSchedule) {
        ExamSchedule solvedExamSchedule = examScheduleService.solveExamSchedule(unsolvedExamSchedule);
        return new ResponseEntity<>(solvedExamSchedule, HttpStatus.OK);
    }
}