package nz.ac.auckland.se281;

public class Profile {
    
    // instance fields
    private String name;
    private int age;

    // static fields
    private static int nProfiles = 0;

    public Profile(String name, int age) {
        // constructor
        this.name = name;
        this.age = age;

        System.out.println(nProfiles);
        // add to profiles count
        nProfiles++;
        System.out.println(nProfiles);
    }

    public int getProfileCount() {
        // returns number of profiles
        return nProfiles;
    }
}
