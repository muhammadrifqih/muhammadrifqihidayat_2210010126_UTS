/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package muhammadrifqihidayat_2210010126_uts;

/**
 *
 * @author ASUS
 */


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseHelper {
    // URL koneksi ke database SQLite
    private static final String URL = "jdbc:sqlite:kegiatan.db";
    
    // Objek koneksi untuk menghubungkan aplikasi ke database
    private Connection conn;

    // Metode untuk melakukan koneksi ke database
    public Connection connect() {
        try {
            // Menghubungkan ke database SQLite menggunakan URL
            conn = DriverManager.getConnection(URL);
            System.out.println("Koneksi ke database berhasil!");
            
            // Setelah berhasil terkoneksi, buat tabel jika belum ada
            createTable();
        } catch (SQLException e) {
            // Menangani kesalahan jika terjadi kegagalan dalam koneksi
            System.out.println("Koneksi gagal: " + e.getMessage());
        }
        // Mengembalikan objek koneksi
        return conn;
    }

    // Metode untuk membuat tabel jika belum ada
    private void createTable() {
        // Query SQL untuk membuat tabel 'kegiatan' jika belum ada
        String createTableSQL = "CREATE TABLE IF NOT EXISTS kegiatan (" 
                + "id INTEGER PRIMARY KEY AUTOINCREMENT, "      // Kolom ID dengan tipe INTEGER dan auto increment
                + "nama_kegiatan TEXT NOT NULL, "               // Kolom nama_kegiatan dengan tipe TEXT
                + "tanggal_kegiatan TEXT NOT NULL, "            // Kolom tanggal_kegiatan dengan tipe TEXT
                + "jam_kegiatan TEXT NOT NULL, "                // Kolom jam_kegiatan dengan tipe TEXT
                + "tempat_kegiatan TEXT NOT NULL, "             // Kolom tempat_kegiatan dengan tipe TEXT
                + "deskripsi TEXT NOT NULL"                     // Kolom deskripsi dengan tipe TEXT
                + ");";
        
        // Menjalankan perintah untuk membuat tabel
        try (Statement stmt = conn.createStatement()) {
            // Menjalankan perintah SQL untuk membuat tabel
            stmt.execute(createTableSQL);
            System.out.println("Tabel berhasil dibuat atau sudah ada.");
        } catch (SQLException e) {
            // Menangani kesalahan jika terjadi kegagalan saat membuat tabel
            System.out.println("Kesalahan membuat tabel: " + e.getMessage());
        }
    }
}
