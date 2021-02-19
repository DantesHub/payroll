/**
 * 
 * 
 * @author Kevin Shin, Christopher Chung
 */
public class Company {
  private Employee[] emplist;
  private int numEmployee;

  private int find(Employee employee) {
    int didNotFind = -1;
    for (int idx = 0; idx < emplist.length; idx++) {
      if (emplist[idx].equals(employee)) {
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
    boolean isProfileValid = checkProfile(employee);
    if (isProfileValid) {
      return false;
    } else {
      int isInList = find(employee);
      if (isInList != -1) {
        System.out.println("Employee is already in the list.");
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
  }

  private boolean checkProfile(Employee employee) { //check if employee profile is valid 
      return true
      return false 
    }

  public boolean remove(Employee employee) {
    if(isEmpty()) {
      return false; 
    } else {
      int idx = find(employee));
      if(idx  == - 1) {
        return false;
      }
      this.emplist[idx] = null;
      this.numEmployee--; 
      for(int i =idx; i<emplist.length - 1; i++) {
        this.emplist[i] = this.emplist[i+1];
      }
      return true;
    }
  } // maintain the original sequence

  public boolean setHours(Employee employee) {
  } // set working hours for a part time

  private boolean isEmpty() {
    System.out.println("Employee database is empty.");
    return this.numEmployee == 0;
  }

  public void processPayments() {
  } // process payments for all employees

  public void print() {
  } // print earning statements for all employees

  public void printByDepartment() {
  } // print earning statements by department

  public void printByDate() {
  } // print earning statements by date hired

  private void compareEmployeeDepartments() {

  }

  private void sortByDate() {
    Employee temp;
    for (int i = 0; i < this.numEmployee - 1; i++) {
      for (int j = 0; j < this.numEmployee - i - 1; j++) {
        if (emplist[j].getDateHired().compareDates(emplist[j + 1].getDateHired())) { // checks if the first book date is
                                                                                     // less than the second
          if (emplist[j].getDateHired().compareTo(emplist[j + 1].getDateHired())== 0)) { // checks for equal dates
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
}
