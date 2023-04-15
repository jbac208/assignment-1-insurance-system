package nz.ac.auckland.se281;

import java.util.ArrayList;
import nz.ac.auckland.se281.Main.PolicyType;

public class InsuranceSystem {

  private ArrayList<Profile> database = new ArrayList<>(); // arraylist of profiles for database
  private Profile loadedProfile; // profile currently loaded

  public InsuranceSystem() {
    // Only this constructor can be used (if you need to initialise fields).

  }

  public void printDatabase() {
    // Pretty prints database
    int profileCount = database.size(); // get profile count
    switch (profileCount) {
      case 0:
        MessageCli.PRINT_DB_POLICY_COUNT.printMessage(Integer.toString(profileCount), "s", ".");
        break;

      case 1:
        MessageCli.PRINT_DB_POLICY_COUNT.printMessage(Integer.toString(profileCount), "", ":");
        if (database.get(0).equals(loadedProfile)) {
          MessageCli.PRINT_DB_PROFILE_HEADER_SHORT.printMessage(
              "*** ",
              "1",
              database.get(0).getUserName(),
              Integer.toString(database.get(0).getAge()));
        } else {
          MessageCli.PRINT_DB_PROFILE_HEADER_MINIMAL.printMessage(
              "1", database.get(0).getUserName(), Integer.toString(database.get(0).getAge()));
        }
        break;

      default:
        MessageCli.PRINT_DB_POLICY_COUNT.printMessage(Integer.toString(profileCount), "s", ":");
        for (int i = 0; i < profileCount; i++) {
          Profile profile = database.get(i);
          if (profile.equals(loadedProfile)) {
            MessageCli.PRINT_DB_PROFILE_HEADER_SHORT.printMessage(
                "*** ",
                Integer.toString(i + 1),
                profile.getUserName(),
                Integer.toString(profile.getAge()));
          } else {
            MessageCli.PRINT_DB_PROFILE_HEADER_MINIMAL.printMessage(
                Integer.toString(i + 1), profile.getUserName(), Integer.toString(profile.getAge()));
          }
        }
    }
  }

  public void createNewProfile(String userName, String age) {
    // only create profile if there is no current loadedProfile
    if (loadedProfile == null) {
      // creating new instance of profile and add to database
      userName = toTitle(userName); // titlefy userName
      if (isProfileArgsValid(userName, age)) {
        // create new profile and add to database
        int ageInt = Integer.parseInt(age); // save age as type int
        Profile profile = new Profile(userName, ageInt);
        database.add(profile);
        MessageCli.PROFILE_CREATED.printMessage(userName, age);
      }
    } else {
      MessageCli.CANNOT_CREATE_WHILE_LOADED.printMessage(loadedProfile.getUserName());
    }
  }

  public void loadProfile(String userName) {
    // if profile exists, then load
    userName = toTitle(userName);
    if (isInDatabase(userName)) {
      // load profile from database
      for (Profile profile : database) {
        if (userName.equals(profile.getUserName())) {
          loadedProfile = profile;
          MessageCli.PROFILE_LOADED.printMessage(userName);
          return;
        }
      }
    } else {
      // profile not in database
      MessageCli.NO_PROFILE_FOUND_TO_LOAD.printMessage(userName);
    }
  }

  public void unloadProfile() {
    if (loadedProfile != null) {
      // unload profile
      MessageCli.PROFILE_UNLOADED.printMessage(loadedProfile.getUserName());
      loadedProfile = null;
    } else {
      // no current loaded profile
      MessageCli.NO_PROFILE_LOADED.printMessage();
    }
  }

  public void deleteProfile(String userName) {
    // TODO: Complete this method.
  }

  public void createPolicy(PolicyType type, String[] options) {
    // TODO: Complete this method.
  }

  public boolean isProfileArgsValid(String userName, String age) {
    // Checks if given arguments for creating profile is valid and prints according
    // error messages
    try {
      int ageInt = Integer.parseInt(age); // save age as type int
      if (userName.length() < 3) { // checking name atleast 3 chars
        MessageCli.INVALID_USERNAME_TOO_SHORT.printMessage(userName);
      } else if (ageInt < 0) { // make sure age is positive
        MessageCli.INVALID_AGE.printMessage(age, userName);
      } else if (isInDatabase(userName)) { // check if name already in database
        // profile with username already exists within database
        MessageCli.INVALID_USERNAME_NOT_UNIQUE.printMessage(userName);
      } else {
        // valid args so return true
        return true;
      }
    } catch (NumberFormatException exception) {
      MessageCli.INVALID_AGE.printMessage(age, userName);
    }
    return false;
  }

  public String toTitle(String word) {
    // titles given string meaning, makes first char upper and rest lowercase
    String upWord = word.toUpperCase();
    String lowWord = word.toLowerCase();
    String titledWord = upWord.substring(0, 1) + lowWord.substring(1);
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
