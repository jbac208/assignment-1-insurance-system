package nz.ac.auckland.se281;

import java.util.ArrayList;

import nz.ac.auckland.se281.Main.PolicyType;

public class InsuranceSystem {
  public InsuranceSystem() {
    // Only this constructor can be used (if you need to initialise fields).

    // init arraylist for profile database
    ArrayList<Profile> profiles = new ArrayList<>();

  }

  public void printDatabase() {
    // TODO: Complete this method.
    //MessageCli.PRINT_DB_POLICY_COUNT.printMessage("3", "s", ".");
    System.out.println("Database has 0 profiles.");
  }

  public void createNewProfile(String userName, String age) {
    // TODO: Complete this method.

  }

  public void loadProfile(String userName) {
    // TODO: Complete this method.
  }

  public void unloadProfile() {
    // TODO: Complete this method.
  }

  public void deleteProfile(String userName) {
    // TODO: Complete this method.
  }

  public void createPolicy(PolicyType type, String[] options) {
    // TODO: Complete this method.
  }
}
