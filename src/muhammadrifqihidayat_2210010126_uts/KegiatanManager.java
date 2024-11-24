/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package muhammadrifqihidayat_2210010126_uts;

/**
 *
 * @author ASUS
 */
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class KegiatanManager {
    private Connection conn;

    public KegiatanManager(Connection conn) {
        this.conn = conn;
    }

    // Menambahkan kegiatan
    public void tambahKegiatan(Kegiatan kegiatan) throws SQLException {
        String sql = "INSERT INTO kegiatan (nama_kegiatan, tanggal_kegiatan, jam_kegiatan, tempat_kegiatan, deskripsi) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, kegiatan.getNama());
            pstmt.setString(2, kegiatan.getTanggal().toString());
            pstmt.setString(3, kegiatan.getJam());
            pstmt.setString(4, kegiatan.getTempat());
            pstmt.setString(5, kegiatan.getDeskripsi());
            pstmt.executeUpdate();
        }
    }

    // Mengambil semua kegiatan
    public List<Kegiatan> getAllKegiatan() throws SQLException {
        List<Kegiatan> kegiatanList = new ArrayList<>();
        String sql = "SELECT * FROM kegiatan";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Kegiatan kegiatan = new Kegiatan(
                        rs.getInt("id"),
                        rs.getString("nama_kegiatan"),
                        rs.getString("tanggal_kegiatan"),
                        rs.getString("jam_kegiatan"),
                        rs.getString("tempat_kegiatan"),
                        rs.getString("deskripsi")
                );
                kegiatanList.add(kegiatan);
            }
        }
        return kegiatanList;
    }

    // Mengubah kegiatan
    public void ubahKegiatan(Kegiatan kegiatan) throws SQLException {
        String sql = "UPDATE kegiatan SET nama_kegiatan = ?, tanggal_kegiatan = ?, jam_kegiatan = ?, tempat_kegiatan = ?, deskripsi = ? WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, kegiatan.getNama());
            pstmt.setString(2, kegiatan.getTanggal().toString());
            pstmt.setString(3, kegiatan.getJam());
            pstmt.setString(4, kegiatan.getTempat());
            pstmt.setString(5, kegiatan.getDeskripsi());
            pstmt.setInt(6, kegiatan.getId());
            pstmt.executeUpdate();
        }
    }

    // Menghapus kegiatan
    public void hapusKegiatan(int id) throws SQLException {
        String sql = "DELETE FROM kegiatan WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        }
    }
}

