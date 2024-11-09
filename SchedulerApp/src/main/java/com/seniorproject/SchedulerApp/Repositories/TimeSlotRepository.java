package com.seniorproject.SchedulerApp.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.seniorproject.SchedulerApp.Model.TimeSlot;

@Repository
public interface TimeSlotRepository extends JpaRepository<TimeSlot, Long> {
}