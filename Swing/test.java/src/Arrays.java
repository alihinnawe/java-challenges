import javax.swing.*;
import java.util.List;
import java.util.ArrayList;

public class Arrays {
    public Arrays() {
        List<Integer> array1 = new ArrayList<>();
        List<Integer> array2 = new ArrayList<>();
        List<Integer> array3 = new ArrayList<>();
        int [] array4 = {11,12,13};
        int [] array5 = {14,15,16};
        int[] array6 = new int[array4.length + array5.length];
        int newList = array3.get(0);
        System.out.println(newList);
        array1.add(3);
        array1.add(4);
        array1.add(5);
///////////////////////////////////////////////////////////////
        array2.add(6);
        array2.add(7);
        array2.add(8);


        for (int i : array1) {
            array3.add(i);
        }
        for (int i : array2) {
            array3.add(i);
        }

        for (int i = 0 ; i <array4.length ; i++) {
            array3.add(i);
        }

        for (int i = 0 ; i <array4.length ; i++) {
            array6[i] = array4[i];
        }
        for (int i = 0 ; i <array5.length ; i++) {
            array6[i+3] = array5[i];
        }
array6[3] = 20;


        //System.out.print(array3);
        //System.out.print(array6);

        for (int i: array6){

            System.out.println(i);
        }

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Arrays());
    }
}