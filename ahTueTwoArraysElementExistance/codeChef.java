import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;

int getFinalResult () {

	File file = new File("C:\\Users\\hinnawe.ali\\Documents\\java-challanges\\ahTueTwoArraysComp\\input1");
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
	System.out.println("array1 is: " + arr1);
	for (int i = 0; i < arr1.size(); ++i) {
		int indexCounter = 0;
		for (int j = 0; j < arr2.size(); ++j) {
			if (arr1.get(i) == arr2.get(j)) {
				indexCounter += 1;	
				finalResult = finalResult + (arr1.get(i) * indexCounter);
			}	
		} 
	}
	return finalResult;
}
