package com.seniorproject.SchedulerApp.Service;

import ai.timefold.solver.core.api.solver.Solver;
import ai.timefold.solver.core.api.solver.SolverFactory;
import org.springframework.stereotype.Service;
import com.seniorproject.SchedulerApp.Model.ExamSchedule;
import java.util.logging.Logger;

@Service
public class ExamScheduleService {

    private static final Logger logger = Logger.getLogger(ExamScheduleService.class.getName());

    public ExamSchedule solveExamSchedule(ExamSchedule unsolvedExamSchedule) {
        logger.info("Starting to solve exam schedule");
        SolverFactory<ExamSchedule> solverFactory = SolverFactory.createFromXmlResource("solverConfig.xml");
        Solver<ExamSchedule> solver = solverFactory.buildSolver();
        ExamSchedule solvedExamSchedule = solver.solve(unsolvedExamSchedule);
        logger.info("Finished solving exam schedule");
        return solvedExamSchedule;
    }
}