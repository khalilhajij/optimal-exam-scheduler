package com.example.opsched2;

import com.example.opsched2.Entity.Course;
import com.example.opsched2.Repositories.CourseRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@ActiveProfiles("test")
public class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void testFindById() {
        Course course = new Course();
        course.setName("Test Course");
        courseRepository.save(course);

        Optional<Course> foundCourse = courseRepository.findById(course.getName());
        assertTrue(foundCourse.isPresent());
        assertEquals("Test Course", foundCourse.get().getName());
    }
}