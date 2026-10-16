/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author HERNAWATI
 */
//Berkas digital tidak punya rak, jadi TIDAK mengimplementasikan Terarsip
public class BerkasDigital extends Koleksi {
    private final int ukuranMB;
    private final String tautanUnduh;

    public BerkasDigital(String kode, String judul, int tahunTerbit,
                         int ukuranMB, String tautanUnduh) {
        super(kode, judul, tahunTerbit);
        this.ukuranMB = ukuranMB;
        this.tautanUnduh = tautanUnduh;
    }

    @Override
    public boolean layakDipinjam() {
        return true;
    }

    @Override
    public String alasanTidakLayak() {
        return "berkas digital ini tidak tersedia";
    }

    @Override
    public String deskripsi() {
        return super.deskripsi() + ", " + ukuranMB + " MB, " + tautanUnduh;
    }

    public int getUkuranMB() { return ukuranMB; }

    public String getTautanUnduh() { return tautanUnduh; }
}
