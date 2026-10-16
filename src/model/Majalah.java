/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author HERNAWATI
 */
public class Majalah extends Koleksi implements Terarsip {
    private final int edisi;
    private final String bulanTerbit;
    private final String nomorRak;
    private final int lantai;
    private final boolean edisiTerbaru;

    public Majalah(String kode, String judul, int tahunTerbit,
                   int edisi, String bulanTerbit, String nomorRak, int lantai,
                   boolean edisiTerbaru) {
        super(kode, judul, tahunTerbit);
        this.edisi = edisi;
        this.bulanTerbit = bulanTerbit;
        this.nomorRak = nomorRak;
        this.lantai = lantai;
        this.edisiTerbaru = edisiTerbaru;
    }

    @Override
    public boolean layakDipinjam() {
        return !edisiTerbaru;
    }

    @Override
    public String alasanTidakLayak() {
        return "majalah ini adalah edisi terbaru sehingga hanya boleh dibaca di perpustakaan";
    }

    @Override
    public String deskripsi() {
        return super.deskripsi() + ", edisi " + edisi + " (" + bulanTerbit + "), " + ringkasanArsip();
    }

    @Override
    public String lokasi() {
        return ringkasanArsip();
    }

    @Override
    public String nomorRak() { return nomorRak; }

    @Override
    public String lokasiLantai() { return "Lantai " + lantai; }

    public int getEdisi() { return edisi; }

    public String getBulanTerbit() { return bulanTerbit; }
}
