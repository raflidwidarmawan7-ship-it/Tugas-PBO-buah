package com.mycompany.smartfruitstore;

public class BuahEksotis extends Buah implements DapatDikupas, DapatDibuatJus {
    private String kelangkaan;

    public BuahEksotis(String nama, int harga, String kelangkaan) {
        super(nama, harga);
        this.kelangkaan = kelangkaan;
    }

    @Override
    public void tampilkanInfo() {
        System.out.printf("[Eksotis] Nama: %-10s | Harga: Rp%-7d | Status: %s%n", 
                super.getNama(), super.getHarga(), this.kelangkaan);
    }

    @Override
    public void caraKonsumsi() {
        System.out.println("-> Cara Konsumsi: Harus dikupas dengan teknik khusus karena kulitnya keras.");
    }

    @Override
    public void hitungMasaKedaluwarsa() {
        System.out.println("-> Aturan Kedaluwarsa: Tahan 3 hari saja, harus segera dikonsumsi.");
    }

    @Override
    public void prosesKupas() {
        System.out.println("-> [PROSES KUPAS] Membelah kulit keras eksotis menggunakan alat potong khusus.");
    }

    @Override
    public void buatJus(int sendokGula) {
        System.out.println("-> [PROSES JUS] Buah eksotis diolah lambat dan ditambah " + sendokGula + " sendok gula.");
    }
}