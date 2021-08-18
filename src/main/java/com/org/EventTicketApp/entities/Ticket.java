/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.org.EventTicketApp.entities;

import com.sun.istack.NotNull;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
public class Ticket {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  private String logo;
  @NonNull
  private String details;

      
   }