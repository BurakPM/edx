import java.text.DecimalFormat;

public class BusinessEmployee extends Employee {
    private double bonusBudget;

    public BusinessEmployee(String name) {
        super(name, 50000);
    }

    public double getBonusBudget() {
        DecimalFormat df = new DecimalFormat("###.###");
        return Double.parseDouble(df.format(bonusBudget));
    }

    @Override
    public String employeeStatus() {
        return toString() + " with a budget of " + getBonusBudget();

    }

    public void setBonusBudget(double budget) {
        bonusBudget = budget;
    }

}
