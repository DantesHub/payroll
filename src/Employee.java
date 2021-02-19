/**
 * 
 * 
 * @author Kevin Shin, Christopher Chung
 */
public class Employee {
  Profile profile;

  @Override
  public void calculatePayment() {
  }

  @Override
  public String toString() {
    return profile.toString() + "Payment " + calculatePayment();
    ;
  }

  @Override
  public boolean equals() {

  }

  public boolean compareEmployeeDepartments(Employee employee) {
    return this.profile.getDepartment().compareTo(employee.profile.getDepartment()) < 0;
  }

  public Date getDateHired() {
    return this.profile.getDateHired();
  }
}