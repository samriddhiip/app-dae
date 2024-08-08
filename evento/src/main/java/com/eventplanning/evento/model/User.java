package com.eventplanning.evento.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user_table")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String roles;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    @JsonManagedReference
    private List<Payment> payments;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    @JsonManagedReference
    private List<Feedback> feedbacks;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    @JsonManagedReference
    private List<Booking> bookings;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<Organizers> organizers; // If needed

    
}
