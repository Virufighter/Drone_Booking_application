package com.example.Drone_Booking_application.Entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "booking")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookingId;
    private String Location;
    private String time;
    private String shot;
    @OneToOne
    private User user;
}
