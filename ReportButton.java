public class ReportButton implements UserInterface {
    private FundManagement fundManager;
    
    // Constructor
    public ReportButton() {
        fundManager = null;
    }
    
    // Menghubungkan dengan FundManagement
    public void connectToFundManager(FundManagement manager) {
        this.fundManager = manager;
    }
    
    @Override
    public void buttonPressed() {
        if (fundManager != null) {
            System.out.println("Report button pressed");
            String report = fundManager.generateReport();
            System.out.println(report);
        } else {
            System.out.println("Cannot generate report: no fund manager connected");
        }
    }
}
