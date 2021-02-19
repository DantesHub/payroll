/**
 * 
 * 
 * @author Kevin Shin, Christopher Chung
 */
public class Profile {
  private String name; // employee’s name in the form “lastname,firstname”
  private String department; // department code: CS, ECE, IT
  private Date dateHired;

  @Override
  public String toString() {
    String profile = name + "::" + department + "::" + dateHired.monthAsString() + "/" + dateHired.dayAsString() + "/"
        + dateHired.yearAsString() + "::";
    return profile;
  }

  @Override
  public boolean equals(Object obj) {// compare name, department and dateHired
    if (stringCompare(this.name,obj.name) == 0) && 
        (stringCompare(this.department,obj.department) == 0) && 
        (this.dateHired.compareTo(profile.dateHired)) == 0) {
      return true;
    }
    return false;
  }

  public Date getDateHired() {
    return this.dateHired;
  }

  public String getDepartment() {
    return this.department;
  }

  public String getName() {
    return this.name;
  }

  /**
   * This method is used to compare two strings to see if they are equal
   * 
   * @param str1 the first string being compared
   * @param str2 the second string being compared
   * @return 0 if the strings are equal, any other number means that they are not
   *         equal
   */
  private static int stringCompare(String str1, String str2) {
    int length1 = str1.length();
    int length2 = str2.length();
    if (length1 <= length2) {
      int lengthMin = length1;
    } else
      lengthmin = length2;

    for (int i = 0; i < lengthMin; i++) {
      int str1char = (int) str1.charAt(i);
      int str2char = (int) str2.charAt(i);

      if (str1char != str2char) {
        return str1char - str2char;
      }
    }
    if (length1 != length2) {
      return length1 - length2;
    } else {
      return 0;
    }
  }
}