import java.io.*;
import java.util.*;

public class deadlock_detection {
    public static void main(String[] args) {
        System.out.println("Program Deadlock Detection");
        System.out.println("Dataset dibaca dari dataset_deadlock.csv");

        // Contoh: baca file CSV
        try (BufferedReader br = new BufferedReader(new FileReader("dataset_deadlock.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Gagal membaca dataset");
        }
    }
}
