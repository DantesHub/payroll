/**
 * 
 * 
 * @author Kevin Shin, Christopher Chung
 */
public class Profile {
  private String name; // employee’s name in the form “lastname,firstname”
  private String department; // department code: CS, ECE, IT
  private Date dateHired;

  public Profile(String name, String department, Date dateHired) {
    this.name = name;
    this.department = department;
    this.dateHired = dateHired;
  }

  @Override
  public String toString() {
    String profile = name + "::" + department + "::" + dateHired.monthAsString() + "/" + dateHired.dayAsString() + "/"
        + dateHired.yearAsString() + "::";
    return profile;
  }

  @Override
  public boolean equals(Object obj) {// compare name, department and dateHired
    if (obj == this) {
      return true;
    }
    if (!(obj instanceof Profile)) {
      return false;
    }
    Profile p = (Profile) obj;
    if (this.name.equals(p.getName()) && (this.department.equals(p.getDepartment()))
        && (this.dateHired.compareTo(p.getDateHired())) == 0) {
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

  public void setName(String name) {
    this.name = name;
  }

  public void setDepartment(String department) {
    this.department = department;
  }

  public void setDateHired(Date date) {
    this.dateHired = date;
  }

}