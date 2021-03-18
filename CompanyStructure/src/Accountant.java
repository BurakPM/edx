

public class Accountant extends BusinessEmployee {
    private String[] team;
    private TechnicalLead lead;
    private int remainingBudget;

    public Accountant(String name) {
        super(name);
        setBonusBudget(0);
    }

    public TechnicalLead getTeamSupported() {
        return lead;
    }

    public void supportTeam(TechnicalLead lead) {
        this.lead = lead;
        double salarySum = lead.getDirectReports() * 75000;
        setBonusBudget(salarySum + (salarySum / 10));
    }

    public boolean approveBonus(double bonus) {
        if (team == null) {
            return false;
        }

        return !(bonus > remainingBudget);
    }

    public String employeeStatus() {
        return super.employeeStatus() + " is supporting " + lead;
    }

}
