import java.io.*;
import java.util.*;

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

        // Print the vectors to verify the contents
        System.out.println("First Column (Integers): " + firstColumn);
        System.out.println("Second Column (Keywords): " + secondColumn);
    }
}
