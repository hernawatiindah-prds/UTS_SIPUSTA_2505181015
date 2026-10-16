/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package layanan;

/**
 *
 * @author HERNAWATI
 */
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import model.Koleksi;

public class EksporKatalog {
    private static final String FORMAT = "%-8s %-14s %-28s %-6s %-21s %s%n";

    public void tulis(KatalogPerpustakaan katalog, String namaBerkas) throws IOException {
        // try-with-resources: aliran otomatis ditutup
        try (BufferedWriter out = Files.newBufferedWriter(Paths.get(namaBerkas), StandardCharsets.UTF_8)) {
            out.write(String.format(FORMAT, "KODE", "JENIS", "JUDUL", "TAHUN", "STATUS", "LOKASI"));
            out.write("-".repeat(98));
            out.newLine();
            for (Koleksi k : katalog.getDaftar()) {
                out.write(String.format(FORMAT, k.getKode(), k.jenis(), k.getJudul(),
                        k.getTahunTerbit(), k.statusPinjam(), k.lokasi()));
            }
        }
    }
}
