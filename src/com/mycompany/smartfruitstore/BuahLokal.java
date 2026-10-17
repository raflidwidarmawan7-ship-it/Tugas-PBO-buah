package com.mycompany.smartfruitstore;

public class BuahLokal extends Buah implements DapatDibuatJus {
    private String daerahAsal;

    public BuahLokal(String nama, int harga, String daerahAsal) {
        super(nama, harga); 
        this.daerahAsal = daerahAsal;
    }

    @Override
    public void tampilkanInfo() {
        System.out.printf("[Lokal]   Nama: %-10s | Harga: Rp%-7d | Asal: %s%n", 
                super.getNama(), super.getHarga(), this.daerahAsal);
    }

    @Override
    public void caraKonsumsi() {
        System.out.println("-> Cara Konsumsi: Cuci bersih, bisa langsung dimakan beserta kulitnya.");
    }

    @Override
    public void hitungMasaKedaluwarsa() {
        System.out.println("-> Aturan Kedaluwarsa: Tahan 7 hari di suhu ruangan.");
    }

    @Override
    public void buatJus(int sendokGula) {
        System.out.println("-> [PROSES JUS] Buah lokal di-blend dengan " + sendokGula + " sendok gula.");
    }
}