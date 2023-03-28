package com.example.Drone_Booking_application.Repository;

import com.example.Drone_Booking_application.Entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking,Long> {
}
