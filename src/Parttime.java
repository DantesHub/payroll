/**
 * 
 * 
 * @author Kevin Shin, Christopher Chung
 */
public class Parttime extends Employee {
  private double hourlyRate;
  private final int MAXIMUM_HOURS_PER_WEEK = 40;
  private int hoursWorked = 0;
  private double payment;
  private final double payPeriod = 2;
  private final double overTimeRate = 1.5;

  public Parttime(Profile profile, double hourlyRate) {
    super(profile);
    this.hourlyRate = hourlyRate;
  }

  public void setHoursWorked(int hoursWorked) {
    this.hoursWorked = hoursWorked;
  }

  @Override
  public void calculatePayment() {
    double overtime;
    if (this.hoursWorked > MAXIMUM_HOURS_PER_WEEK * payPeriod) { // if worked overtime
      overtime = (hoursWorked - (MAXIMUM_HOURS_PER_WEEK * payPeriod)) * hourlyRate * overTimeRate;
      this.payment = overtime + (hourlyRate * (MAXIMUM_HOURS_PER_WEEK * payPeriod));
    } else {
      this.payment = hourlyRate * hoursWorked;
    }
  }

  @Override
  public String toString() {
    return super.toString() + String.format("%.2f", this.payment) + "::PART TIME::Hourly Rate:: " + this.hourlyRate
        + "::Hours worked this  period: " + this.hoursWorked;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }

    Employee parttime = (Employee) obj;

    if (super.equals(parttime)) { // check if profiles match
      return true;
    }

    return false;
  }
}