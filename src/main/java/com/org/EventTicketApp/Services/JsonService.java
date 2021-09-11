/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.org.EventTicketApp.Services;

import com.org.EventTicketApp.entities.Event;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;

/**
 *
 * @author DEEV
 */
@Service
public class JsonService {
    public Event getJson(String event) {

		Event eventJson = new Event();
		
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			eventJson = objectMapper.readValue(event, Event.class);
		} catch (IOException err) {
			System.out.printf("Error", err.toString());
		}
		
		
		return eventJson;

	}
}
