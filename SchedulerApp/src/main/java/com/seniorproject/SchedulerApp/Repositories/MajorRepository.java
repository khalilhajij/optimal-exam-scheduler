package com.seniorproject.SchedulerApp.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.seniorproject.SchedulerApp.Model.Major;

@Repository
public interface MajorRepository extends JpaRepository<Major, Integer> {
}