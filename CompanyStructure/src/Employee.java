public abstract class Employee {

    private String name;
    private double baseSalary;
    private static int counter = 1;
    private int employeeID;
    private Employee manager;


    public Employee(String name, double baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
        employeeID = counter++;
    }

    public String getName() {
        return name;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public Employee getManager() {
        return manager;
    }

    public boolean equals(Employee other) {
        return this.employeeID == other.employeeID;
    }

    @Override
    public String toString() {
        return getEmployeeID() + " " + getName();
    }

    public abstract String employeeStatus();

    public void setManager(Employee manager) {
        this.manager = manager;
    }
}
