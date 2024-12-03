import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class DistanceChecker {

    static int[] sortArray(int[] array) {
        for (int firstNumber = 0; firstNumber < array.length - 1; ++firstNumber) {
            for (int secondNumber = 0; secondNumber < array.length - 1 - firstNumber; ++secondNumber) {
                if (array[firstNumber] > array[secondNumber]) {
                    int arrayReplace = array[firstNumber];
                    array[firstNumber] = array[secondNumber];
                    array[secondNumber] = arrayReplace;
                }
            }
        }
        return array;
    }

    public static void main(String[] args) throws FileNotFoundException {
        int result = getFinalResult();
        System.out.println("Final Result: " + result);
    }

    public static int getFinalResult() {
        int distanceSum = 0; 

        try {
            File file = new File("C:\\documents\\java-challenges\\distanceChecker\\input1.txt");
            Scanner scanner = new Scanner(file);
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
            scanner.close();

            int[] arry1 = new int[arr1.size()];
            int[] arry2 = new int[arr2.size()];

            for (int i = 0; i < arr1.size(); i++) {
                arry1[i] = arr1.get(i);
            }

            for (int i = 0; i < arr2.size(); i++) {
                arry2[i] = arr2.get(i);
            }

            arry1 = sortArray(arry1);
            arry2 = sortArray(arry2);

            for (int i : arry1) {
                for (int j : arry2) {
                    int distance = Math.abs(i - j);
                    distanceSum += distance;
                }
            }
            return distanceSum;
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
            return 0; 
        }
    }
}
