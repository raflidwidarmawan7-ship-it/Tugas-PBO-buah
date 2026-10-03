package com.mycompany.smartfruitstore;

public class BuahLokal extends Buah {
    private String daerahAsal;

    public BuahLokal(String nama, int harga, String daerahAsal) {
        super(nama, harga); 
        this.daerahAsal = daerahAsal;
    }

    @Override
    public void tampilkanInfo() {
        System.out.printf("[Lokal]  Nama: %-10s | Harga: Rp%-7d | Asal: %s%n", 
                super.getNama(), super.getHarga(), this.daerahAsal);
    }
}