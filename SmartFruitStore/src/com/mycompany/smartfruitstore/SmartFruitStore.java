package com.mycompany.smartfruitstore;
import java.util.Scanner;

public class SmartFruitStore {

    // Method Overloading 1: Cari berdasarkan Nama (String)
    public static void cariBuah(String nama, Buah[] daftar, int jumlah) {
        System.out.println("Mencari buah dengan Nama: " + nama);
        boolean ditemukan = false;
        for (int i = 0; i < jumlah; i++) {
            if (daftar[i].getNama().equalsIgnoreCase(nama)) {
                System.out.print("- Ditemukan: ");
                daftar[i].tampilkanInfo();
                ditemukan = true;
            }
        }
        if (!ditemukan) System.out.println("Buah tidak ditemukan.");
    }

    // Method Overloading 2: Cari berdasarkan Harga (int)
    public static void cariBuah(int harga, Buah[] daftar, int jumlah) {
        System.out.println("Mencari buah dengan Harga: Rp" + harga);
        boolean ditemukan = false;
        for (int i = 0; i < jumlah; i++) {
            if (daftar[i].getHarga() == harga) {
                System.out.print("- Ditemukan: ");
                daftar[i].tampilkanInfo();
                ditemukan = true;
            }
        }
        if (!ditemukan) System.out.println("Buah tidak ditemukan.");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Buah[] daftarBuah = new Buah[10]; // Array penyimpan data
        int jumlahBuah = 0;
        boolean isRunning = true;

        System.out.println("=====================================");
        System.out.println("   SELAMAT DATANG DI SMART FRUIT     ");
        System.out.println("=====================================");

        while (isRunning) {
            System.out.println("\nMenu Utama:");
            System.out.println("1. Tambah Data Buah");
            System.out.println("2. Lihat Daftar Buah");
            System.out.println("3. Cari Buah");
            System.out.println("4. Keluar");
            System.out.print("Pilih Menu (1-4): ");
            
            int pilihan = scanner.nextInt();
            scanner.nextLine(); 

            switch (pilihan) {
                case 1 -> {
                    if (jumlahBuah < daftarBuah.length) {
                        System.out.println("\n-- Pilih Jenis Buah --");
                        System.out.println("1. Buah Lokal");
                        System.out.println("2. Buah Import");
                        System.out.print("Pilihan (1/2): ");
                        int jenis = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("Masukkan Nama Buah: ");
                        String namaBaru = scanner.nextLine();
                        System.out.print("Masukkan Harga: Rp");
                        int hargaBaru = scanner.nextInt();
                        scanner.nextLine();

                        if (jenis == 1) {
                            System.out.print("Masukkan Daerah Asal (Contoh: Malang/Medan): ");
                            String daerah = scanner.nextLine();
                            daftarBuah[jumlahBuah] = new BuahLokal(namaBaru, hargaBaru, daerah);
                        } else if (jenis == 2) {
                            System.out.print("Masukkan Negara Asal (Contoh: China/USA): ");
                            String negara = scanner.nextLine();
                            daftarBuah[jumlahBuah] = new BuahImport(namaBaru, hargaBaru, negara);
                        }
                        jumlahBuah++;
                        System.out.println("Sukses! Buah berhasil ditambahkan ke toko.");
                    } else {
                        System.out.println("Maaf, kapasitas toko penuh!");
                    }
                }
                case 2 -> {
                    System.out.println("\n--- Daftar Buah di Toko ---");
                    if (jumlahBuah == 0) {
                        System.out.println("Belum ada data buah.");
                    } else {
                        for (int i = 0; i < jumlahBuah; i++) {
                            System.out.print((i + 1) + ". ");
                            daftarBuah[i].tampilkanInfo();
                        }
                    }
                    System.out.println("* Total Macam Buah Terdaftar: " + Buah.totalBuah);
                }
                case 3 -> {
                    System.out.println("\n-- Fitur Cari --");
                    System.out.println("1. Berdasarkan Nama");
                    System.out.println("2. Berdasarkan Harga");
                    System.out.print("Pilih (1/2): ");
                    int mode = scanner.nextInt();
                    scanner.nextLine();

                    if (mode == 1) {
                        System.out.print("Masukkan Nama Buah: ");
                        String cariNama = scanner.nextLine();
                        cariBuah(cariNama, daftarBuah, jumlahBuah);
                    } else if (mode == 2) {
                        System.out.print("Masukkan Harga Buah: Rp");
                        int cariHarga = scanner.nextInt();
                        cariBuah(cariHarga, daftarBuah, jumlahBuah);
                    }
                }
                case 4 -> {
                    System.out.println("Terima kasih telah menggunakan Smart FruitStore!");
                    isRunning = false;
                }
                default -> System.out.println("Pilihan tidak valid!");
            }
        }
        scanner.close();
    }
}