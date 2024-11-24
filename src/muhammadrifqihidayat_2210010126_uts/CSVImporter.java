/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package muhammadrifqihidayat_2210010126_uts;

/**
 *
 * @author ASUS
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVImporter {

    public List<Kegiatan> importCSV(String filePath) {
        List<Kegiatan> kegiatanList = new ArrayList<>();
        String line;
        String csvSplitBy = ","; // Assuming CSV is comma-separated
        
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            // Skip the header if it exists
            br.readLine();

            // Read each line from CSV
            while ((line = br.readLine()) != null) {
                // Split by comma
                String[] data = line.split(csvSplitBy);

                // Create Kegiatan object and populate with data
                Kegiatan kegiatan = new Kegiatan(
                    Integer.parseInt(data[0]),  // ID
                    data[1],  // Name
                    data[2],  // Date
                    data[3],  // Time
                    data[4],  // Location
                    data[5]   // Description
                );

                // Add to the list
                kegiatanList.add(kegiatan);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return kegiatanList;
    }
}
