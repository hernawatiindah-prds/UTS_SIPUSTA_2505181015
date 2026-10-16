/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package layanan;

/**
 *
 * @author HERNAWATI
 */
import eksepsi.KoleksiSedangDipinjamException;
import eksepsi.KoleksiTidakLayakException;
import eksepsi.PustakaException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import model.Koleksi;

public class KatalogPerpustakaan {
    // Satu daftar bertipe kelas induk -> polimorfisme
    private final List<Koleksi> daftar = new ArrayList<>();

    public void tambah(Koleksi koleksi) {
        daftar.add(koleksi);
    }

    public List<Koleksi> getDaftar() {
        return Collections.unmodifiableList(daftar);
    }

    /** Memproses semua koleksi secara polimorfik (tanpa percabangan tipe). */
    public void cetakStatus() {
        for (Koleksi k : daftar) {
            System.out.println(k.deskripsi());
            System.out.println("   Status: " + k.statusPinjam());
        }
    }

    /** Aturan pengurutan dapat diganti dari luar lewat Comparator. */
    public List<Koleksi> urut(Comparator<? super Koleksi> pembanding) {
        List<Koleksi> hasil = new ArrayList<>(daftar);
        hasil.sort(pembanding);
        return hasil;
    }

    public void pinjam(String kode) throws PustakaException {
        Koleksi k = cari(kode);
        if (k.isSedangDipinjam()) {
            throw new KoleksiSedangDipinjamException(k.getJudul());
        }
        if (!k.layakDipinjam()) {
            throw new KoleksiTidakLayakException(k.getJudul(), k.alasanTidakLayak());
        }
        k.setSedangDipinjam(true);
    }

    private Koleksi cari(String kode) throws PustakaException {
        for (Koleksi k : daftar) {
            if (k.getKode().equalsIgnoreCase(kode)) {
                return k;
            }
        }
        throw new PustakaException("Koleksi dengan kode " + kode + " tidak ditemukan di katalog.");
    }
}
