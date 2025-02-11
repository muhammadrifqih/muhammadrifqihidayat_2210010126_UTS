/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package muhammadrifqihidayat_2210010126_uts;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts;

/**
 *
 * @author ASUS
 */
public class muhammadrifqihidayat_2210010126_UTSFrame extends javax.swing.JFrame {

    /**
     * Creates new form muhammadrifqihidayat_2210010126_UTSFrame
     *
     */
    private DatabaseHelper dbHelper;
    private KegiatanManager kegiatanManager;
    private int selectedId = -1; // Variabel untuk menyimpan ID kegiatan yang dipilih
    private List<Kegiatan> kegiatanList = new ArrayList<>();
    private SimpleDateFormat datePormat = new SimpleDateFormat("yyyy-MM-dd");

    public muhammadrifqihidayat_2210010126_UTSFrame() {
        initComponents();
        dbHelper = new DatabaseHelper();
        Connection conn = dbHelper.connect();
        kegiatanManager = new KegiatanManager(conn);
        loadKegiatan();

        // Menambahkan listener untuk meng-handle klik pada JList
        jList1.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) { // Pastikan pemilihan selesai
                int index = jList1.getSelectedIndex();
                if (index != -1) {
                    try {
                        Kegiatan selectedKegiatan = kegiatanList.get(index); // Ambil dari kegiatanList
                        // Isi data yang dipilih ke dalam form input
                        jTextField1.setText(selectedKegiatan.getNama());
                        jDateChooser1.setDate(datePormat.parse(selectedKegiatan.getTanggal()));
                        jTextField2.setText(selectedKegiatan.getJam());
                        jTextField3.setText(selectedKegiatan.getTempat());
                        jTextArea1.setText(selectedKegiatan.getDeskripsi());
                        // Simpan ID kegiatan yang dipilih untuk keperluan update
                        selectedId = selectedKegiatan.getId();
                    } catch (ParseException ex) {
                        Logger.getLogger(muhammadrifqihidayat_2210010126_UTSFrame.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });

    }
// Memperbarui tampilan list kegiatan

    private void loadKegiatan() {
        try {
            // Ambil list kegiatan dari database
            kegiatanList = kegiatanManager.getAllKegiatan();  // Menyimpan ke dalam kegiatanList

            // Ubah list menjadi array String untuk ditampilkan di JList
            String[] kegiatanArray = new String[kegiatanList.size()];
            for (int i = 0; i < kegiatanList.size(); i++) {
                Kegiatan kegiatan = kegiatanList.get(i);
                kegiatanArray[i] = "No: " + kegiatan.getId()
                        + ", Nama: " + kegiatan.getNama()
                        + ", Tanggal: " + kegiatan.getTanggal()
                        + ", Jam: " + kegiatan.getJam()
                        + ", Tempat: " + kegiatan.getTempat()
                        + ", Deskripsi: " + kegiatan.getDeskripsi();
            }
            jList1.setListData(kegiatanArray);  // Update JList dengan data yang baru
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

// Mengosongkan form input
    private void clearInputs() {
        jTextField1.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
        jTextArea1.setText("");
        jDateChooser1.setDate(null);
        selectedId = -1;  // Reset ID kegiatan yang dipilih
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.BorderLayout(2, 2));

        java.awt.GridBagLayout jPanel1Layout = new java.awt.GridBagLayout();
        jPanel1Layout.columnWidths = new int[] {0, 4, 0, 4, 0, 4, 0, 4, 0, 4, 0, 4, 0, 4, 0, 4, 0, 4, 0, 4, 0, 4, 0, 4, 0, 4, 0, 4, 0, 4, 0, 4, 0};
        jPanel1Layout.rowHeights = new int[] {0, 2, 0, 2, 0, 2, 0, 2, 0, 2, 0, 2, 0, 2, 0, 2, 0, 2, 0, 2, 0};
        jPanel1.setLayout(jPanel1Layout);

        jLabel1.setText("Nama Kegiatan");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanel1.add(jLabel1, gridBagConstraints);

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanel1.add(jTextField1, gridBagConstraints);

        jLabel2.setText("Tanggal Kegiatan ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanel1.add(jLabel2, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanel1.add(jDateChooser1, gridBagConstraints);

        jLabel3.setText("Jam Kegiatan");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanel1.add(jLabel3, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanel1.add(jTextField2, gridBagConstraints);

        jLabel4.setText("Tempat Kegiatan");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanel1.add(jLabel4, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanel1.add(jTextField3, gridBagConstraints);

        jLabel5.setText("Deskeripsi");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanel1.add(jLabel5, gridBagConstraints);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel1.add(jScrollPane1, gridBagConstraints);

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(jList1);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 16;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel1.add(jScrollPane2, gridBagConstraints);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/disk (1).png"))); // NOI18N
        jButton1.setText("Simpan");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/file-edit.png"))); // NOI18N
        jButton2.setText("Ubah");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/trash-xmark.png"))); // NOI18N
        jButton3.setText("Hapus");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3);

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/file-export.png"))); // NOI18N
        jButton4.setText("Export PDF");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton4);

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/file-import.png"))); // NOI18N
        jButton5.setText("Import CSV");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton5);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel1.add(jPanel2, gridBagConstraints);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel6.setText("APLIKASI CATATAN HARIAN");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        jPanel1.add(jLabel6, gridBagConstraints);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // Menyimpan kegiatan baru
        String nama = jTextField1.getText();
        String tanggal = jDateChooser1.getDate() != null ? datePormat.format(jDateChooser1.getDate()) : "";
        String jam = jTextField2.getText();
        String tempat = jTextField3.getText();
        String deskripsi = jTextArea1.getText();

        if (nama.isEmpty() || tanggal.isEmpty() || jam.isEmpty() || tempat.isEmpty() || deskripsi.isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(null, "Semua field harus diisi!");
        } else {
            try {
                Kegiatan kegiatan = new Kegiatan(0, nama, tanggal, jam, tempat, deskripsi);
                kegiatanManager.tambahKegiatan(kegiatan);
                javax.swing.JOptionPane.showMessageDialog(null, "Data berhasil disimpan!");
                clearInputs();
                loadKegiatan();
            } catch (SQLException e) {
                javax.swing.JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        // Cek apakah ada ID yang dipilih
        if (selectedId == -1) {
            javax.swing.JOptionPane.showMessageDialog(null, "Pilih kegiatan yang ingin diubah.");
            return;
        }

        // Ambil data dari input form
        String nama = jTextField1.getText();
        String tanggal = jDateChooser1.getDate() != null ? jDateChooser1.getDate().toString() : "";
        String jam = jTextField2.getText();
        String tempat = jTextField3.getText();
        String deskripsi = jTextArea1.getText();

        // Validasi data
        if (nama.isEmpty() || tanggal.isEmpty() || jam.isEmpty() || tempat.isEmpty() || deskripsi.isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(null, "Semua field harus diisi!");
        } else {
            try {
                // Buat objek Kegiatan baru dengan data yang telah diubah
                Kegiatan kegiatan = new Kegiatan(selectedId, nama, datePormat.format(jDateChooser1.getDate()), jam, tempat, deskripsi);
                // Panggil metode untuk mengubah kegiatan di database
                kegiatanManager.ubahKegiatan(kegiatan);
                javax.swing.JOptionPane.showMessageDialog(null, "Data kegiatan berhasil diubah!");
                loadKegiatan();  // Refresh list kegiatan
                clearInputs();   // Kosongkan form input
            } catch (SQLException e) {
                javax.swing.JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed


    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // Cek apakah ada ID yang dipilih
        if (selectedId == -1) {
            javax.swing.JOptionPane.showMessageDialog(null, "Pilih kegiatan yang ingin dihapus.");
            return;
        }

// Tampilkan konfirmasi penghapusan
        int confirm = javax.swing.JOptionPane.showConfirmDialog(null,
                "Apakah Anda yakin ingin menghapus kegiatan ini?",
                "Konfirmasi Hapus",
                javax.swing.JOptionPane.YES_NO_OPTION);

        if (confirm == javax.swing.JOptionPane.YES_OPTION) {
            try {
                // Panggil metode untuk menghapus kegiatan di database
                kegiatanManager.hapusKegiatan(selectedId);
                javax.swing.JOptionPane.showMessageDialog(null, "Kegiatan berhasil dihapus!");
                loadKegiatan();  // Refresh list kegiatan
                clearInputs();   // Kosongkan form input setelah penghapusan (opsional)
            } catch (SQLException e) {
                javax.swing.JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            }
        }

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
          // Membuka JFileChooser untuk memilih lokasi dan nama file PDF
    JFileChooser fileChooser = new JFileChooser();
    fileChooser.setDialogTitle("Pilih Lokasi untuk Menyimpan File PDF");
    fileChooser.setSelectedFile(new File("kegiatan.pdf")); // Set default file name

    // Menampilkan dialog penyimpanan
    int result = fileChooser.showSaveDialog(null);

    if (result == JFileChooser.APPROVE_OPTION) {
        // Mendapatkan path file yang dipilih oleh pengguna
        File file = fileChooser.getSelectedFile();

        // Pastikan file memiliki ekstensi .pdf
        if (!file.getName().endsWith(".pdf")) {
            file = new File(file.getAbsolutePath() + ".pdf");
        }

        // Membuat dokumen PDF
        try (PDDocument document = new PDDocument()) {
            PDPage page = new PDPage();
            document.addPage(page);
            PDPageContentStream contentStream = new PDPageContentStream(document, page);

            contentStream.beginText();
             contentStream.setFont(new PDType1Font(Standard14Fonts.FontName.HELVETICA_BOLD), 12);
            contentStream.newLineAtOffset(100, 750); // Posisi awal untuk teks

            // Menulis header
            contentStream.showText("Laporan Kegiatan");
            contentStream.newLineAtOffset(0, -20);

            // Menghitung posisi vertikal teks
            float yPosition = 730;  // Dimulai dari 750 - 20 untuk header

            // Menambahkan data kegiatan ke PDF
            for (Kegiatan kegiatan : kegiatanList) {
                if (yPosition <= 50) { // Jika posisi mendekati bawah halaman
                    contentStream.endText();
                    contentStream.close();
                    // Menambahkan halaman baru
                    page = new PDPage();
                    document.addPage(page);
                    contentStream = new PDPageContentStream(document, page);
                    contentStream.beginText();
                     contentStream.setFont(new PDType1Font(Standard14Fonts.FontName.HELVETICA_BOLD), 12);
                    contentStream.newLineAtOffset(100, 750); // Mulai lagi dari atas halaman
                    yPosition = 730; // Reset posisi y
                }

                // Menulis data kegiatan
                contentStream.showText("No: " + kegiatan.getId());
                contentStream.newLineAtOffset(0, -15);
                contentStream.showText("Nama: " + kegiatan.getNama());
                contentStream.newLineAtOffset(0, -15);
                contentStream.showText("Tanggal: " + kegiatan.getTanggal());
                contentStream.newLineAtOffset(0, -15);
                contentStream.showText("Jam: " + kegiatan.getJam());
                contentStream.newLineAtOffset(0, -15);
                contentStream.showText("Tempat: " + kegiatan.getTempat());
                contentStream.newLineAtOffset(0, -15);
                contentStream.showText("Deskripsi: " + kegiatan.getDeskripsi());
                contentStream.newLineAtOffset(0, -30);

                // Update posisi y
                yPosition -= 100;  // Menurunkan posisi untuk data berikutnya
            }

            contentStream.endText();
            contentStream.close();

            // Menyimpan dokumen ke file PDF
            document.save(file);
            JOptionPane.showMessageDialog(null, "File PDF berhasil disimpan di: " + file.getAbsolutePath());

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan saat menyimpan file PDF: " + e.getMessage());
        }
    }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        // Open file chooser for CSV file
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Pilih File CSV");
        // Add filter to only show .csv files
        FileNameExtensionFilter filter = new FileNameExtensionFilter("CSV Files", "csv");
        fileChooser.setFileFilter(filter);
        int result = fileChooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            // Get the selected file
            File selectedFile = fileChooser.getSelectedFile();
            String filePath = selectedFile.getAbsolutePath();

            // Instantiate CSVImporter and import data
            CSVImporter csvImporter = new CSVImporter();
            List<Kegiatan> kegiatanList = csvImporter.importCSV(filePath);

            // Process the imported data
            for (Kegiatan kegiatan : kegiatanList) {
                try {
                    // You can either add the data to the list in the GUI or directly to the database.
                    kegiatanManager.tambahKegiatan(kegiatan);
                } catch (SQLException ex) {
                    Logger.getLogger(muhammadrifqihidayat_2210010126_UTSFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            // Refresh the list
            loadKegiatan();

            // Show confirmation message
            JOptionPane.showMessageDialog(null, "Data berhasil diimpor dari CSV!");
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows Classic".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(muhammadrifqihidayat_2210010126_UTSFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(muhammadrifqihidayat_2210010126_UTSFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(muhammadrifqihidayat_2210010126_UTSFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(muhammadrifqihidayat_2210010126_UTSFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new muhammadrifqihidayat_2210010126_UTSFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables
}
