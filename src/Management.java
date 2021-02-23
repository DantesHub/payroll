
/**
 * 
 * 
 * @author Kevin Shin, Christopher Chung
 */
import java.text.DecimalFormat;

public class Management extends Fulltime {
  final double MANAGER_EXTRA_COMPENSATION = 5000;
  final double DEPARTMENT_HEAD_EXTRA_COMPENSATION = 9500;
  final double DIRECTOR_EXTRA_COMPENSATION = 12000;
  private double managerCompensation;
  private int role;

  public Management(Profile profile, Double salary, int role) {
    super(profile, salary);
    this.role = role;
    calculateExtraPay();
  }

  private void calculateExtraPay() {
    if (role == 1) {
      this.managerCompensation = MANAGER_EXTRA_COMPENSATION / this.getPayPeriods();
    } else if (role == 2) {
      this.managerCompensation = DEPARTMENT_HEAD_EXTRA_COMPENSATION / this.getPayPeriods();
    } else {
      this.managerCompensation = DIRECTOR_EXTRA_COMPENSATION / this.getPayPeriods();
    }
  }

  @Override
  public void calculatePayment() {
    super.calculatePayment();
    this.setPayment(this.getPayment() + managerCompensation);
  }

  @Override
  public String toString() {
    String roleName;
    if (role == 1) {
      roleName = "Manager";
    } else if (role == 2) {
      roleName = "DepartmentHead";
    } else {
      roleName = "Director";
    }
    DecimalFormat formatter = new DecimalFormat("#,##0.00");
    return super.toString() + "::" + roleName + " Compensation $" + formatter.format(this.managerCompensation);
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }

    Employee management = (Employee) obj;
    if (super.equals(management)) { // make sure both objects have same profile and salary
      return true;
    }
    return false;
  }
}