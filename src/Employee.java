/**
 * 
 * 
 * @author Kevin Shin, Christopher Chung
 */
public class Employee {
  Profile profile;

  public Employee(Profile profile) {
    this.profile = profile;
  }

  @Override
  public String toString() {
    return this.profile.toString() + "Payment $";
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }

    Employee e = (Employee) obj;
    if (this.profile.equals(e.profile)) {
      return true;
    }
    return false;
  }

  void calculatePayment() {

  }

  public boolean compareEmployeeDepartments(Employee employee) {
    return this.profile.getDepartment().compareTo(employee.profile.getDepartment()) < 0;
  }

  public Date getDateHired() {
    return this.profile.getDateHired();
  }

}