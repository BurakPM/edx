import java.util.ArrayList;
import java.util.List;

public class BusinessLead extends BusinessEmployee implements Manager {
    private List<Accountant> directReports;
    private static final int headCount = 10;

    public BusinessLead(String name) {
        super(name);
        this.setBaseSalary(super.getBaseSalary() * 2);
        directReports = new ArrayList<Accountant>();
    }


    @Override
    public boolean hasHeadCount() {
        return directReports.size() < headCount;
    }


    public boolean addReport(Accountant e, TechnicalLead supportTeam) {
        if (hasHeadCount() && e != null) {
            directReports.add((e));
            e.setManager(this);
            this.setBonusBudget(this.getBonusBudget() + (e.getBaseSalary() * 1.1));
            e.supportTeam(supportTeam);
            supportTeam.setAccountant(e);
            return true;
        } else {
            return false;
        }
    }
    /*
    0 + 55.000

     */

    @Override
    public boolean requestBonus(Employee e, double bonus) {
        if (bonus > getBonusBudget()) {
            e.setBaseSalary(e.getBaseSalary() + bonus);
            setBonusBudget(getBonusBudget() - bonus);
            return true;
        } else {
            return false;
        }
    }


    public boolean approveBonus(Employee e, double bonus) {
        for (Accountant report : directReports) {
            if (report.getTeamSupported().equals(e.getManager())) {
                if (report.approveBonus(bonus)) {
                    e.setBaseSalary(e.getBaseSalary() + bonus);
                    return true;
                }

            }
        }
        return false;


    }

    @Override
    public String getTeamStatus() {
        if (directReports.size() == 0) {
            return this.employeeStatus() + " and no direct reports yet.";
        } else {
            StringBuilder sb = new StringBuilder();

            for (Accountant report : directReports) {
                sb.append("\n" + report.employeeStatus());
            }
            return this.employeeStatus() + " and is managing: " + sb;
        }
    }


}
