/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author HERNAWATI
 */
import eksepsi.PustakaException;
import java.io.IOException;
import java.util.Comparator;
import layanan.EksporKatalog;
import layanan.KatalogPerpustakaan;
import layanan.UrutLayakLaluJudul;
import model.BerkasDigital;
import model.BukuCetak;
import model.Koleksi;
import model.Majalah;

public class Main {
    public static void main(String[] args) {
        KatalogPerpustakaan katalog = new KatalogPerpustakaan();

        // Data uji wajib (lantai & rak majalah adalah asumsi karena tidak ada di soal)
        katalog.tambah(new BukuCetak("BK-001", "Java How to Program", 2022, 620, "A-12", 1, false));
        katalog.tambah(new BukuCetak("BK-002", "Basis Data Relasional", 2021, 410, "B-04", 2, true));
        katalog.tambah(new Majalah("MJ-001", "Info Teknologi Edisi 88", 2026, 88, "Agustus", "M-01", 1, true));
        katalog.tambah(new Majalah("MJ-002", "Info Teknologi Edisi 87", 2026, 87, "Juli", "M-02", 1, false));
        katalog.tambah(new BerkasDigital("BD-001", "Panduan Pemrograman Java", 2024, 15, "unduh.polmed.ac.id/bd001"));
        katalog.tambah(new BerkasDigital("BD-002", "Jurnal Rekayasa Perangkat", 2025, 8, "unduh.polmed.ac.id/bd002"));

        // Soal 3: cetakStatus
        System.out.println("STATUS KOLEKSI");
        katalog.cetakStatus();

        // Soal 4: urut dengan Comparator UrutLayakLaluJudul
        System.out.println();
        System.out.println("URUTAN LAYAK DULU, LALU JUDUL");
        for (Koleksi k : katalog.urut(new UrutLayakLaluJudul())) {
            System.out.println(String.format("%-8s %-28s %s", k.getKode(), k.getJudul(), k.statusPinjam()));
        }

        // Soal 5: pinjam dan eksepsi
        System.out.println();
        System.out.println("PEMINJAMAN");
        String[] percobaan = {"BK-001", "BK-001", "BK-002", "MJ-001", "MJ-002", "BD-001", "XX-999"};
        for (String kode : percobaan) {
            try {
                katalog.pinjam(kode);
                System.out.println("[BERHASIL] " + kode + " berhasil dipinjam.");
            } catch (PustakaException e) {
                System.out.println("[GAGAL]    " + e.getMessage());
            }
        }

        // Soal 6: ekspor ke katalog.txt
        System.out.println();
        try {
            new EksporKatalog().tulis(katalog, "katalog.txt");
            System.out.println("Berhasil menulis katalog.txt");
        } catch (IOException e) {
            System.out.println("Gagal menulis berkas: " + e.getMessage());
        }
    }
}      
