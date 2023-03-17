package nz.ac.auckland.se281;

public class Profile {

  // instance fields
  private String name;
  private int age;

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
}
