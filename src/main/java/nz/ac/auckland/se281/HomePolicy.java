package nz.ac.auckland.se281;

public class HomePolicy extends Policy {

  // home policy fields
  private String address;
  private boolean rental;

  public HomePolicy(int sumInsured, String address, boolean rental) {
    super(sumInsured);
    this.address = address;
    this.rental = rental;
    calculateBasePremium();
  }

  public String getAddress() {
    return address;
  }

  @Override
  public void calculateBasePremium() {
    // calculates, and sets base premium
    if (rental) {
      setBasePremium(getSumInsured() * (1 - 0.02));
    } else {
      setBasePremium(getSumInsured() * (1 - 0.01));
    }
  }
}
