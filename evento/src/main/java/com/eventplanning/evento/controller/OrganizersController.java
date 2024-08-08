package com.eventplanning.evento.controller;

import com.eventplanning.evento.model.Organizers;
import com.eventplanning.evento.service.OrganizersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/organizers")
public class OrganizersController {
    
    @Autowired
    private OrganizersService organizersService;
    
    @GetMapping
    public List<Organizers> getAllOrganizers() {
        return organizersService.getAllOrganizers();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Organizers> getOrganizerById(@PathVariable Integer id) {
        Optional<Organizers> organizer = organizersService.getOrganizerById(id);
        return organizer.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    
    @PostMapping("/org")
    public Organizers createOrganizer(@RequestBody Organizers organizer) {
        return organizersService.createOrganizer(organizer);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Organizers> updateOrganizer(@PathVariable Integer id, @RequestBody Organizers organizerDetails) {
        Organizers updatedOrganizer = organizersService.updateOrganizer(id, organizerDetails);
        return updatedOrganizer != null ? ResponseEntity.ok(updatedOrganizer) : ResponseEntity.notFound().build();
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrganizer(@PathVariable Integer id) {
        organizersService.deleteOrganizer(id);
        return ResponseEntity.noContent().build();
    }
}
 