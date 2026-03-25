import java.io.*;
import java.util.*;

public class LogAnalyzer {

    public static void main(String[] args) {
        String filePath = "logs.txt";

        int errorCount = 0;
        int exceptionCount = 0;
        int timeoutCount = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = br.readLine()) != null) {
                if (line.contains("ERROR")) {
                    errorCount++;
                }
                if (line.contains("Exception")) {
                    exceptionCount++;
                }
                if (line.contains("timeout")) {
                    timeoutCount++;
                }
            }

            System.out.println("=== Log Analysis Report ===");
            System.out.println("Total Errors: " + errorCount);
            System.out.println("Exceptions: " + exceptionCount);
            System.out.println("Timeout Issues: " + timeoutCount);

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
