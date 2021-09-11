/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.org.EventTicketApp.repo;


import com.org.EventTicketApp.entities.Event;
import com.org.EventTicketApp.entities.Guest;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author DEEV
 */
public interface GuestRepo extends CrudRepository<Guest, Long> {

    @Query(value= "SELECT * FROM guest  WHERE event_id = :id" ,nativeQuery = true)
    List<Guest[]> findGeustByEventId(@Param("id") Long id);
   
    
}
