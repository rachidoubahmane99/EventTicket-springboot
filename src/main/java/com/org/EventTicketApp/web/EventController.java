/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.org.EventTicketApp.web;

import com.org.EventTicketApp.entities.Event;
import com.org.EventTicketApp.repo.EventRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author DEEV
 */
@RestController
public class EventController {
    @Autowired
    private EventRepo eventrepo;
    @RequestMapping("/events")
    public Iterable<Event> getEvents(){
    return eventrepo.findAll();
 }

    
}
