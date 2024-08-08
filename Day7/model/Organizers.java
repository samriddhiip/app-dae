package com.eventplanning.evento.model;

import lombok.Data;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;

@Data
@Entity
@Table(name = "organizers")
public class Organizers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String rating;
    private String address;
    private String contact;
    private String specialty;

    @Column(name = "image_url")
    private String imageUrl;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user;  // Optional, if you want to link organizers to a user
}
