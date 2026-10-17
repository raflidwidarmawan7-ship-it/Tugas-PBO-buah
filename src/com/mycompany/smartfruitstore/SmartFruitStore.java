package com.mycompany.smartfruitstore;

import java.util.Scanner;

public class SmartFruitStore {

    public static void cariBuah(String nama, Buah[] daftar, int jumlah) {
        System.out.println("Mencari buah dengan Nama (Teks): " + nama);
        boolean ditemukan = false;
        for (int i = 0; i < jumlah; i++) {
            if (daftar[i].getNama().equalsIgnoreCase(nama)) {
                System.out.print("- Ditemukan: ");
                daftar[i].tampilkanInfo();
                ditemukan = true;
            }
        }
        if (!ditemukan) {
            System.out.println("Buah tidak ditemukan.");
        }
    }

    public static void cariBuah(int harga, Buah[] daftar, int jumlah) {
        System.out.println("Mencari buah dengan Harga (Angka): Rp" + harga);
        boolean ditemukan = false;
        for (int i = 0; i < jumlah; i++) {
            if (daftar[i].getHarga() == harga) {
                System.out.print("- Ditemukan: ");
                daftar[i].tampilkanInfo();
                ditemukan = true;
            }
        }
        if (!ditemukan) {
            System.out.println("Buah tidak ditemukan.");
        }
    }

    public static void simulasiKonsumsi(Buah item) {
        item.caraKonsumsi();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Buah[] daftarBuah = new Buah[10];
        int jumlahBuah = 0;
        boolean isRunning = true;

        System.out.println("=====================================");
        System.out.println("   SELAMAT DATANG DI SMART FRUIT     ");
        System.out.println("=====================================");

        while (isRunning) {
            System.out.println("\nMenu Utama:");
            System.out.println("1. Tambah Data Buah");
            System.out.println("2. Lihat Daftar & Simulasi Proses");
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
                        System.out.println("3. Buah Eksotis");
                        System.out.print("Pilihan (1/2/3): ");
                        int jenis = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("Masukkan Nama Buah: ");
                        String namaBaru = scanner.nextLine();
                        System.out.print("Masukkan Harga: Rp");
                        int hargaBaru = scanner.nextInt();
                        scanner.nextLine();

                        if (jenis == 1) {
                            System.out.print("Masukkan Daerah Asal: ");
                            String daerah = scanner.nextLine();
                            daftarBuah[jumlahBuah] = new BuahLokal(namaBaru, hargaBaru, daerah);
                        } else if (jenis == 2) {
                            System.out.print("Masukkan Negara Asal: ");
                            String negara = scanner.nextLine();
                            daftarBuah[jumlahBuah] = new BuahImport(namaBaru, hargaBaru, negara);
                        } else if (jenis == 3) {
                            System.out.print("Masukkan Tingkat Kelangkaan (Biasa/Langka): ");
                            String langka = scanner.nextLine();
                            daftarBuah[jumlahBuah] = new BuahEksotis(namaBaru, hargaBaru, langka);
                        }
                        jumlahBuah++;
                        System.out.println("Sukses! Objek Buah berhasil diciptakan.");
                    } else {
                        System.out.println("Maaf, kapasitas toko penuh!");
                    }
                }
                case 2 -> {
                    System.out.println("\n--- Daftar Buah di Toko ---");
                    if (jumlahBuah == 0) {
                        System.out.println("Belum ada data buah yang tersimpan.");
                    } else {
                        for (int i = 0; i < jumlahBuah; i++) {
                            System.out.print((i + 1) + ". ");
                            daftarBuah[i].tampilkanInfo();
                            simulasiKonsumsi(daftarBuah[i]);

                            daftarBuah[i].hitungMasaKedaluwarsa();

                            if (daftarBuah[i] instanceof DapatDikupas) {
                                DapatDikupas itemBisaDikupas = (DapatDikupas) daftarBuah[i];
                                itemBisaDikupas.prosesKupas();
                            }

                            if (daftarBuah[i] instanceof DapatDibuatJus) {
                                DapatDibuatJus itemBisaDiJus = (DapatDibuatJus) daftarBuah[i];
                                itemBisaDiJus.buatJus(2);
                            }
                            System.out.println();
                        }
                    }
                    System.out.println("* Total Macam Buah Terdaftar: " + Buah.totalBuah);
                    System.out.print("Tekan Enter untuk melanjutkan...");
                    scanner.nextLine();
                }
                case 3 -> {
                    System.out.println("\n-- Fitur Cari --");
                    System.out.println("1. Cari berdasarkan Nama Teks (String)");
                    System.out.println("2. Cari berdasarkan Harga (Integer)");
                    System.out.print("Pilih (1/2): ");
                    int modeCari = scanner.nextInt();
                    scanner.nextLine();

                    if (modeCari == 1) {
                        System.out.print("Masukkan Nama: ");
                        String cariNama = scanner.nextLine();
                        cariBuah(cariNama, daftarBuah, jumlahBuah);
                    } else if (modeCari == 2) {
                        System.out.print("Masukkan Harga: Rp");
                        int cariHarga = scanner.nextInt();
                        cariBuah(cariHarga, daftarBuah, jumlahBuah);
                    } else {
                        System.out.println("Pilihan tidak valid.");
                    }
                    System.out.print("Tekan Enter untuk melanjutkan...");
                    scanner.nextLine();
                }
                case 4 -> {
                    System.out.println("Terima kasih telah menggunakan Smart FruitStore!");
                    isRunning = false;
                }
                default ->
                    System.out.println("Pilihan tidak valid!");
            }
        }
        scanner.close();
    }
}
