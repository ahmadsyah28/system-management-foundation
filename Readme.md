# YayasanSystem

## Deskripsi Proyek
YayasanSystem adalah sebuah aplikasi berbasis Java yang dirancang untuk mengelola donasi dan dana yayasan. Sistem ini memungkinkan pengguna untuk:
- Melakukan donasi dengan mencatat data donor dan jumlah donasi.
- Mencatat dan mengelola dana yang masuk serta dialokasikan untuk tujuan tertentu.
- Menghasilkan laporan dana yang dapat ditampilkan dalam sistem.
- Mengirimkan notifikasi kepada donor sebagai bentuk apresiasi atas donasi mereka.

## Struktur File
Berikut adalah struktur file dalam proyek ini:

```
YayasanSystem/
├── DonateButton.java          # Tombol untuk melakukan donasi
├── DonorManagement.java       # Interface untuk manajemen donor
├── DonorManager.java          # Implementasi manajemen donor
├── FundManagement.java        # Interface untuk manajemen dana
├── FundManager.java           # Implementasi manajemen dana dan notifikasi
├── NotificationProvider.java  # Interface untuk layanan notifikasi
├── ReportButton.java          # Tombol untuk menampilkan laporan dana
├── UserInterface.java         # Interface untuk tombol UI
├── YayasanSystem.java         # Main class untuk menjalankan sistem
└── README.md                  # Dokumentasi proyek
```

## Cara Menjalankan Proyek
1. Pastikan Anda memiliki Java Development Kit (JDK) terinstal di komputer Anda.
2. Buka terminal atau command prompt, lalu navigasikan ke direktori proyek.
3. Kompilasi seluruh file Java dengan perintah:
   ```
   javac *.java
   ```
4. Jalankan program dengan perintah:
   ```
   java YayasanSystem
   ```

## Fitur Utama
- **Donasi Baru:** Pengguna dapat melakukan donasi dengan memasukkan ID donor dan jumlah donasi.
- **Laporan Dana:** Pengguna dapat melihat total dana yang telah diterima dan dialokasikan.
- **Informasi Donor:** Sistem dapat menampilkan informasi tentang seorang donor tertentu.
- **Alokasi Dana:** Pengguna dapat mengalokasikan dana untuk tujuan tertentu.
- **Notifikasi:** Donor akan menerima notifikasi sebagai bentuk apresiasi atas donasi mereka.

## Anggota Tim
1. Ahmad Syah Ramadhan (2208107010033)
2. Hidayat Nur Hakim (2208107010063)


