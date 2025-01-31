import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.ArrayList;

public class Replacer extends JFrame implements Runnable {
    static int argsbtnsNumber, textFieldsNumber, argstextAreaNumber, pnNumber;

    private JPanel mainPanel1, mainPanel2, cardPanel;
    private CardLayout cardLayout;

    List<JButton> buttons1 = new ArrayList<>(); // Buttons for mainPanel1
    List<JButton> buttons2 = new ArrayList<>(); // Buttons for mainPanel2
    List<JTextField> textFields1 = new ArrayList<>(); // Text fields for mainPanel1
    List<JTextField> textFields2 = new ArrayList<>(); // Text fields for mainPanel2
    List<JTextArea> textAreas1 = new ArrayList<>(); // Text areas for mainPanel1
    List<JTextArea> textAreas2 = new ArrayList<>(); // Text areas for mainPanel2

    public void run() {
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        mainPanel1 = new JPanel();
        mainPanel1.setLayout(new BorderLayout());

        mainPanel2 = new JPanel();
        mainPanel2.setLayout(new BorderLayout());

        // Add text fields for mainPanel1
        for (int i = 0; i < textFieldsNumber; i++) {
            JTextField textField = new JTextField();
            textField.setColumns(10);
            if (i == 0) {
                textField.setText("(.)(.*)");
            } else if (i == 1) {
                textField.setText("$1$2");
            } else {
                textField.setText("textField" + i);
            }
            textFields1.add(textField);
        }

        // Add text fields for mainPanel2
        for (int i = 0; i < textFieldsNumber; i++) {
            JTextField textField = new JTextField();
            textField.setColumns(10);
            if (i == 0) {
                textField.setText("(.)(.*)");
            } else if (i == 1) {
                textField.setText("$1$2");
            } else {
                textField.setText("textField" + i);
            }
            textFields2.add(textField);
        }

        // Add buttons for mainPanel1
        for (int i = 0; i < argsbtnsNumber; i++) {
            JButton button;
            switch (i) {
                case 0:
                    button = new JButton("open");
                    break;
                case 1:
                    button = new JButton("save");
                    break;
                case 2:
                    button = new JButton("exit");
                    break;
                case 3:
                    button = new JButton("run");
                    break;
                case 4:
                    button = new JButton("filter");
                    break;
                default:
                    button = new JButton("button" + i);
                    break;
            }
            button.addActionListener(new NewActionListener(button, textFields1, textFields2, textAreas1, textAreas2, cardLayout, cardPanel));
            buttons1.add(button);
        }

        // Add buttons for mainPanel2
        for (int i = 0; i < argsbtnsNumber; i++) {
            JButton button;
            switch (i) {
                case 0:
                    button = new JButton("open");
                    break;
                case 1:
                    button = new JButton("save");
                    break;
                case 2:
                    button = new JButton("exit");
                    break;
                case 3:
                    button = new JButton("run");
                    break;
                case 4:
                    button = new JButton("filter");
                    break;
                default:
                    button = new JButton("button" + i);
                    break;
            }
            button.addActionListener(new NewActionListener(button, textFields1, textFields2, textAreas1, textAreas2, cardLayout, cardPanel));
            buttons2.add(button);
        }

        // Add text areas for mainPanel1
        for (int i = 0; i < argstextAreaNumber; i++) {
            JTextArea textArea = new JTextArea();
            textAreas1.add(textArea);
        }

        // Add text areas for mainPanel2
        for (int i = 0; i < argstextAreaNumber; i++) {
            JTextArea textArea = new JTextArea();
            textAreas2.add(textArea);
        }

        // Add components to mainPanel1 (Replacement Panel)
        // North: open, save, exit buttons
        JPanel northPanel1 = new JPanel();
        for (int i = 0; i < 3; i++) { // Add open, save, exit buttons
            northPanel1.add(buttons1.get(i));
        }
        mainPanel1.add(northPanel1, BorderLayout.NORTH);

        // Center: left and right JTextArea
        JPanel centerPanel1 = new JPanel();
        centerPanel1.setLayout(new BoxLayout(centerPanel1, BoxLayout.X_AXIS));

        JTextArea leftTextArea1 = textAreas1.get(0);
        leftTextArea1.setRows(10);
        leftTextArea1.setColumns(30);
        leftTextArea1.setEditable(false);
        leftTextArea1.setLineWrap(false);
        leftTextArea1.setWrapStyleWord(false);
        JScrollPane leftScroll1 = new JScrollPane(leftTextArea1);
        leftScroll1.setPreferredSize(new Dimension(250, 200));

        JTextArea rightTextArea1 = textAreas1.get(1);
        rightTextArea1.setRows(10);
        rightTextArea1.setColumns(30);
        rightTextArea1.setEditable(false);
        rightTextArea1.setLineWrap(false);
        rightTextArea1.setWrapStyleWord(false);
        JScrollPane rightScroll1 = new JScrollPane(rightTextArea1);
        rightScroll1.setPreferredSize(new Dimension(250, 200));

        centerPanel1.add(leftScroll1);
        centerPanel1.add(rightScroll1);
        mainPanel1.add(centerPanel1, BorderLayout.CENTER);

        // South: run button and two text fields
        JPanel southPanel1 = new JPanel();
        southPanel1.add(buttons1.get(3)); // run button
        southPanel1.add(textFields1.get(0)); // first text field
        southPanel1.add(textFields1.get(1)); // second text field
        mainPanel1.add(southPanel1, BorderLayout.SOUTH);

        // Add components to mainPanel2 (Filter Panel)
        // North: open, save, exit buttons
        JPanel northPanel2 = new JPanel();
        for (int i = 0; i < 3; i++) { // Add open, save, exit buttons
            northPanel2.add(buttons2.get(i));
        }
        mainPanel2.add(northPanel2, BorderLayout.NORTH);

        // Center: left and right JTextArea
        JPanel centerPanel2 = new JPanel();
        centerPanel2.setLayout(new BoxLayout(centerPanel2, BoxLayout.X_AXIS));

        JTextArea leftTextArea2 = textAreas2.get(0);
        leftTextArea2.setRows(10);
        leftTextArea2.setColumns(30);
        leftTextArea2.setEditable(false);
        leftTextArea2.setLineWrap(false);
        leftTextArea2.setWrapStyleWord(false);
        JScrollPane leftScroll2 = new JScrollPane(leftTextArea2);
        leftScroll2.setPreferredSize(new Dimension(250, 200));

        JTextArea rightTextArea2 = textAreas2.get(1);
        rightTextArea2.setRows(10);
        rightTextArea2.setColumns(30);
        rightTextArea2.setEditable(false);
        rightTextArea2.setLineWrap(false);
        rightTextArea2.setWrapStyleWord(false);
        JScrollPane rightScroll2 = new JScrollPane(rightTextArea2);
        rightScroll2.setPreferredSize(new Dimension(250, 200));

        centerPanel2.add(leftScroll2);
        centerPanel2.add(rightScroll2);
        mainPanel2.add(centerPanel2, BorderLayout.CENTER);

        // South: filter button and first text field
        JPanel southPanel2 = new JPanel();
        southPanel2.add(buttons2.get(4)); // filter button
        southPanel2.add(textFields2.get(0)); // first text field
        mainPanel2.add(southPanel2, BorderLayout.SOUTH);

        // Add panels to cardPanel
        cardPanel.add(mainPanel1, "Replacement Panel");
        cardPanel.add(mainPanel2, "Filter Panel");

        // Set the default panel to Replacement Panel
        cardLayout.show(cardPanel, "Filter Panel");

        // Set up the JFrame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600); // Set a reasonable size for the frame
        setVisible(true);
        add(cardPanel);
    }

    public static void main(String[] args) {
        if (args.length == 0) {
            System.exit(1);
        } else {
            for (int i = 0; i <= args.length - 1; i++) {
                String[] newArgs = args[i].split("-");
                switch (newArgs[0]) {
                    case "btn":
                        argsbtnsNumber = Integer.parseInt(newArgs[1]);
                        break;
                    case "txtF":
                        textFieldsNumber = Integer.parseInt(newArgs[1]);
                        break;
                    case "txtA":
                        argstextAreaNumber = Integer.parseInt(newArgs[1]);
                        break;
                    case "pn":
                        pnNumber = Integer.parseInt(newArgs[1]);
                        break;
                    default:
                        return;
                }
            }
        }
        SwingUtilities.invokeLater(new Replacer());
    }
}
