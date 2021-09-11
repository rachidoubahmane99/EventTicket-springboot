/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.org.EventTicketApp.web;

import com.org.EventTicketApp.entities.Event;
import com.org.EventTicketApp.entities.Guest;
import com.org.EventTicketApp.repo.EventRepo;
import com.org.EventTicketApp.repo.GuestRepo;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author DEEV
 */
@RestController
@CrossOrigin(origins ="http://localhost:3000" )
public class GuestController {
       @Autowired
    private GuestRepo guestrepo;
        @Autowired
    private EventRepo eventrepo;
       
    @RequestMapping("/guests")
    public Iterable<Guest> getTickets(){
    return guestrepo.findAll();
    }
    
    @GetMapping("/guests/{id}")
    public Optional<Guest> getEventById(@PathVariable("id") Long id){
    return guestrepo.findById(id);
 }
    
   @GetMapping("/events/{id}/guests")
    public List<Guest[]> getEvents(@PathVariable("id") Long id){
    System.out.println(guestrepo.findGeustByEventId(id));
    return guestrepo.findGeustByEventId(id);
 }
    
    @PostMapping("/events/MyTicket")
    public Guest getTickets(@RequestBody Guest guest){
         
         return guestrepo.save(guest);
         
    }
}
