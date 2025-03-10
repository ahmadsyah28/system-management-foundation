import java.util.Scanner;

// Main class untuk menghubungkan semua komponen
public class YayasanSystem {
    public static void main(String[] args) {
        // Membuat komponen
        DonorManager donorManager = new DonorManager();
        FundManager fundManager = new FundManager();
        DonateButton donateButton = new DonateButton();
        ReportButton reportButton = new ReportButton();
        
        // Menghubungkan komponen
        donorManager.connectToNotificationService(fundManager);
        donateButton.connectToDonorManager(donorManager);
        reportButton.connectToFundManager(fundManager);
        
        // Scanner untuk input pengguna
        Scanner scanner = new Scanner(System.in);
        
        // Menu utama
        boolean running = true;
        while (running) {
            System.out.println("\n=== SISTEM YAYASAN ===");
            System.out.println("1. Donasi Baru");
            System.out.println("2. Lihat Laporan Dana");
            System.out.println("3. Lihat Info Donor");
            System.out.println("4. Alokasikan Dana");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu (1-5): ");
            
            int choice = 0;
            try {
                choice = scanner.nextInt();
                scanner.nextLine(); // Membersihkan buffer
            } catch (Exception e) {
                scanner.nextLine(); // Membersihkan buffer jika input tidak valid
                System.out.println("Input tidak valid. Silakan masukkan angka 1-5.");
                continue;
            }
            
            switch (choice) {
                case 1:
                    // Donasi baru
                    System.out.println("\n=== DONASI BARU ===");
                    System.out.print("Masukkan ID Donor: ");
                    String donorId = scanner.nextLine();
                    
                    double amount = 0;
                    boolean validAmount = false;
                    while (!validAmount) {
                        try {
                            System.out.print("Masukkan jumlah donasi: ");
                            amount = scanner.nextDouble();
                            scanner.nextLine(); // Membersihkan buffer
                            
                            if (amount <= 0) {
                                System.out.println("Jumlah donasi harus lebih dari 0.");
                                continue;
                            }
                            validAmount = true;
                        } catch (Exception e) {
                            scanner.nextLine(); // Membersihkan buffer jika input tidak valid
                            System.out.println("Input tidak valid. Silakan masukkan angka.");
                        }
                    }
                    
                    // Proses donasi
                    donateButton.prepareDonation(donorId, amount);
                    donateButton.buttonPressed();
                    
                    // FundManager mencatat dana dari donasi
                    fundManager.recordFunds(amount, "Donor " + donorId);
                    break;
                    
                case 2:
                    // Lihat laporan
                    System.out.println("\n=== LAPORAN DANA ===");
                    reportButton.buttonPressed();
                    break;
                    
                case 3:
                    // Lihat info donor
                    System.out.println("\n=== INFO DONOR ===");
                    System.out.print("Masukkan ID Donor: ");
                    String id = scanner.nextLine();
                    System.out.println(donorManager.getDonorInfo(id));
                    break;
                    
                case 4:
                    // Alokasikan dana
                    System.out.println("\n=== ALOKASI DANA ===");
                    
                    double allocationAmount = 0;
                    boolean validAllocation = false;
                    while (!validAllocation) {
                        try {
                            System.out.print("Masukkan jumlah dana yang akan dialokasikan: ");
                            allocationAmount = scanner.nextDouble();
                            scanner.nextLine(); // Membersihkan buffer
                            
                            if (allocationAmount <= 0) {
                                System.out.println("Jumlah alokasi harus lebih dari 0.");
                                continue;
                            }
                            validAllocation = true;
                        } catch (Exception e) {
                            scanner.nextLine(); // Membersihkan buffer jika input tidak valid
                            System.out.println("Input tidak valid. Silakan masukkan angka.");
                        }
                    }
                    
                    System.out.print("Masukkan tujuan alokasi dana: ");
                    String purpose = scanner.nextLine();
                    
                    fundManager.allocateFunds(allocationAmount, purpose);
                    break;
                    
                case 5:
                    // Keluar dari program
                    running = false;
                    System.out.println("Terima kasih telah menggunakan Sistem Yayasan.");
                    break;
                    
                default:
                    System.out.println("Pilihan tidak valid. Silakan masukkan angka 1-5.");
            }
        }
        
        scanner.close();
    }
}