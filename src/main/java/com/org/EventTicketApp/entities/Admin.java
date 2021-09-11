package com.org.EventTicketApp.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @RequiredArgsConstructor
public class Admin {
	
	 @Id
	  @GeneratedValue(strategy=GenerationType.AUTO)
	  private long id;

	  @NonNull
	  private String FullName;
	  @NonNull
	  private String login;
	  @NonNull
	  private String password;
	  @NonNull
	  private int active=1;
	

}
