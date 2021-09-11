/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.org.EventTicketApp.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 *
 * @author DEEV
 */
@Entity
@Data @NoArgsConstructor @AllArgsConstructor @RequiredArgsConstructor
public class TicketHelper {
    @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private long id;

  @NonNull
  private String logo;
  @NonNull
  private String titleSize;
  @NonNull
  private String descriptionSize;
  @NonNull
  private String locationSize;
  @OneToOne( cascade = CascadeType.ALL, mappedBy = "customTicket")
  @JsonIgnore 
  private Event event;
  @NonNull
  @OneToOne
  @JoinColumn(name = "tickets_id")
  @JsonProperty("mainTicket")
 private Ticket mainTicket;  
 

    
}
