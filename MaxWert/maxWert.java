int maxWert () { 
	 int integerNumber = 0;
	 int [] array1 = {3, 9, 7, 4, 11, 8, 5, 2};
	 for ( int intNumber = 0; intNumber< array1.length; ++intNumber) {
		if (array1[intNumber] > integerNumber) {
			integerNumber = array1[intNumber];	
		}
	 }
	return integerNumber;
}

maxWert ();


int [] sortArray () { 
	 int [] array1 = {9, 7, 4, 11, 8, 5, 2};
	 
	 for ( int intNumber = 0; intNumber< (array1.length) - 1; ++intNumber) {
		 int arrOriginal = 0;
		if (array1[intNumber] > array1[intNumber + 1]) {
			arrOriginal = array1[intNumber + 1];
			  array1[intNumber] = array1[intNumber + 1];
			array1[intNumber] = arrOriginal;		
		}
		else {
			return array1;
		}
	 }
	return array1;
}



int [] sortArray () { 
	 int [] array1 = {9, 7, 4, 11, 8, 5, 2};
	 
	 for ( int firstNumber = 0; firstNumber< (array1.length) - 1; ++firstNumber) {
		 for ( int secondNumber = 0;  secondNumber < array1.length - firstNumber - 1 ; ++secondNumber) {
			int array1Replace = 0;
			if (array1[firstNumber] > array1[secondNumber]) {
				array1Replace = array1[firstNumber];
				array1[firstNumber] = array1[secondNumber];
				array1[secondNumber] = array1Replace;			
			}
			
		}
	}
	return array1;
}


sortArray();

