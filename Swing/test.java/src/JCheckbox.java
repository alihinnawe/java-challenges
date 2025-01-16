import java.io.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JCheckbox extends JFrame {

    private Vector<Integer> firstColumn;
    private Vector<String> secondColumn;
    private JPanel checkBoxPanel;
    private JButton updateButton;

    public JCheckbox(String title) {
        super(title);
        firstColumn = new Vector<>();
        secondColumn = new Vector<>();
        checkBoxPanel = new JPanel();
        checkBoxPanel.setLayout(new BoxLayout(checkBoxPanel, BoxLayout.Y_AXIS));

        readFile();

        for (int i = 0; i < secondColumn.size(); i++) {
            JCheckBox checkBox = new JCheckBox(secondColumn.get(i));
            checkBoxPanel.add(checkBox);
        }

        updateButton = new JButton("Update");
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateFile();
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(updateButton);

        add(new JScrollPane(checkBoxPanel), BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

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
            e.printStackTrace();
        }
    }

    private void updateFile() {
        File file = new File("./keywords.java.txt");
        try (PrintWriter writer = new PrintWriter(file)) {
            for (int i = 0; i < checkBoxPanel.getComponentCount(); i++) {
                JCheckBox checkBox = (JCheckBox) checkBoxPanel.getComponent(i);
                if (checkBox.isSelected()) {
                    firstColumn.set(i, 1);
                } else {
                    firstColumn.set(i, 0);
                }
                writer.println(firstColumn.get(i) + " " + secondColumn.get(i));
            }
            JOptionPane.showMessageDialog(this, "File updated successfully!");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new JCheckbox("JCheckbox Example"));
    }
}
