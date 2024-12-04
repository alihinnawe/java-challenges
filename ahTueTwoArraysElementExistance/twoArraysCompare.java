import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Codechef {
    public static void main(String[] args) throws FileNotFoundException {
        int result = getFinalResult();
        System.out.println("Final Result: " + result);
    }

    public static int getFinalResult() throws FileNotFoundException {
        File file = new File("C:\\documents\\java-challenges\\ahTueTwoArraysElementExistance\\input1.txt");
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
            }
        }
        scanner.close();

        int finalResult = 0;

        for (int i = 0; i < lineNumber; ++i) {
            int indexCounter = 0;
            for (int j = 0; j < lineNumber; ++j) {
                if (arr1[i] == arr2[j]) {
                    indexCounter += 1;
                }
            }
            finalResult += (arr1[i] * indexCounter);
        }

        return finalResult;
    }
}
