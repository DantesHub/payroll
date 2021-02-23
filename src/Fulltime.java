
/**
 * 
 * 
 * @author Kevin Shin, Christopher Chung
 */
import java.text.DecimalFormat;

public class Fulltime extends Employee {
  private double salary;
  private double payment;
  final private int PAY_PERIODS = 26;

  public Fulltime(Profile profile, Double salary) {
    super(profile);
    this.salary = salary;

  }

  public int getPayPeriods() {
    return this.PAY_PERIODS;
  }

  @Override
  public void calculatePayment() {
    this.payment = this.salary / this.PAY_PERIODS;
  }

  public double getPayment() {
    return this.payment;
  }

  public void setPayment(double newPayment) {
    this.payment = newPayment;
  }

  public double getSalary() {
    return salary;
  }

  @Override
  public String toString() {
    DecimalFormat formatter = new DecimalFormat("#,##0.00");
    return super.toString() + formatter.format(this.payment) + "::FULL TIME::Annual Salary $"
        + formatter.format(this.salary);
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }

    Employee e = (Employee) obj;
    if (super.equals(e)) { // check if profiles match
      return true;
    }

    return false;
  }
}