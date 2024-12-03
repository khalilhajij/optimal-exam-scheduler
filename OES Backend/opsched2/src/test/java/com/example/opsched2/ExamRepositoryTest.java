package com.example.opsched2;

import com.example.opsched2.Entity.Exam;
import com.example.opsched2.Repositories.ExamRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@ActiveProfiles("test")
public class ExamRepositoryTest {

    @Autowired
    private ExamRepository examRepository;

    @AfterEach
    public void cleanup() {
        examRepository.deleteAll();
    }

    @Test
    public void testFindById() {
        Exam exam = new Exam();
        examRepository.save(exam);

        Optional<Exam> foundExam = examRepository.findById(exam.getId());
        assertTrue(foundExam.isPresent());
        assertEquals(exam.getId(), foundExam.get().getId());
    }
}