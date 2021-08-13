package com.org.EventTicketApp;

import com.org.EventTicketApp.entities.Event;
import com.org.EventTicketApp.repo.EventRepo;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EventTicketAppApplication {


	public static void main(String[] args) {
		SpringApplication.run(EventTicketAppApplication.class, args);
	}

        
}
