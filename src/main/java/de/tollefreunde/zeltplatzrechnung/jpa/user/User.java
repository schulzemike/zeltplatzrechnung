package de.tollefreunde.zeltplatzrechnung.jpa.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by Mike Schulze on 23.02.18.
 */
@Entity
public class User {
// for Oracle
//  @GeneratedValue(strategy=SEQUENCE, generator="CUSTOMER_SEQ")
//  SQLServer ?
//  @GeneratedValue(strategy= GenerationType.IDENTITY)
//  @GeneratedValue(strategy= GenerationType.AUTO)

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  private String username;
  private String password;
  private String surname;

  @SuppressWarnings("unused")
  public User() {
  }

  public User(final String username, final String password) {
    this.username = username;
    this.password = password;
  }

  public String getUsername() {
    return username;
  }

  public String getPassword() {
    return password;
  }

  public String getSurname() {
    return surname;
  }

  public void setSurname(final String surname) {
    this.surname = surname;
  }
}
