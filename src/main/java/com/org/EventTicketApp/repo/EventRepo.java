/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.org.EventTicketApp.repo;

import com.org.EventTicketApp.entities.Event;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


/**
 *
 * @author DEEV
 */
public interface EventRepo extends CrudRepository<Event, Long> {

 @Query(value= "SELECT * FROM event  WHERE event_manager_id = :id and state='public'" ,nativeQuery = true)
 List<Event[]> FindpublicEvents(@Param("id") Long id);
 
 //private events 
  @Query(value= "SELECT * FROM event  WHERE event_manager_id = :id and state='private'" ,nativeQuery = true)
 List<Event[]> FindprivateEvents(@Param("id") Long id);

 
 //decrease value of capacity
  @Query(value= "UPDATE event\n" +
"SET capacity = capacity -1 \n" +
"WHERE id = :id" ,nativeQuery = true)
 Boolean UpdateEventCapacity(@Param("id") Long id);
    
}
