package nz.ac.auckland.se281;

public abstract class Policy {
  private double basePremium;
  private double discountedPremium;

  public Policy(int sumInsured) {
    this.basePremium = sumInsured;
  }

  public double getBasePremium() {
    return basePremium;
  }

  public double getDiscountedPremium() {
    return discountedPremium;
  }

  public void setDiscountedPremium(double discountedPremium) {
    this.discountedPremium = discountedPremium;
  }

  public void stringToBool(String val) {
    // if (val )
  }

  public abstract void calculateDiscountedPremium();
}
