import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class DistanceCheckerArray {

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
			int[] arr1 = new int[1000];
			int[] arr2 = new int[1000];
			
			int lineNumber = 0;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] values = line.split("\\s+");

                if (values.length == 2) {
                    
                        arr1[lineNumber] = Integer.parseInt(values[0]);
                        arr2[lineNumber] = Integer.parseInt(values[1]);
						lineNumber++;
                } else {
                    System.out.println("Invalid line format: " + line);
                    continue;
                }
            }
            scanner.close();


            int [] arry1 = sortArray(arr1);
            int [] arry2 = sortArray(arr2);

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
