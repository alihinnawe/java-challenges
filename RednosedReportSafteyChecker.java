import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.ArrayList;

class RednosedReportSafteyChecker {
    public static void main(String[] args) {
		try {
            int[][] reportSafetyResult = getSafeReportsCount();

            int maxColCount = 8;
            int safeCount = 0; 

            ArrayList<ArrayList<Integer>> differenceArray = new ArrayList<ArrayList<Integer>>();

            for (int i = 0; i < reportSafetyResult.length; ++i) {
                ArrayList<Integer> row = new ArrayList<Integer>();

                for (int j = 0; j < reportSafetyResult[i].length - 1; ++j) { 
                    int difference = reportSafetyResult[i][j] - reportSafetyResult[i][j + 1];
                    row.add(difference);
                }

                differenceArray.add(row);
            }

            System.out.println(differenceArray.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }
       
    }

    static int [][] getSafeReportsCount() throws FileNotFoundException {
        int safeReportsCount = 0;
        // laod the file 
        File file = new File("C:\\documents\\java-challenges\\input.txt");
        Scanner scanner = new Scanner(file);
        int linesCount = 0;
        // return number of array lines
        while (scanner.hasNextLine()) {
            scanner.nextLine();
            linesCount++;
        }
        scanner.close();

        scanner = new Scanner(file);
        // craete two dimensional array for report
        int[][] arr1 = new int[linesCount][];
        int lineNumber = 0;
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            // split each lineand create an array out of it.
            String[] values = line.split("\\s+");
            int[] intValues = new int[values.length];
            for (int i = 0; i < values.length; i++) {
                intValues[i] = Integer.parseInt(values[i]);
            }
            arr1[lineNumber] = intValues;
            //System.out.println("values of index " + lineNumber + " is " + Arrays.toString(intValues));
            lineNumber++;
        }
        scanner.close();
		//System.out.println("values of index " + lineNumber + " is " + arr1);
        
        return arr1;
    }
}
