/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author HERNAWATI
 */
public class BukuCetak extends Koleksi implements Terarsip {
    private final int jumlahHalaman;
    private final String nomorRak;
    private final int lantai;
    private final boolean sedangDiperbaiki;

    public BukuCetak(String kode, String judul, int tahunTerbit,
                     int jumlahHalaman, String nomorRak, int lantai,
                     boolean sedangDiperbaiki) {
        super(kode, judul, tahunTerbit);
        this.jumlahHalaman = jumlahHalaman;
        this.nomorRak = nomorRak;
        this.lantai = lantai;
        this.sedangDiperbaiki = sedangDiperbaiki;
    }

    @Override
    public boolean layakDipinjam() {
        return !sedangDiperbaiki;
    }

    @Override
    public String alasanTidakLayak() {
        return "buku ini sedang diperbaiki";
    }

    @Override
    public String deskripsi() {
        return super.deskripsi() + ", " + jumlahHalaman + " halaman, " + ringkasanArsip();
    }

    @Override
    public String lokasi() {
        return ringkasanArsip();
    }

    @Override
    public String nomorRak() { return nomorRak; }

    @Override
    public String lokasiLantai() { return "Lantai " + lantai; }

    public int getJumlahHalaman() { return jumlahHalaman; }
}
