import java.io.*;
import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JCheckbox {

    public static void main(String[] args) throws ArrayIndexOutOfBoundsException, IOException {

        Vector<Integer> firstColumn = new Vector<>();
        Vector<String> secondColumn = new Vector<>();

        File file = new File("./keywords.java.txt");

        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            Scanner lineScanner = new Scanner(line);

            if (lineScanner.hasNextInt()) {
                int firstValue = lineScanner.nextInt();
                firstColumn.add(firstValue);
            }

            if (lineScanner.hasNext()) {
                String secondValue = lineScanner.next();
                secondColumn.add(secondValue);
            }

            lineScanner.close();
        }

        scanner.close();


    }
}
