package com.mycompany.smartfruitstore;

public class BuahImport extends Buah implements DapatDikupas {
    private String negaraAsal;

    public BuahImport(String nama, int harga, String negaraAsal) {
        super(nama, harga);
        this.negaraAsal = negaraAsal;
    }

    @Override
    public void tampilkanInfo() {
        System.out.printf("[Import]  Nama: %-10s | Harga: Rp%-7d | Negara: %s%n", 
                super.getNama(), super.getHarga(), this.negaraAsal);
    }

    @Override
    public void caraKonsumsi() {
        System.out.println("-> Cara Konsumsi: Sebaiknya dikupas terlebih dahulu sebelum dikonsumsi.");
    }

    @Override
    public void hitungMasaKedaluwarsa() {
        System.out.println("-> Aturan Kedaluwarsa: Tahan 14 hari di dalam lemari pendingin.");
    }

    @Override
    public void prosesKupas() {
        System.out.println("-> [PROSES KUPAS] Menggunakan pisau tajam untuk mengupas kulit buah import.");
    }
}