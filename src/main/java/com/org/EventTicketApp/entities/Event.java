/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.org.EventTicketApp.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
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
@Data @NoArgsConstructor @AllArgsConstructor
public class Event {
    
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private long id;

  @NonNull
  private String title;
  @NonNull
  private String description;
  @NonNull
  private int capacity;
  @NonNull
  private int organizer;
  @NotNull
  private String startAt;
  @NotNull
  private String endAt;
  @NotNull
  private String type;
  @NotNull
  private String location;
  @NotNull
  private String state;

  


  
  }

