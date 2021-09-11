/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.org.EventTicketApp.repo;

import com.org.EventTicketApp.entities.EventManager;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author DEEV
 */
public interface EventManagerRepo extends CrudRepository<EventManager, Long> {
    
    
    @Transactional
	@Modifying
	@Query("update EventManager e set e.active = 0 where e.id = ?1")
    void CancelManager(Long managerId);
	
	@Transactional
	@Modifying
	@Query("update EventManager e set e.active = 1 where e.id = ?1")
    void ActiveManager(Long managerId);
}
