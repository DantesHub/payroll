
/**
 * This Date class encapsulates all necessary resources 
 * for assigning and implementing dates.
 * It provides two ways to creates dates 
 * either by providing a date or defaulting to the current date.
 * It also provides a method in which to check if the inputted date is valid.
 * 
 * @author Kevin Shin, Christopher Chung
 */

import java.util.Calendar;
import java.util.StringTokenizer;

public class Date {
  private int year;
  private int month;
  private int day;

  /**
   * A constructor that converts an input string Date into a Date object.
   * 
   * @param date This is the first parameter to input a date.
   */
  public Date(String date) {
    StringTokenizer dates = new StringTokenizer(date, "/");
    month = Integer.parseInt(dates.nextToken());
    day = Integer.parseInt(dates.nextToken());
    year = Integer.parseInt(dates.nextToken());
  }

  /**
   * This method returns the month of a Date as a string
   *
   * @return returns the month as a String
   */
  public String monthAsString() {
    return Integer.toString(this.month);
  }

  /**
   * This method returns the day of a Date as a string
   *
   * @return returns the day as a String
   */
  public String dayAsString() {
    return Integer.toString(this.day);
  }

  /**
   * This method returns the year of a Date as a string
   *
   * @return returns the year as a String
   */
  public String yearAsString() {
    return Integer.toString(this.year);
  }

  /**
   * The default costructor that creates a Date object from todays date.
   */
  public Date() {
    Calendar today = Calendar.getInstance();
    year = today.get(Calendar.YEAR);
    month = today.get(Calendar.MONTH) + 1;
    day = today.get(Calendar.DATE);
  }

  /**
   * This method checks to see if the input date is within today's date and after
   * 1900.
   * 
   * @param date The input Date object.
   * @return Returns true if the date is valid and false if it is not valid, a
   *         future date, or a date before 1900
   */
  public boolean isValid() {
    final int JANUARY = 1;
    final int FEBRUARY = 2;
    final int APRIL = 4;
    final int JUNE = 6;
    final int SEPTEMBER = 9;
    final int NOVEMBER = 11;
    final int DECEMBER = 12;
    final int MAX_DAY_THIRTY_FIRST = 31;
    final int MAX_DAY_THIRTY = 30;
    final int MAX_DAY_TWENTY_NINE = 29;
    final int MAX_DAY_TWENTY_EIGHT = 28;
    final int MIN_YEAR = 1900;

    Date today = new Date();
    if (this.year < MIN_YEAR || this.year > today.year) {// before 1900 or date is in future
      return false;
    } else if (this.year == today.year) { // date is in future
      if (this.month > today.month) {
        return false;
      } else if (this.month == today.month && this.day >= today.day) {
        return false;
      }
    }
    if (this.month > DECEMBER || this.month < JANUARY) { // Checks if month is valid
      return false;
    }
    if (this.day > MAX_DAY_THIRTY_FIRST) { // Checks if days are over 31
      return false;
    }
    if (this.month == APRIL || this.month == JUNE || this.month == SEPTEMBER || this.month == NOVEMBER) { // Checks for
                                                                                                          // months with
                                                                                                          // 30 days
      if (this.day > MAX_DAY_THIRTY) {
        return false;
      }
    }
    if (this.month == FEBRUARY) {// Checks FEBRUARY for leap year and its max days
      if (this.isLeap()) {
        if (this.day > MAX_DAY_TWENTY_NINE) {
          return false;
        }
      } else {
        if (this.day > MAX_DAY_TWENTY_EIGHT) {
          return false;
        }
      }
    }
    return true;
  }

  /**
   * This method checks to see if a given date is a leap year.
   * 
   * @param date The input Date object
   * @return true or false depending on if it is a leap year or not
   */
  private boolean isLeap() {
    final int QUADRENNIAL = 4;
    final int CENTENNIAL = 100;
    final int QUATER_CENTENNIAL = 400;

    if (this.year % QUADRENNIAL == 0) {
      if (this.year % CENTENNIAL == 0) {
        if (this.year % QUATER_CENTENNIAL == 0) {
          return true;
        }
      } else {
        return true;
      }
    }

    return false;
  }

  /**
   * This method will check if two dates are equal to each other
   *
   * @param date The date that is being compared try
   * @return return 1 if date is after date being compared to, 0 if they're equal
   *         and -1 if date comes before
   */
  // @Override
  public int compareTo(Date date) { // return 1, 0, or -1
    if (this.year == date.year && this.month == date.month && this.day == date.day) {
      return 0;
    } else if (this.year > date.year) {
      return 1;
    } else if (this.year == date.year && this.month > date.month) {
      return 1;
    } else if (this.year == date.year && this.month == date.month && this.day > date.day) {
      return 1;
    } else
      return -1;
  }
}