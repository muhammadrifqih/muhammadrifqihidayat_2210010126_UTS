/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package muhammadrifqihidayat_2210010126_uts;

/**
 *
 * @author ASUS
 */
import java.util.Date;

public class Kegiatan {
    private int id;
    private String nama;
    private String tanggal;
    private String jam;
    private String tempat;
    private String deskripsi;

    public Kegiatan(int id, String nama, String tanggal, String jam, String tempat, String deskripsi) {
        this.id = id;
        this.nama = nama;
        this.tanggal = tanggal;
        this.jam = jam;
        this.tempat = tempat;
        this.deskripsi = deskripsi;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getJam() {
        return jam;
    }

    public void setJam(String jam) {
        this.jam = jam;
    }

    public String getTempat() {
        return tempat;
    }

    public void setTempat(String tempat) {
        this.tempat = tempat;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }
}

