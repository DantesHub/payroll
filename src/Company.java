/**
 * 
 * 
 * @author Kevin Shin, Christopher Chung
 */
public class Company {
  private Employee[] emplist;
  private int numEmployee;

  public Company() {
    this.emplist = new Employee[4];
    this.numEmployee = 0;
  }

  private int find(Employee employee) {
    int didNotFind = -1;
    for (int idx = 0; idx < numEmployee; idx++) {
      if (this.emplist[idx].equals(employee)) {
        return idx;
      }
    }
    return didNotFind;
  }

  private void grow() {
    Employee[] newArray = new Employee[emplist.length + 4];
    System.arraycopy(emplist, 0, newArray, 0, emplist.length);
    this.emplist = newArray;
  }

  public boolean add(Employee employee) { // check the profile before adding
    // check if employee is in the list

    int isInList = find(employee);
    if (isInList != -1) {
      return false;
    } else { // add employee
      if (emplist.length % 4 == 0) { // array is full grow
        grow();
      }
      this.emplist[this.numEmployee] = employee;
      this.numEmployee++;
      return true;
    }
  }

  public boolean remove(Employee employee) {
    if (isEmpty()) {
      return false;
    } else {
      int idx = find(employee);
      if (idx == -1) {
        return false;
      }
      this.emplist[idx] = null;
      this.numEmployee--;
      for (int i = idx; i < emplist.length - 1; i++) {
        this.emplist[i] = this.emplist[i + 1];
      }
      return true;
    }
  } // maintain the original sequence

  // how are we suppose to set hours without being able to pass in hours as param?
  // we cant set hours using employee profile because we cannot create
  // more instance variables in the profile class
  public boolean setHours(Employee employee) {
    int index = find(employee);
    if (index == -1) {
      return false;
    }
    if (this.emplist[index] instanceof Parttime) { // replace old parttime with new one with hours worked
      Parttime parttime = (Parttime) employee;
      Parttime temp = (Parttime) this.emplist[index];
      parttime.setHourlyRate(temp.getHourlyRate()); // get and set hourly rate
      this.emplist[index] = parttime;
      return true;
    }
    return false;
  } // set working hours for a part time

  public boolean isEmpty() {
    return this.numEmployee == 0;
  }

  public void processPayments() {
    for (int idx = 0; idx < numEmployee; idx++) {
      Employee emp = emplist[idx];
      if (emp instanceof Management) {
        emp = (Management) emp;
      } else if (emp instanceof Parttime) {
        emp = (Parttime) emp;
      } else {
        emp = (Fulltime) emp;
      }
      emp.calculatePayment();
    }

  } // process payments for all employees
    // if (emp instanceof Management) {
    // Management management = (Management) emp;
    // management.calculatePayment();
    // } else if (emp instanceof Parttime) {
    // Parttime parttime = (Parttime) emp;
    // parttime.calculatePayment();
    // } else {
    // Fulltime fulltime = (Fulltime) emp;
    // fulltime.calculatePayment();
    // }

  public void print() {// print earning statements for all employees
    if (this.isEmpty()) {
      System.out.println("Employee database is empty.");
      return;
    }
    for (int i = 0; i < this.numEmployee; i++) {
      System.out.println(this.emplist[i].toString());
    }
  }

  public void printByDepartment() {
    if (!isEmpty()) {
      System.out.println("--Printing earning statements by department--");
    }
    this.sortByDepartment();
    this.print();
  } // print earning statements by department

  public void printByDate() {
    if (!isEmpty()) {
      System.out.println("--Printing earning statements by date hired--");
    }
    this.sortByDate();
    this.print();
  } // print earning statements by date hired

  private void sortByDate() {
    Employee temp;
    for (int i = 0; i < this.numEmployee - 1; i++) {
      for (int j = 0; j < this.numEmployee - i - 1; j++) {
        if ((emplist[j].getDateHired()).compareTo(emplist[j + 1].getDateHired()) > 0) { // checks if the first employee
                                                                                        // date is
          // less than the second
          if ((emplist[j].getDateHired()).compareTo(emplist[j + 1].getDateHired()) == 0) { // checks for equal dates
            if (emplist[j].compareEmployeeDepartments(emplist[j + 1])) {
              continue;
            }
          }
          temp = this.emplist[j];
          this.emplist[j] = this.emplist[j + 1];
          this.emplist[j + 1] = temp;
        }
      }
    }
  }

  private void sortByDepartment() {
    Employee temp;
    for (int i = 0; i < this.numEmployee; i++) {
      for (int j = i + 1; j < this.numEmployee; j++) {
        if (emplist[i].profile.getDepartment().compareTo(emplist[j].profile.getDepartment()) == 0) {
          if (emplist[i].profile.getName().compareTo(emplist[j].profile.getName()) > 0) {
            temp = this.emplist[j];
            System.out.println("00000" + temp + "temp");
            this.emplist[j] = this.emplist[i];
            this.emplist[i] = temp;
            continue;
          }
        } else if (emplist[i].profile.getDepartment().compareTo(emplist[j].profile.getDepartment()) > 0) { // first >
                                                                                                           // second
          temp = this.emplist[j];
          this.emplist[j] = this.emplist[i];
          this.emplist[i] = temp;
          continue;
        }
      }
    }
  }
}
