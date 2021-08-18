package com.org.EventTicketApp;

import com.org.EventTicketApp.entities.Event;
import com.org.EventTicketApp.entities.EventManager;
import com.org.EventTicketApp.entities.Guest;
import com.org.EventTicketApp.entities.Ticket;
import com.org.EventTicketApp.entities.TicketHelper;
import com.org.EventTicketApp.repo.EventManagerRepo;
import com.org.EventTicketApp.repo.EventRepo;
import com.org.EventTicketApp.repo.GuestRepo;
import com.org.EventTicketApp.repo.TicketHelperRepo;
import com.org.EventTicketApp.repo.TicketRepo;
import java.sql.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EventTicketAppApplication {
@Autowired
private EventRepo repository;
@Autowired
private GuestRepo guestrepo;
@Autowired
private TicketRepo ticketrepo;
@Autowired
private TicketHelperRepo tickethelperrepo;
@Autowired
private EventManagerRepo managerRepo;


	public static void main(String[] args) {
		SpringApplication.run(EventTicketAppApplication.class, args);
	}

            @Bean
            CommandLineRunner runner(){
            return args -> {
                EventManager manager = new EventManager("rachid", "bio", "password", "avatar");
                managerRepo.save(manager);
                
                Ticket ticket = new Ticket("demoid");
                ticketrepo.save(ticket);
                
                TicketHelper t = new TicketHelper("logo", "titleSize", "descriptionSize", "locationSize",ticket);
                tickethelperrepo.save(t);
                TicketHelper t2 = new TicketHelper("logo2", "titleSize", "descriptionSize", "locationSize",ticket);
                tickethelperrepo.save(t2);
           
                
                Event v = new Event( "title", "description", "location", new Date(0), "time", 10, "state", manager, t);

               Event v2 = new Event( "title2", "description2", "location2", new Date(0), "time2", 10, "state2", manager, t2);

                Guest g = new Guest(3, "FullName", "Email", "cin", "qrCode", v);
                Guest g2 = new Guest(3, "FullName", "Email", "cin", "qrCode", v2);
            
                //guests.add(g);
                //Event vv = new Event(0, "title", "description", "location", "date", "time", 10, "state", eventmanager, guests, t);
                //Event v = new Event(3, "title", "description", "location", new Date(), "time", 10, "state", eventmanager,guests,t);
                
            repository.save(v);
            repository.save(v2);
            guestrepo.save(g);
            guestrepo.save(g2);
 
            };
            }

}
