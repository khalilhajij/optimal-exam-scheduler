package com.example.opsched2;

import com.example.opsched2.Entity.TimeSlot;
import com.example.opsched2.Repositories.TimeSlotRepository;
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
public class TimeSlotRepositoryTest {

    @Autowired
    private TimeSlotRepository timeSlotRepository;

    @AfterEach
    public void cleanup() {
        timeSlotRepository.deleteAll();
    }

    @Test
    public void testFindById() {
        TimeSlot timeSlot = new TimeSlot(1, "09:00");
        timeSlotRepository.save(timeSlot);

        Optional<TimeSlot> foundTimeSlot = timeSlotRepository.findById(timeSlot.getId());
        assertTrue(foundTimeSlot.isPresent());
        assertEquals("09:00", foundTimeSlot.get().getTime());
    }
}