void distributive(int[] arr) {
    int counter = 0;
    for (int i = 0; i < arr.length - 2; ++i) {
        for (int j = i + 1; j < arr.length - 1; ++j) {
            for (int k = j + 1; k < arr.length; ++k) {
                int leftSideMultiplication = arr[i] * (arr[j] + arr[k]);
                int rightSideMultiplication = arr[i] * arr[j] + arr[i] * arr[k];
                if (leftSideMultiplication == rightSideMultiplication) {
                    System.out.println("The result is CORRECT");
                }
                counter++;
            }
        }
    }
    System.out.println("numbe iterations: " + counter);
}

distributive(arr);