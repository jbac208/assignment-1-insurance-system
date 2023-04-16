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
        // do prints
        MessageCli.PRINT_DB_POLICY_COUNT.printMessage(Integer.toString(profileCount), "", ":");
        dbHas1Profile();
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

  public void dbHas1Profile() {
    // get profile policies arrayList
    ArrayList<Policy> policies = database.get(0).getPolicies();
    if (database.get(0).equals(loadedProfile)) {
      MessageCli.PRINT_DB_PROFILE_HEADER_LONG.printMessage(
          "*** ",
          "1",
          loadedProfile.getUserName(),
          Integer.toString(loadedProfile.getAge()),
          Integer.toString(policies.size()),
          "y",
          "100");
    } else {
      MessageCli.PRINT_DB_PROFILE_HEADER_MINIMAL.printMessage(
          "1", database.get(0).getUserName(), Integer.toString(database.get(0).getAge()));
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
    userName = toTitle(userName);
    if (isInDatabase(userName)) {
      Profile profileToDelete = database.get(dbIndexOfUser(userName));
      // check if not null first otherwise when checking equality -> causes error
      if (loadedProfile != null && loadedProfile.equals(profileToDelete)) {
        // cannot delete currently loaded profile
        MessageCli.CANNOT_DELETE_PROFILE_WHILE_LOADED.printMessage(userName);
      } else {
        // delete profile if not equal to currently loaded profile
        MessageCli.PROFILE_DELETED.printMessage(userName);
        database.remove(profileToDelete);
      }
    } else {
      // not in database
      MessageCli.NO_PROFILE_FOUND_TO_DELETE.printMessage(userName);
    }
  }

  public void createPolicy(PolicyType type, String[] options) {
    if (loadedProfile == null) {
      // if no loaded, print error msg
      MessageCli.NO_PROFILE_FOUND_TO_CREATE_POLICY.printMessage();
    } else {
      String userName = loadedProfile.getUserName();
      int sumInsured = Integer.parseInt(options[0]);
      // create according policy and add to profile
      switch (type) {
        case HOME:
          Boolean rent;
          if (options[2].equals("yes")) {
            rent = true;
          } else {
            rent = false;
          }
          HomePolicy policy = new HomePolicy(sumInsured, options[1], rent);
          MessageCli.NEW_POLICY_CREATED.printMessage("home", userName);
          loadedProfile.addPolicy(policy);
          break;

        case CAR:
          MessageCli.NEW_POLICY_CREATED.printMessage("car", userName);
          break;

        case LIFE:
          MessageCli.NEW_POLICY_CREATED.printMessage("life", userName);
          break;
      }
    }
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

  public int dbIndexOfUser(String userName) {
    int i = 0; // iterator variable
    for (Profile profile : database) {
      if (userName.equals(profile.getUserName())) {
        // return index of profile
        return i;
      }
      i++;
    }
    // userName not in database
    return -1;
  }
}
