package com.example.Drone_Booking_application.Repository;

import com.example.Drone_Booking_application.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
