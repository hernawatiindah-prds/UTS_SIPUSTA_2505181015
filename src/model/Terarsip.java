/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package model;

/**
 *
 * @author HERNAWATI
 */
public interface Terarsip {
    String nomorRak();

    String lokasiLantai();

    /** Menggabungkan nomor rak dan lokasi lantai. */
    default String ringkasanArsip() {
        return "Rak " + nomorRak() + ", " + lokasiLantai();
    }
}
