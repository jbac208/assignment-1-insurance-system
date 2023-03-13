package nz.ac.auckland.se281;

import java.util.ArrayList;

import nz.ac.auckland.se281.Main.PolicyType;

public class InsuranceSystem {
  
  // init arraylist of profiles for database
  private ArrayList<Profile> database = new ArrayList<>();

  public InsuranceSystem() {
    // Only this constructor can be used (if you need to initialise fields).

  }

  public void printDatabase() {
    // TODO: Complete this method.
    MessageCli.PRINT_DB_POLICY_COUNT.printMessage(Integer.toString(Profile.getProfileCount()), "s", ".");
  }

  public void createNewProfile(String userName, String age) {
    // TODO: Complete this method.
    if (isInDatabase(userName)) {
      // profile with username already exists within database
      MessageCli.INVALID_USERNAME_NOT_UNIQUE.printMessage(userName);
    }
    else {
      // unique profile -> create new profile and add to database
      Profile profile = new Profile(userName, Integer.parseInt(age));
      database.add(profile);
    }
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

  public String toTitle(String word) {
    // titles given string -> makes first char upper and rest lowercase
    String upWord = word.toUpperCase();
    String lowWord = word.toLowerCase();
    String titledWord = upWord.substring(0,1) + lowWord.substring(1);
    return titledWord;
  }

  public boolean isInDatabase(String userName) {
    // checks if given username string exists within database
    for (Profile profile : database) {
      if (userName.equals(profile.getUserName())) {
        return true;
      }
    }
    return false;
  }
}
