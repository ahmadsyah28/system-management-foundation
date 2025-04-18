public class DonorManager implements DonorManagement {
    // Menggunakan NotificationProvider untuk mengirim notifikasi & laporan
    private NotificationProvider notificationService;
    private java.util.Map<String, Donor> donors;

    // Constructor
    public DonorManager() {
        donors = new java.util.HashMap<>();
        notificationService = null;
    }

    // Menghubungkan dengan NotificationProvider (Dependency Injection)
    public void connectToNotificationService(NotificationProvider service) {
        this.notificationService = service;
    }

    @Override
    public void recordDonation(String donorId, double amount) {
        // Jika donor belum ada, buat baru
        if (!donors.containsKey(donorId)) {
            donors.put(donorId, new Donor(donorId, "Donor-" + donorId));
        }

        // Catat donasi
        Donor donor = donors.get(donorId);
        donor.addDonation(amount);

        System.out.println("Donation recorded: " + amount + " from donor " + donorId);

        // Menggunakan sendNotification() dari NotificationProvider jika tersedia
        if (notificationService != null) {
            notificationService.sendNotification(donorId,
                "Terima kasih atas donasi Anda sebesar " + amount);
        }
    }

    @Override
    public String getDonorInfo(String donorId) {
        if (donors.containsKey(donorId)) {
            return donors.get(donorId).toString();
        }
        return "Donor not found";
    }

    // Metode tambahan untuk mengirim laporan donasi
    public void generateAndSendReport(String recipient) {
        // Membuat laporan donasi
        StringBuilder report = new StringBuilder("Donation Report:\n");
        for (Donor donor : donors.values()) {
            report.append(donor.toString()).append("\n\n");
        }

        // Menggunakan sendReport() dari NotificationProvider jika tersedia
        if (notificationService != null) {
            notificationService.sendReport(recipient, report.toString());
        }
    }

    // Kelas untuk menyimpan data donor
    private class Donor {
        private String id;
        private String name;
        private double totalDonation;
        private java.util.List<Double> donations;

        public Donor(String id, String name) {
            this.id = id;
            this.name = name;
            this.totalDonation = 0;
            this.donations = new java.util.ArrayList<>();
        }

        public void addDonation(double amount) {
            donations.add(amount);
            totalDonation += amount;
        }

        @Override
        public String toString() {
            return "Donor ID: " + id + 
                   "\nName: " + name + 
                   "\nTotal Donation: " + totalDonation + 
                   "\nDonation History: " + donations;
        }
    }
}
