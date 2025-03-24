public class DonateButton implements UserInterface {
    // Menggunakan interface DonorManagement sebagai dependency
    private DonorManagement donorManager; 
    private String donorId;
    private double donationAmount;
    
    // Constructor
    public DonateButton() {
        donorManager = null;
        donorId = "unknown";
        donationAmount = 0;
    }
    
    // Menghubungkan dengan DonorManagement (Menggunakan interface DonorManagement)
    public void connectToDonorManager(DonorManagement manager) {
        this.donorManager = manager;
    }
    
    // Menyiapkan data donasi
    public void prepareDonation(String donorId, double amount) {
        this.donorId = donorId;
        this.donationAmount = amount;
        System.out.println("Donation prepared: " + amount + " from donor " + donorId);
    }
    
    @Override
    public void buttonPressed() {
        if (donorManager != null && donationAmount > 0) {
            System.out.println("Donate button pressed");

            // Menggunakan method recordDonation() dari interface DonorManagement
            donorManager.recordDonation(donorId, donationAmount);

            // Reset setelah donasi
            donationAmount = 0;
        } else {
            System.out.println("Cannot process donation: either no donor manager connected or donation amount is 0");
        }
    }

    // Menambahkan method untuk menggunakan method getDonorInfo() dari interface DonorManagement
    public void showDonorInfo() {
        if (donorManager != null) {
            // Menggunakan method getDonorInfo() dari interface DonorManagement
            System.out.println(donorManager.getDonorInfo(donorId));
        } else {
            System.out.println("No donor manager connected.");
        }
    }
}
