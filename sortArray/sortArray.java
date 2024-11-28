import java.util.Arrays;
int [] sortArray () { 
	 int [] array1 = {3, 7, 4, 11, 8, 5, 2};
	 
	 for ( int firstNumber = 0; firstNumber< (array1.length) - 1; ++firstNumber) {
		 for ( int secondNumber = 0;  secondNumber < array1.length - 1 -firstNumber ; ++secondNumber) {
			int arrayReplace = 0;
			if (array1[firstNumber] > array1[secondNumber]) {
				arrayReplace = array1[firstNumber];
				System.out.println(arrayReplace);
				array1[firstNumber] = array1[secondNumber];
				System.out.println(array1[firstNumber]);
				array1[secondNumber] = arrayReplace;
				System.out.println(array1[secondNumber]);
				System.out.println(Arrays.toString(array1));
			
			}
			
		}
	}
	return array1;
}

sortArray();
