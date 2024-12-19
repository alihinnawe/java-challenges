import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;

class RednosedReportSafteyChecker {
    public static void main(String[] args) {
        try {
            int[][] reportSafetyResult = getSafeReportsCount();

            int safeCount = 0; 
            int[][] differenceArray = new int[1000][];
            int lineNumber = 0;

            for (int i = 0; i < reportSafetyResult.length; ++i) {
                int[] row = new int[reportSafetyResult[i].length - 1];

                for (int j = 0; j < reportSafetyResult[i].length - 1; ++j) { 
                    int difference = reportSafetyResult[i][j] - reportSafetyResult[i][j + 1];
                    row[j] = difference;
                }
                System.out.println("row: " + Arrays.toString(row));
                differenceArray[lineNumber] = row;
                ++lineNumber;
            }

            for (int i = 0; i < differenceArray.length && differenceArray[i]; ++i) { // Added null check for safety
                boolean allSameSign = true;
                boolean withinBounds = true;
                boolean isPositive = differenceArray[i][0] > 0;

                for (int j = 0; j < differenceArray[i].length; ++j) {
                    if (Math.abs(differenceArray[i][j]) < 1 || Math.abs(differenceArray[i][j]) > 3) {
                        withinBounds = false;
                        break; // Stop further checks if out of bounds
                    }
                    if ((differenceArray[i][j] > 0) != isPositive) {
                        allSameSign = false;
                        break; // Stop further checks if not all same sign
                    }
                }

                if (allSameSign && withinBounds) {
                    ++safeCount;
                }
            }

            System.out.println("safeCount is: " + safeCount);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static int[][] getSafeReportsCount() throws FileNotFoundException {
        File file = new File("C:\\documents\\java-challenges\\input.txt");
        Scanner scanner = new Scanner(file);
        int linesCount = 0;

        while (scanner.hasNextLine()) {
            scanner.nextLine();
            linesCount++;
        }
        scanner.close();

        scanner = new Scanner(file);
        int[][] arr1 = new int[linesCount][];
        int lineNumber = 0;

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] values = line.split("\\s+");
            int[] intValues = new int[values.length];
            for (int i = 0; i < values.length; i++) {
                intValues[i] = Integer.parseInt(values[i]);
            }
            arr1[lineNumber] = intValues;
            lineNumber++;
        }
        scanner.close();

        return arr1;
    }
}