import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;

int getFinalResult () {
	ArrayList<int> arr1 =  new ArrayList<int>();
	ArrayList<int> arr2 =  new ArrayList<int>();
	
	File file = new File("file source");
	Scanner scanner = new Scanner(file);
	
	while (scanner.hasNextLine()) {
		String line = scanner.nextLine();
		String[] values = line.split("\\s+");
		
		if (values.length == 2) {
			array1Value = Integer.parseInt(values[0]);
			arr1.add(array1Value);
			array2Value = Integer.parseInt(values[1]);
			arr2.add(array2Value);
		}
	}
	scanner.close();
	int finalResult = 0;
	for (int i = 0; i < arr1.length; ++i) {
		int indexCounter = 0;
		for (int j = 0; j < arr2.length; ++j) {
			if (array[i]  == array[j]) {
			indexCounter += 1;	
			finalResult = finalResult + array[i] * indexCounter;
			}	
		} 
	}
	return finalResult;
}