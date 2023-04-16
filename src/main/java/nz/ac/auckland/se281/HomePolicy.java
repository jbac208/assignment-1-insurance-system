package nz.ac.auckland.se281;

public class HomePolicy extends Policy {

  private String address;
  private boolean rental;

  public HomePolicy(int sumInsured, String address, boolean rental) {
    super(sumInsured);
    this.address = address;
    this.rental = rental;
  }

  public String getAddress() {
    return address;
  }

  @Override
  public void calculatePremium() {
    if (rental) {
      setBasePremium(getBasePremium() * 0.02);
    } else {
      setBasePremium(getBasePremium() * 0.01);
    }
  }
}
