package com.org.EventTicketApp.repo;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.org.EventTicketApp.entities.Admin;

public interface AdminRepo extends CrudRepository<Admin, Long>{
	
	@Transactional
	@Modifying
	@Query("update Admin e set e.active = 0 where e.id = ?1")
    void CancelAdmin(Long adminId);
	
	@Transactional
	@Modifying
	@Query("update Admin e set e.active = 1 where e.id = ?1")
	void ActiveAdmin(Long adminId);
	
	
	@Query("select count(*) from Event")
	int getCountEvents();
	
	
	@Query("select count(*) from EventManager")
	int getCountEventManager();
	
	
	@Query("select count(*) from Guest")
	int getCountGuests();

}
