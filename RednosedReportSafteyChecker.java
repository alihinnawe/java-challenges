import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.ArrayList;

class RednosedReportSafteyChecker {
    public static void main(String[] args) {
        try {
			// show all reports in the input.txt
            int [][] reportSafetyResult = getSafeReportsCount();
			//System.out.println(Arrays.toString(reportSafetyResult[1]));

			int maxColCount = 8;
			int safeCount = 0; 
			for (int i  = 0 ; i<reportSafetyResult.length; ++i) {
				//System.out.println(Arrays.toString(reportSafetyResult[i]));
				//TODO 
				ArrayList<ArrayList<Integer>> differenceArray = new ArrayList<ArrayList<Integer>>();
				//ArrayList<Integer> row = new ArrayList<Integer>();				          
				for (int j = 0; j< reportSafetyResult[i].length -1;++j) {	
					int difference = reportSafetyResult[i][j] - reportSafetyResult[i][j+1];
					differenceArray[i][].add(difference);
				}
				//differenceArray.add(row);
				System.out.println(differenceArray.toString());
				//TODO
				/*
				boolean allPositive = true;
				boolean allNegative = true;
				boolean safe =  true;
				for (int num : differenceArray) {
					if (num < 0 && num >= -3) {
						allPositive = false;
						safe = false;
					}
					else if (num > 0 && num >= 3) {
						allNegative = false;
						safe = false;
					}
					else {
						safe = true;
						++safeCount;}
				}
				
				//System.out.println("safeCount: " + safeCount);
				 */
			} } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
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
