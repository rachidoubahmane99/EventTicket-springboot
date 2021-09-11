/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.org.EventTicketApp.web;

import com.org.EventTicketApp.entities.EventManager;
import com.org.EventTicketApp.repo.EventManagerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author DEEV
 */
@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class EventManagerController {
	
	 @Autowired
	    private EventManagerRepo eventManagerRepo;
	    @RequestMapping("/eventManager")
	    public Iterable<EventManager> getEventManagers(){
	    	return eventManagerRepo.findAll();
	    }
	    
	    @RequestMapping("/CancelManager/{id}")
		public void cancelManager(@PathVariable Long id) {
			eventManagerRepo.CancelManager(id);
		}
	    
	    @RequestMapping("/ActiveManager/{id}")
		public void ActiveManager(@PathVariable Long id) {
			eventManagerRepo.ActiveManager(id);
		}
}

