package com.example.Drone_Booking_application.Services.Impl;

import com.example.Drone_Booking_application.Entity.User;
import com.example.Drone_Booking_application.Repository.UserRepository;
import com.example.Drone_Booking_application.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteUsertById(Long id) {
        userRepository.deleteById(id);

    }
}
