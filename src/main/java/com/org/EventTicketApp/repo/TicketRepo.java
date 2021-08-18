/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.org.EventTicketApp.repo;

import com.org.EventTicketApp.entities.Ticket;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author DEEV
 */
public interface TicketRepo extends CrudRepository<Ticket, Long> {
    
}
