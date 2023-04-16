package nz.ac.auckland.se281;

public class CarPolicy extends Policy {

  private String makeAndModel;
  private String licensePlate;
  private Boolean breakdownCoverage;
  private int profileAge;

  public CarPolicy(
      int sumInsured,
      String makeAndModel,
      String licensePlate,
      Boolean breakdownCoverage,
      int age) {
    super(sumInsured);
    this.makeAndModel = makeAndModel;
    this.licensePlate = licensePlate;
    this.breakdownCoverage = breakdownCoverage;
    this.profileAge = age;
  }

  public String getMakeAndModel() {
    return makeAndModel;
  }

  @Override
  public void calculateBasePremium() {
    // calculates, and sets base premium
    if (profileAge < 25) {
      setBasePremium(getSumInsured() * 0.15);
    } else {
      setBasePremium(getSumInsured() * 0.1);
    }
    if (breakdownCoverage) {
      setBasePremium(getBasePremium() + 80);
    }
  }
}
