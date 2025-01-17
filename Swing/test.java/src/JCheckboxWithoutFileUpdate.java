import java.io.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;

public class JCheckboxWithoutFileUpdate extends JFrame {

    private Vector<Integer> firstColumn;
    private Vector<String> secondColumn;
    private JPanel checkBoxPanel;
	private JButton updateButton;
	private JPanel buttonPanel;
	
    public JCheckboxWithoutFileUpdate(String title) {
        super(title);
        firstColumn = new Vector<>();
        secondColumn = new Vector<>();
        checkBoxPanel = new JPanel();
		buttonPanel = new JPanel();
		updateButton = new JButton("update");
		buttonPanel.add(updateButton);
        checkBoxPanel.setLayout(new BoxLayout(checkBoxPanel, BoxLayout.Y_AXIS));
		add(buttonPanel, BorderLayout.SOUTH);
        readFile();

        for (String word : secondColumn) {
            JCheckBox checkBox = new JCheckBox(word);
            checkBoxPanel.add(checkBox);
        }

        add(new JScrollPane(checkBoxPanel), BorderLayout.CENTER);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void readFile() {
        File file = new File("./keywords.java.txt");
        try (Scanner scanner = new Scanner(file)) {
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
        } catch (FileNotFoundException e) {
            System.exit(1);
        }
    }
	
	public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new JCheckboxWithoutFileUpdate("JCheckbox Example"));
    }

}
