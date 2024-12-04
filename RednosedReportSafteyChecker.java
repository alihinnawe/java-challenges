import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.ArrayList;

class RednosedReportSafteyChecker {
    public static void main(String[] args) {
        try {
            int [][] reportSafetyResult = getSafeReportsCount();
			int maxColCount = 8;
			int finalCount = 0;
			for (int i  = 0 ; i<reportSafetyResult.length; ++i) {
				ArrayList<Integer> differenceArray = new ArrayList<Integer>();            
				for (int j = 0; j< reportSafetyResult[i].length -1;++j) {	
					int difference = reportSafetyResult[i][j] - reportSafetyResult[i][j+1];
					differenceArray.add(difference);
					
				}
				//System.out.println(differenceArray.toString());
				//TODO
				boolean allPositive = true;
				for (int num : differenceArray) {
					if (num <= 0) {
						allPositive = false;
						break;
					}
				}
				System.out.println("All numbers are positive: " + allPositive);
			} } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        }
    }

    static int [][] getSafeReportsCount() throws FileNotFoundException {
        int safeReportsCount = 0;
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
            //System.out.println("values of index " + lineNumber + " is " + Arrays.toString(intValues));
            lineNumber++;
        }
        scanner.close();
		//System.out.println("values of index " + lineNumber + " is " + arr1);
        
        return arr1;
    }
}
