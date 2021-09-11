/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.org.EventTicketApp.entities;

import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
public class Guest {
     @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private long id;

  @NonNull
  private String FullName;
  @NonNull
  private String Email;
   @NonNull
  private String phone;
  @NonNull
  private String cin;
  @NonNull 
  private String qrCode;
  @NonNull
  @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;
}
