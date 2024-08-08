package com.eventplanning.evento.service;

import com.eventplanning.evento.model.Organizers;
import com.eventplanning.evento.repository.OrganizersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrganizersService {
    
    @Autowired
    private OrganizersRepository organizersRepository;
    
    public List<Organizers> getAllOrganizers() {
        return organizersRepository.findAll();
    }
    
    public Optional<Organizers> getOrganizerById(Integer id) {
        return organizersRepository.findById(id);
    }
    
    public Organizers createOrganizer(Organizers organizer) {
        return organizersRepository.save(organizer);
    }
    
    public Organizers updateOrganizer(Integer id, Organizers organizerDetails) {
        if (organizersRepository.existsById(id)) {
            organizerDetails.setId(id);
            return organizersRepository.save(organizerDetails);
        }
        return null; // or throw an exception
    }
    
    public void deleteOrganizer(Integer id) {
        if (organizersRepository.existsById(id)) {
            organizersRepository.deleteById(id);
        }
    }
}
