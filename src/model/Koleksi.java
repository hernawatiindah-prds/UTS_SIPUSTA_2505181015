/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author HERNAWATI
 */
public abstract class Koleksi {
    private final String kode;
    private final String judul;
    private final int tahunTerbit;
    private boolean sedangDipinjam;

    protected Koleksi(String kode, String judul, int tahunTerbit) {
        this.kode = kode;
        this.judul = judul;
        this.tahunTerbit = tahunTerbit;
    }

    // Aturan kelayakan pinjam, berbeda untuk setiap jenis koleksi. */
    public abstract boolean layakDipinjam();

    // Alasan dalam bahasa awam mengapa koleksi tidak layak dipinjam. */
    public abstract String alasanTidakLayak();

    // Deskripsi dasar; diperluas oleh setiap turunan memakai super. */
    public String deskripsi() {
        return kode + " - \"" + judul + "\" (" + tahunTerbit + ")";
    }

    // Lokasi fisik. Default "-"; ditimpa oleh koleksi yang punya rak. */
    public String lokasi() {
        return "-";
    }

    public String jenis() {
        return getClass().getSimpleName();
    }

    public String statusPinjam() {
        if (sedangDipinjam) {
            return "Sedang dipinjam";
        }
        return layakDipinjam() ? "Layak dipinjam" : "Tidak layak dipinjam";
    }

    public String getKode() { return kode; }

    public String getJudul() { return judul; }

    public int getTahunTerbit() { return tahunTerbit; }

    public boolean isSedangDipinjam() { return sedangDipinjam; }

    public void setSedangDipinjam(boolean sedangDipinjam) {
        this.sedangDipinjam = sedangDipinjam;
    }
}
