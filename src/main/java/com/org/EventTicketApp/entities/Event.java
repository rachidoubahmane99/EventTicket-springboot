/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.org.EventTicketApp.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;
import java.util.Collection;
import java.sql.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.hibernate.FetchMode;
import org.hibernate.annotations.Fetch;


/**
 *
 * @author DEEV
 */
@Entity
@Data @NoArgsConstructor @AllArgsConstructor @RequiredArgsConstructor
public class Event {
    
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  public long id;

  @NonNull
  private String title;
  @NonNull
  private String description;
  @NonNull
  private String location;
  @NonNull
  private Date date;
  @NonNull
  private String time;
  @NonNull
  private int capacity;  
   @NonNull
  private String state;
   @NonNull
  private int active =1;
  @NonNull
  @JsonProperty("eventManager")
  @ManyToOne
  private EventManager eventManager;
  @NonNull
  @OneToOne(cascade = CascadeType.PERSIST)
  private TicketHelper customTicket;
  

   



  
  }

