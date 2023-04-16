package nz.ac.auckland.se281;

public class LifePolicy extends Policy {

  private int userAge;

  public LifePolicy(int sumInsured, int age) {
    super(sumInsured);
    userAge = age;
    calculateBasePremium();
  }

  @Override
  public void calculateBasePremium() {
    // calculates, and sets base premium
    setBasePremium(getSumInsured() * (1 + (userAge / 100)));
  }
}
