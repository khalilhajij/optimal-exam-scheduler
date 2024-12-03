package com.example.opsched2;

import com.example.opsched2.Entity.Course;
import com.example.opsched2.Entity.Exam;
import com.example.opsched2.Entity.TimeSlot;
import com.example.opsched2.Repositories.CourseRepository;
import com.example.opsched2.Repositories.ExamRepository;
import com.example.opsched2.Repositories.TimeSlotRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@ActiveProfiles("test")
public class ExamScheduleControllerIntegrationTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private ExamRepository examRepository;

    @Autowired
    private TimeSlotRepository timeSlotRepository;

    @Autowired
    private CourseRepository courseRepository;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @AfterEach
    public void cleanup() {
        examRepository.deleteAll();
        timeSlotRepository.deleteAll();
        courseRepository.deleteAll();
    }

    @Test
    public void testGetSchedule() throws Exception {
        mockMvc.perform(get("/api/schedule")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray());
    }

    @Test
    public void testGenerateSchedule() throws Exception {
        // Create and save a Course
        Map<String, String> majorToSemester = new HashMap<>();
        majorToSemester.put("CS", "1st Semester");
        List<String> prerequisites = List.of("Math101");
        List<String> majors = List.of("CS", "SE");
        Course course = new Course("Test Course", majorToSemester, prerequisites, majors);
        courseRepository.save(course);

        // Create and save an Exam with the Course
        Exam exam = new Exam();
        exam.setCourse(course);
        examRepository.save(exam);

        // Create and save a TimeSlot
        TimeSlot timeSlot = new TimeSlot(1, "08:30");
        timeSlotRepository.save(timeSlot);

        mockMvc.perform(post("/api/schedule/generate")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray());
    }
}