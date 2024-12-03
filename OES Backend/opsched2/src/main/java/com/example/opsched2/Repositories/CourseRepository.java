package com.example.opsched2.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.opsched2.Entity.Course;

public interface CourseRepository extends JpaRepository<Course, String> {
}
