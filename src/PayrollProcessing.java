
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
  float hourlyPay;
  float salary;

  public void run() {
    String input = "start";
    int employeeID = 10000; // start of serial numbers
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

      if (command.equals("AP")) {
        if (date.isValid()) { // First checks if date is valid
          System.out.println("Pay rate cannot be negative.");
          System.out.println("Employee added.");
        } else {
          System.out.println(dateHired + "is not a valid date!");
          continue;
        }
      } else if (command.equals("AF")) { // Add a fulltime employee
        salary = Float.parseFloat(inputs.nextToken());
        boolean isNegative = salaryIsNegative(salary);
        if (isNegative) {
          System.out.println("Salary cannot be negative.");
        } else {

        }
        System.out.println("Employee added.");
      } else if (command.equals("AM")) { // Add a manager
        salary = Float.parseFloat(inputs.nextToken());
        boolean isNegative = salaryIsNegative(salary);
        if (isNegative) {
          System.out.println("Salary cannot be negative.");
        } else {
          System.out.println("Employee added.");
        }
      } else if (command.equals("R")) {// Removes an employee from company database
        System.out.println("Employee removed."); // success
        // if empty
        System.out.println("Employee Database is empty.");
      } else if (command.equals("C")) {// Calculate total payments for all employees

      } else if (command.equals("S")) {// Set the hours for a part time employee
        System.out.println("Working hours cannot be negative.");
        System.out.println("Working hours set.");
      } else if (command.equals("PA")) {// Prints the earning statements for all employees
        System.out.println("--Printing earning statements for all employees--");
      } else if (command.equals("PH")) {// Prints the earning statements for all employees in the order of date hired
        System.out.println("--Printing earning statements by date hired--");
      } else if (command.equals("PD")) {// Prints the earning statements for all employees grouped by departments.
        System.out.println("--Printing earning statements by department--");
      } else if (command.equals("Q")) {// Ends session, breaks loop
        System.out.println("Payroll Processing completed.");
        break;

      } else {
        System.out.println("Command " + command + "not supported!");
      }
    }
  }

  private boolean salaryIsNegative(float salary) {
    if (salary < 0) {
      return true;
    } else {
      return false;
    }
  }
}