package p1_Memory_vs_Disk;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class problem2_csv_read {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        String fileName = "src/p1_Memory_vs_Disk/random_numbers.csv";
        long sum = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line = reader.readLine();
            String[] numbers = line.split(",");

            for (String number : numbers) {
                sum += Integer.parseInt(number);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        long endTime = System.currentTimeMillis();
        System.out.println("Total sum from CSV: " + sum);
        System.out.println("CSV reading and sum calculation time: " + (endTime - startTime) + " ms"); //770~820ms 사이
    }
}
