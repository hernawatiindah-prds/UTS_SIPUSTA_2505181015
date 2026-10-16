/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eksepsi;

/**
 *
 * @author HERNAWATI
 */
//Induk seluruh eksepsi pada sistem perpustakaan (checked exception)
public class PustakaException extends Exception {
    public PustakaException(String pesan) {
        super(pesan);
    }
}
