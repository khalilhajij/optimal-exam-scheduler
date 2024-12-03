package com.example.opsched2.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.opsched2.Entity.Exam;

public interface ExamRepository extends JpaRepository<Exam, Long> {
}