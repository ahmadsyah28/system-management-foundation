public class FundManager implements FundManagement, NotificationProvider {
    private double totalFunds;
    private double allocatedFunds;
    private java.util.List<Transaction> transactions;
    
    // Constructor
    public FundManager() {
        totalFunds = 0;
        allocatedFunds = 0;
        transactions = new java.util.ArrayList<>();
    }
    
    @Override
    public void recordFunds(double amount, String source) {
        totalFunds += amount;
        transactions.add(new Transaction(amount, source, "IN"));
        System.out.println("Funds recorded: " + amount + " from " + source);
    }
    
    public void allocateFunds(double amount, String purpose) {
        if (amount <= (totalFunds - allocatedFunds)) {
            allocatedFunds += amount;
            transactions.add(new Transaction(amount, purpose, "OUT"));
            System.out.println("Funds allocated: " + amount + " for " + purpose);
        } else {
            System.out.println("Insufficient funds for allocation");
        }
    }
    
    @Override
    public String generateReport() {
        StringBuilder report = new StringBuilder();
        report.append("=== FUND REPORT ===\n");
        report.append("Total Funds: ").append(totalFunds).append("\n");
        report.append("Allocated Funds: ").append(allocatedFunds).append("\n");
        report.append("Available Funds: ").append(totalFunds - allocatedFunds).append("\n");
        report.append("Transactions:\n");
        
        for (Transaction t : transactions) {
            report.append("- ").append(t.toString()).append("\n");
        }
        
        return report.toString();
    }
    
    @Override
    public void sendNotification(String recipient, String message) {
        System.out.println("Notification sent to " + recipient + ": " + message);
    }
    
    @Override
    public void sendReport(String recipient, String report) {
        System.out.println("Report sent to " + recipient + ":\n" + report);
    }
    
    // Kelas untuk menyimpan data transaksi
    private class Transaction {
        private double amount;
        private String description;
        private String type; // "IN" or "OUT"
        private java.util.Date date;
        
        public Transaction(double amount, String description, String type) {
            this.amount = amount;
            this.description = description;
            this.type = type;
            this.date = new java.util.Date();
        }
        
        @Override
        public String toString() {
            return date + " [" + type + "] " + amount + " - " + description;
        }
    }
}