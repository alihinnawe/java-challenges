import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;
import java.io.FileNotFoundException; 



public class Codechef {
    public static void main(String[] args) throws FileNotFoundException {
        int result = getFinalResult();
        System.out.println("Final Result: " + result);
    }

    public static int getFinalResult() throws FileNotFoundException {
        File file = new File("C:\\documents\\java-challenges\\ahTueTwoArraysElementExistance\\input1.txt");
        Scanner scanner = new Scanner(file);

		ArrayList<Integer> arr1 = new ArrayList<>();
        ArrayList<Integer> arr2 = new ArrayList<>();
        
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] values = line.split("\\s+");
            
            if (values.length == 2) {
                int array1Value = Integer.parseInt(values[0]);
                arr1.add(array1Value);
                int array2Value = Integer.parseInt(values[1]);
                arr2.add(array2Value);
            }
        }
        scanner.close();

        int finalResult = 0;

        for (int i = 0; i < arr1.size(); ++i) {
            int indexCounter = 0;
            for (int j = 0; j < arr2.size(); ++j) {
                if (arr1.get(i).equals(arr2.get(j))) {
                    indexCounter += 1;    
                }
            }
            finalResult += (arr1.get(i) * indexCounter);
        }

        return finalResult;
    }
}
