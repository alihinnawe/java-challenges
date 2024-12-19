void addition(int[] arr) {
    int counter = 0;
    for (int i = 0; i < arr.length - 1; ++i) {
        for (int j = i + 1; j < arr.length; ++j) {
                int leftSideAddition = arr[i] + arr[j];
                int rightSideAddition = arr[j] + arr[i];
                if (leftSideAddition == rightSideAddition) {
                    System.out.println("The result is CORRECT" + leftSideAddition + ", " + rightSideAddition);
                }
                counter++;
		}
	}
	System.out.println("numbe iterations: " + counter);
}


addition(arr);