package com.seniorproject.SchedulerApp.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.seniorproject.SchedulerApp.Model.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {
}