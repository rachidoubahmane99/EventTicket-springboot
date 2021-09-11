package com.org.EventTicketApp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.org.EventTicketApp.entities.Admin;
import com.org.EventTicketApp.entities.Event;
import com.org.EventTicketApp.repo.AdminRepo;
import com.org.EventTicketApp.repo.EventManagerRepo;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class AdminController {
	
	@Autowired
    private AdminRepo adminRepo;
    @RequestMapping("/admins")
	    public Iterable<Admin> getEventManagers(){
	    return adminRepo.findAll();
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(method=RequestMethod.DELETE, value = "/admins/{id}")
	public void deleteAdmin(@PathVariable Long id) {
		adminRepo.deleteById(id);
	}
    
    @RequestMapping(method=RequestMethod.POST, value="/admins")
	public void addAdmin(@RequestBody Admin admin) {
		adminRepo.save(admin);
	}
    
    @RequestMapping("/CancelAdmin/{id}")
	public void cancelAdmin(@PathVariable Long id) {
    	adminRepo.CancelAdmin(id);
	}
    
    @RequestMapping("/ActiveAdmin/{id}")
	public void ActiveAdmin(@PathVariable Long id) {
    	adminRepo.ActiveAdmin(id);
	}
    
    @RequestMapping("/getCountEvents")
   	public int getCountEvents() {
       	return adminRepo.getCountEvents();
   	}
    
    @RequestMapping("/getCountEventManager")
   	public int getCountEventManager() {
       	return adminRepo.getCountEventManager();
   	}
    
    @RequestMapping("/getCountGuests/")
   	public int getCountGuests() {
       	return adminRepo.getCountGuests();
   	}
    
    

}
