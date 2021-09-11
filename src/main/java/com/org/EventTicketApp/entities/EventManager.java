/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.org.EventTicketApp.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
public class EventManager {
     @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private long id;

  @NonNull
  private String FullName;
  @NonNull
  private String bio;
  @NotNull
  private String email;
  @NonNull
  private String password;
  @NonNull
  private String avatar;
   private int active =1;
  @NonNull
  @OneToMany( cascade = CascadeType.ALL, mappedBy = "eventManager")
  @JsonIgnore 
  private List<Event> events;
}
