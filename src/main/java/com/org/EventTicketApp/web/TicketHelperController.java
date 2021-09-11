/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.org.EventTicketApp.web;

import com.org.EventTicketApp.entities.TicketHelper;
import com.org.EventTicketApp.repo.TicketHelperRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author DEEV
 */
@RestController
public class TicketHelperController {
    @Autowired
    private TicketHelperRepo tickethelperRepo;
    @RequestMapping("/ticketsHelpers")
    public Iterable<TicketHelper> getTicketHelpers(){
    return tickethelperRepo.findAll();
    
}
}
