package com.mycompany.smartfruitstore;

public class BuahImport extends Buah {
    private String negaraAsal;

    public BuahImport(String nama, int harga, String negaraAsal) {
        super(nama, harga);
        this.negaraAsal = negaraAsal;
    }

    @Override
    public void tampilkanInfo() {
        System.out.printf("[Import] Nama: %-10s | Harga: Rp%-7d | Negara: %s%n", 
                super.getNama(), super.getHarga(), this.negaraAsal);
    }
}