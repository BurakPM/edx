import javax.print.attribute.standard.MediaSize;
import java.util.ArrayList;
import java.util.List;

public class TechnicalLead extends TechnicalEmployee implements Manager {
    private List<SoftwareEngineer> directReports;
    private static final int headCount = 4;
    private Accountant accountant;

    public TechnicalLead(String name) {
        super(name);
        this.setBaseSalary(super.getBaseSalary() * 1.3); // base of Tech. Employee
        directReports = new ArrayList<SoftwareEngineer>();
    }

    public int getDirectReports() {
        return directReports.size();
    }


    @Override
    public boolean hasHeadCount() {
        return directReports.size() < 4;
    }

    public void setAccountant(Accountant accountant) {
        this.accountant = accountant;
    }

    @Override
    public boolean requestBonus(Employee e, double bonus) {
        if (((BusinessLead) accountant.getManager()).approveBonus(e, bonus)) {
            e.setBaseSalary(e.getBaseSalary() + bonus);
            return true;
        }
        return false;
    }





    public boolean addReport(SoftwareEngineer e) {
        if (hasHeadCount() && e != null) {
            directReports.add((e));
            e.setManager(this);
            return true;
        } else {
            return false;
        }
    }

    public boolean approveCheckIn(SoftwareEngineer e) {
        return (this.equals(e.getManager()) && e.getCodeAccess());
    }


    @Override
    public String getTeamStatus() {
        if (directReports.size() == 0) {
            return this.employeeStatus() + " and no direct reports yet.";
        } else {
            StringBuilder sb = new StringBuilder();

            for (SoftwareEngineer report : directReports) {
                sb.append("\n" + report.employeeStatus());
            }
            return this.employeeStatus() + " and is managing: " + sb;
        }
    }


}
