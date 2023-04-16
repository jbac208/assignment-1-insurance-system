package nz.ac.auckland.se281;

public abstract class Policy {
  private int sumInsured;
  private double basePremium;

  public Policy(int sumInsured) {
    this.sumInsured = sumInsured;
  }

  public int getSumInsured() {
    return sumInsured;
  }

  public double getBasePremium() {
    return basePremium;
  }

  public void setSumInsured(int sumInsured) {
    this.sumInsured = sumInsured;
  }

  public void setBasePremium(double basePremium) {
    this.basePremium = basePremium;
  }

  public abstract void calculatePremium();
}
