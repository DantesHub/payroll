
/**
 * 
 * 
 * @author Kevin Shin, Christopher Chung
 */
import java.util.Scanner;
import java.util.StringTokenizer;

public class PayrollProcessing {
  Scanner scanner = new Scanner(System.in);
  String name = null;
  String department = null;
  Date date = null;
  String dateHired;
  Double hourlyPay;
  Double salary;
  Company company;
  int role;
  Employee temp;

  public void run() {
    System.out.println("Payroll processing starts.");
    company = new Company();
    String input = "start";
    String command = null;

    int fourTokens = 4;
    int fiveTokens = 5;
    int sixTokens = 6;

    while (!input.equals("Q")) {
      input = scanner.nextLine();
      StringTokenizer inputs = new StringTokenizer(input, " ");
      int numTokens = inputs.countTokens();
      command = inputs.nextToken();// takes command from the input
      if (numTokens == fourTokens || numTokens == fiveTokens || numTokens == sixTokens) { // set name, department, and
                                                                                          // date hired // date
        name = inputs.nextToken();
        department = inputs.nextToken();
        dateHired = inputs.nextToken();
        date = new Date(dateHired);

      }

      if (command.equals("AP")) { // add part time worker
        if (date.isValid()) { // First checks if date is valid
          double payRate = Double.parseDouble(inputs.nextToken());
          if (payRate < 0) {
            System.out.println("Pay rate cannot be negative.");
            continue;
          } else {
            Profile profile = new Profile(name, department, date);
            Parttime employee = new Parttime(profile);
            employee.setHourlyRate(payRate);
            if (!departmentIsValid(department)) {
              System.out.println("'" + department + "'" + " is not a valid department code.");
              continue;
            }
            if (company.add(employee)) {
              System.out.println("Employee added.");
            } else {
              System.out.println("Employee is already in the list.");
            }
          }
        } else {
          System.out.println(dateHired + " is not a valid date!");
          continue;
        }

      } else if (command.equals("AF")) { // Add a fulltime employee
        if (!date.isValid()) {
          System.out.println(dateHired + " is not a valid date!");
          continue;
        }
        salary = Double.parseDouble(inputs.nextToken());
        boolean isNegative = salaryIsNegative(salary);
        if (!departmentIsValid(department)) {
          System.out.println("'" + department + "'" + " is not a valid department code.");
          continue;
        }
        if (isNegative) {
          System.out.println("Salary cannot be negative.");
          continue;
        } else {
          Profile profile = new Profile(name, department, date);
          Fulltime employee = new Fulltime(profile, salary);
          if (company.add(employee)) {
            System.out.println("Employee added.");
          } else {
            System.out.println("Employee is already in the list.");
          }
        }
      } else if (command.equals("AM")) { // Add a manager
        if (!date.isValid()) {
          System.out.println(dateHired + " is not a valid date!");
        }
        salary = Double.parseDouble(inputs.nextToken());
        role = Integer.parseInt(inputs.nextToken());
        if (role < 1 || role > 3) {
          System.out.println("Invalid management code.");
          continue;
        }
        boolean isNegative = salaryIsNegative(salary);
        if (!departmentIsValid(department)) {
          System.out.println("'" + department + "'" + " is not a valid department code.");
          continue;
        }
        if (isNegative) {
          System.out.println("Salary cannot be negative.");
          continue;
        } else {
          Profile profile = new Profile(name, department, date);
          Management management = new Management(profile, salary, role);
          if (company.add(management)) {
            System.out.println("Employee added.");
          } else {
            System.out.println("Employee is already in the list.");
          }
        }
      } else if (command.equals("R")) {// Removes an employee from company database
        if (company.isEmpty()) {
          System.out.println("Employee database is empty.");
        }
        Profile profile = new Profile(name, department, date);
        Employee employee = new Employee(profile);
        if (company.remove(employee)) {
          System.out.println("Employee removed.");
        } else { // if empty
          System.out.println("Employee does not exist.");// success
        }
      } else if (command.equals("C")) {// Calculate total payments for all employees
        if (company.isEmpty()) {
          System.out.println("Employee database is empty.");
          continue;
        }
        company.processPayments();
        System.out.println("Calculation of employee payments is done.");
      } else if (command.equals("S")) {// Set the hours for a part time employee
        if (company.isEmpty()) {
          System.out.println("Employee database is empty.");
          continue;
        }
        try {
          int hoursWorked = Integer.parseInt(inputs.nextToken());
          if (hoursWorked > 100) {
            System.out.println("Invalid Hours: over 100.");
          } else if (hoursWorked < 0) {
            System.out.println("Working hours cannot be negative.");
          }

          Profile profile = new Profile(name, department, date);
          Parttime e = new Parttime(profile);
          e.setHoursWorked(hoursWorked);
          if (company.setHours(e)) { // employee exists in list
            System.out.println("Working hours set.");
          } else {
            System.out.println("Employee does not exist.");
          }
        } catch (Exception e) {
          System.out.println("");
        }

      } else if (command.equals("PA")) {// Prints the earning statements for all employees
        if (!company.isEmpty()) {
          System.out.println("--Printing earning statements for all employees--");
        }
        company.print();
      } else if (command.equals("PH")) {// Prints the earning statements for all employees in the order of date hired

        company.printByDate();
      } else if (command.equals("PD")) {// Prints the earning statements for all employees grouped by departments.
        company.printByDepartment();
      } else if (command.equals("Q")) {// Ends session, breaks loop
        company.printByDepartment();
        System.out.println("Payroll Processing completed.");
        return;
      } else {
        System.out.println("Command '" + command + "' not supported!");
      }
    }
  }

  private static boolean isUpperCase(char ch) {
    return ch >= 'A' && ch <= 'Z';
  }

  private boolean departmentIsValid(String department) {
    char[] charArray;
    charArray = department.toCharArray();
    int index = 0;
    for (index = 0; index < charArray.length; index++) {
      if (!isUpperCase(charArray[index])) {
        return false;
      }
    }
    if (!department.equalsIgnoreCase("IT") && !department.equalsIgnoreCase("CS")
        && !department.equalsIgnoreCase("ECE")) {
      return false;
    }
    return true;
  }

  private boolean salaryIsNegative(Double salary) {
    if (salary < 0) {
      return true;
    } else {
      return false;
    }
  }
}
