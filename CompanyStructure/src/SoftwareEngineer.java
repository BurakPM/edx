public class SoftwareEngineer extends TechnicalEmployee {
    private boolean hasCodeAccess;


    public SoftwareEngineer(String name) {
        super(name);
        setCodeAccess(false);
    }

    public boolean getCodeAccess() {
        return hasCodeAccess;
    }

    public void setCodeAccess(boolean access) {
        hasCodeAccess = access;
    }


    public boolean checkInCode() {
        if (((TechnicalLead) this.getManager()).approveCheckIn(this)) {
            this.addCheckIn();
            return true;
        } else {
            hasCodeAccess = false;
            return false;
        }
    }


}
