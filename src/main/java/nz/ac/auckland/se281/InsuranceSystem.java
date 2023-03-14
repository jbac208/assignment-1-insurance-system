package nz.ac.auckland.se281;

import java.util.ArrayList;

import javax.swing.text.AbstractDocument.BranchElement;

import nz.ac.auckland.se281.Main.PolicyType;

public class InsuranceSystem {
  
  // init arraylist of profiles for database
  private ArrayList<Profile> database = new ArrayList<>();

  public InsuranceSystem() {
    // Only this constructor can be used (if you need to initialise fields).

  }

  public void printDatabase() {
    // TODO: Complete this method.
    int nProfileCount = database.size();
    switch (nProfileCount) {
      case 0:
        MessageCli.PRINT_DB_POLICY_COUNT.printMessage(Integer.toString(nProfileCount), "s", ".");

        break;

      case 1:
        MessageCli.PRINT_DB_POLICY_COUNT.printMessage(Integer.toString(nProfileCount), "", ":");
        break;
      
      default:
        MessageCli.PRINT_DB_POLICY_COUNT.printMessage(Integer.toString(nProfileCount), "s", ":");
    }
  }

  public void createNewProfile(String userName, String age) {
    // TODO: Complete this method.
    userName = toTitle(userName);   // titlefy userName
    int nAge = Integer.parseInt(age);   // save age as type int
    if (isProfileArgsValid(userName, age)) {
      // create new profile and add to database
      Profile profile = new Profile(userName, nAge);
      database.add(profile);
      MessageCli.PROFILE_CREATED.printMessage(userName, age);
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

  public boolean isProfileArgsValid(String userName, String age) {
    // Checks if given arguments for creating profile is valid and prints according error messages
    int nAge = Integer.parseInt(age);   // save age as type int
    if (userName.length() < 3) {    // checking name atleast 3 chars
      MessageCli.INVALID_USERNAME_TOO_SHORT.printMessage(userName);
    } else if (nAge < 0) {   // make sure age is positive **whole number not sure if need whole number yet
      MessageCli.INVALID_AGE.printMessage(age, userName);
    } else if (isInDatabase(userName)) {    // check if name already in database
      // profile with username already exists within database
      MessageCli.INVALID_USERNAME_NOT_UNIQUE.printMessage(userName);
    } else {
      // valid args so return true
      return true;
    }
    return false;
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
