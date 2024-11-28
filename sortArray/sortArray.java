 int [] sortArray () { 
	 int [] array1 = {9, 7, 4, 11, 8, 5, 2};
	 
	 for ( int firstNumber = 0; firstNumber< (array1.length) - 1; ++firstNumber) {
		 for ( int secondNumber = 0;  secondNumber < array1.length - 1 -firstNumber ; ++secondNumber) {
			int arrayReplace = 0;
			if (array1[firstNumber] > array1[secondNumber]) {
				arrayReplace = array1[firstNumber];
				array1[firstNumber] = array1[secondNumber];
				array1[secondNumber] = arrayReplace;			
			}
			
		}
	}
	return array1;
}

sortArray();
