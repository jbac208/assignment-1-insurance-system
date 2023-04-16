package nz.ac.auckland.se281;

public abstract class Policy {
  private int sumInsured;
  private double basePremium;
  private double discountedPremium;

  public Policy(int sumInsured) {
    this.sumInsured = sumInsured;
  }

  public int getSumInsured() {
    return sumInsured;
  }

  public double getBasePremium() {
    return basePremium;
  }

  public double getDiscountedPremium() {
    return discountedPremium;
  }

  public void setBasePremium(double basePremium) {
    this.basePremium = basePremium;
  }

  public void stringToBool(String val) {
    // if (val )
  }

  public abstract void calculateBasePremium();
}
