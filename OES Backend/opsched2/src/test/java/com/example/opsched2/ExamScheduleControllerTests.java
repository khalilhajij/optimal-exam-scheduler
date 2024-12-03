package com.example.opsched2;

import com.example.opsched2.Entity.Exam;
import com.example.opsched2.Entity.ExamSchedule;
import com.example.opsched2.Entity.TimeSlot;
import com.example.opsched2.Repositories.ExamRepository;
import com.example.opsched2.Controller.ExamScheduleController;
import com.example.opsched2.Repositories.TimeSlotRepository;
import ai.timefold.solver.core.api.solver.SolverManager;
import ai.timefold.solver.core.api.solver.SolverJob;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Collections;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

public class ExamScheduleControllerTests {

    @Mock
    private SolverManager<ExamSchedule, Long> solverManager;

    @Mock
    private ExamRepository examRepository;

    @Mock
    private TimeSlotRepository timeSlotRepository;

    @InjectMocks
    private ExamScheduleController examScheduleController;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(examScheduleController).build();
    }

    @Test
    public void testGetSchedule() throws Exception {
        System.out.println("Running testGetSchedule");
        when(examRepository.findAll()).thenReturn(Collections.emptyList());
        when(timeSlotRepository.findAll()).thenReturn(Collections.emptyList());

        mockMvc.perform(get("/api/schedule")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$").isEmpty());
    }

    @SuppressWarnings("unchecked")
    @Test
    public void testGenerateSchedule() throws Exception {
        System.out.println("Running testGenerateSchedule");
        List<Exam> exams = Collections.singletonList(new Exam());
        List<TimeSlot> timeSlots = Collections.singletonList(new TimeSlot(1, "09:00"));

        when(examRepository.findAll()).thenReturn(exams);
        when(timeSlotRepository.findAll()).thenReturn(timeSlots);

        SolverJob<ExamSchedule, Long> solverJob = Mockito.mock(SolverJob.class);
        when(solverManager.solve(any(Long.class), any(ExamSchedule.class))).thenReturn(solverJob);
        when(solverJob.getFinalBestSolution()).thenReturn(new ExamSchedule(exams, timeSlots));

        mockMvc.perform(post("/api/schedule/generate")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray());
    }
}