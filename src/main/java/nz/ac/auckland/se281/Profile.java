package nz.ac.auckland.se281;

import java.util.ArrayList;

public class Profile {

  // instance fields
  private String name;
  private int age;

  private ArrayList<Policy> profilePolicies = new ArrayList();

  public Profile(String name, int age) {
    // constructor
    this.name = name;
    this.age = age;
  }

  public String getUserName() {
    // get name
    return this.name;
  }

  public int getAge() {
    // get age
    return this.age;
  }

  public void addPolicy(Policy policy) {
    profilePolicies.add(policy);
  }

  public ArrayList<Policy> getPolicies() {
    return profilePolicies;
  }
}
