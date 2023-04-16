package nz.ac.auckland.se281;

public class HomePolicy extends Policy {

  private String address;
  private boolean rental;

  public HomePolicy(int sumInsured, String address, boolean rental) {
    super(sumInsured);
    this.address = address;
    this.rental = rental;
    calculateDiscountedPremium();
  }

  public String getAddress() {
    return address;
  }

  @Override
  public void calculateDiscountedPremium() {
    if (rental) {
      setDiscountedPremium(getBasePremium() * (1 - 0.02));
    } else {
      setDiscountedPremium(getBasePremium() * (1 - 0.01));
    }
  }
}
