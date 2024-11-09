package com.seniorproject.SchedulerApp.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.seniorproject.SchedulerApp.Model.Exam;

@Repository
public interface ExamRepository extends JpaRepository<Exam, Long> {
}