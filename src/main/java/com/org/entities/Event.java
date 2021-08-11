/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.org.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author DEEV
 */
@Entity
@Table(name = "events")
public class Event {
    
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private int id;

  @Column(name = "title")
  private String name;
  @Column(name = "description")
  private String description;
  @Column(name = "capacity")
  private int capacity;
  @Column(name = "date")
  private String date;
  @Column(name = "hour")
  private String hour;
  @Column(name = "location")
  private String location;
}
