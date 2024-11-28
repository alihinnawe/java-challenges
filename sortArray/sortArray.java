import java.util.Arrays;

int[] sortArray() {
    int[] array1 = {3, 7, 4, 11, 8, 5, 2};
    int counter = 0;

    for (int firstNumber = 0; firstNumber < array1.length - 1; ++firstNumber) {
        System.out.println("counter: " + counter);
        for (int secondNumber = 0; secondNumber < array1.length - 1 - firstNumber; ++secondNumber) {
            if (array1[secondNumber] > array1[secondNumber + 1]) {
                int arrayReplace = array1[secondNumber];
                array1[secondNumber] = array1[secondNumber + 1];
                array1[secondNumber + 1] = arrayReplace;
                System.out.println(Arrays.toString(array1));
            }
        }
        counter++;
    }
    return array1;
}

System.out.println(Arrays.toString(sortArray()));
