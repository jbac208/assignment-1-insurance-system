package nz.ac.auckland.se281;

import java.util.ArrayList;

public class Profile {

  // instance fields
  private String name;
  private int age;

  private ArrayList<Policy> profilePolicies = new ArrayList<Policy>();

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

  public void setPremiumDiscounts() {
    int policyCount = profilePolicies.size();
    if (policyCount == 2) {
      for (Policy policy : profilePolicies) {
        policy.setDiscountedPremium(policy.getBasePremium() * (1 - 0.1)); // 10% discount
      }
    } else if (policyCount >= 3) {
      for (Policy policy : profilePolicies) {
        policy.setDiscountedPremium(policy.getBasePremium() * (1 - 0.2)); // 20% discount
      }
    } else {
      for (Policy policy : profilePolicies) {
        policy.setDiscountedPremium(policy.getBasePremium()); // 0% discount
      }
    }
  }

  public int calculatePoliciesSum() {
    setPremiumDiscounts(); // finalise prices of policies before summing
    int sum = 0;
    for (Policy policy : profilePolicies) {
      sum += policy.getDiscountedPremium();
    }
    return sum;
  }
}
