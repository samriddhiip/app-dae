package com.eventplanning.evento.repository;

import com.eventplanning.evento.model.Organizers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizersRepository extends JpaRepository<Organizers, Integer> {
}
