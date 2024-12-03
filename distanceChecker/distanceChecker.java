import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class DistanceChecker {
    public static void main(String[] args) {
        try {
            File file = new File(".\\java\\input");
            Scanner scanner = new Scanner(file);
            int distanceSum = 0;
            ArrayList<Integer> arr1 = new ArrayList<>();
            ArrayList<Integer> arr2 = new ArrayList<>();

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] values = line.split("\\s+");

                if (values.length == 2) {
                    try {
                        int array1Value = Integer.parseInt(values[0]);
                        int array2Value = Integer.parseInt(values[1]);
                        arr1.add(array1Value);
                        arr2.add(array2Value);

                    } catch (NumberFormatException e) {
                        System.out.println("Invalid number format in line: " + line);
                        continue;
                    }
                } else {
                    System.out.println("Invalid line format: " + line);
                    continue;
                }
            }

            // Sort the arrays after reading all lines
            arr1.sort(null);
			System.out.println("sorted Array1: " + arr1);

            arr2.sort(null);
			System.out.println("sorted Array2: " + arr2);

            // Calculate the distance sum
            for (int i : arr1) { 
                for (int j : arr2) {
                    int distance = Math.abs(i - j);
                    distanceSum += distance;
                }   
            }

            System.out.println("Total distance value is: " + distanceSum);
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}
