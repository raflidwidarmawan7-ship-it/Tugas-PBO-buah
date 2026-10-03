package com.mycompany.smartfruitstore;

public class Buah {

    private String nama;
    private int harga;

    public static int totalBuah = 0;

    // Constructor Induk
    public Buah(String nama, int harga) {
        this.nama = nama;
        this.harga = harga;
        totalBuah++;
    }

    public String getNama() {
        return this.nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getHarga() {
        return this.harga;
    }

    public void setHarga(int harga) {
        if (harga > 0) {
            this.harga = harga;
        } else {
            System.out.println("Harga tidak valid!");
        }
    }

    public void tampilkanInfo() {
        System.out.printf("Nama: %-15s | Harga: Rp%d%n", this.nama, this.harga);
    }
}
