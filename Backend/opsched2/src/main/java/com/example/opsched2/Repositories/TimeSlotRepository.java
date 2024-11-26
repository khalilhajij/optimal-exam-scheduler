package com.example.opsched2.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.opsched2.Entity.TimeSlot;


public interface TimeSlotRepository extends JpaRepository<TimeSlot, Long> {
}
