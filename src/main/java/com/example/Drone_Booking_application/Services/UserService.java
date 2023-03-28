package com.example.Drone_Booking_application.Services;

import com.example.Drone_Booking_application.Entity.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User addUser(User user);
    User getUserById(Long id);

    User updateUser(User user);

    void deleteUsertById(Long id);
}
