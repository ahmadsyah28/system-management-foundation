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
            
            // Contoh penggunaan recordFunds di ReportButton
            fundManager.recordFunds(0, "ReportButton - Logging report generation");
        } else {
            System.out.println("Cannot generate report: no fund manager connected");
        }
    }
}
