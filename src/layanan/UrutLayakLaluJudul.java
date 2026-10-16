/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package layanan;

/**
 *
 * @author HERNAWATI
 */
import java.util.Comparator;
import model.Koleksi;

public class UrutLayakLaluJudul implements Comparator<Koleksi> {
    private final Comparator<Koleksi> pembanding =
            Comparator.comparing(Koleksi::layakDipinjam, Comparator.reverseOrder())
                      .thenComparing(Koleksi::getJudul, String.CASE_INSENSITIVE_ORDER);

    @Override
    public int compare(Koleksi a, Koleksi b) {
        return pembanding.compare(a, b);
    }
}
