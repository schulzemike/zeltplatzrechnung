package de.tollefreunde.zeltplatzrechnung.campingfreund;

/**
 * Created by Mike Schulze on 16.04.18.
 */
public class StartDO {

  private String name;
  private int numberOfUsers;
  private String surname;

  public String getName() {
    return name;
  }

  public int getNumberOfUsers() {
    return numberOfUsers;
  }

  public void setNumberOfUsers(final int numberOfUsers) {
    this.numberOfUsers = numberOfUsers;
  }

  public String getSurname() {
    return surname;
  }

  public void setSurname(final String surname) {
    this.surname = surname;
  }
}
