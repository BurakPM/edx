public class TechnicalEmployee extends Employee {
    // if public, this field needs no getter or setter
    private int checkIns;


    public TechnicalEmployee(String name) {
        super(name, 75000);
    }

    public String employeeStatus() {
        return toString() + " " + checkIns + " successful check ins";
    }

    public void addCheckIn() {
        checkIns++;
    }

    // more proper place for this method than SoftwareEngineer.java
    public int getSuccessfulCheckIns() {
        return checkIns;
    }

}
