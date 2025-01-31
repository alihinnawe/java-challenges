import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * A Swing application for performing regular expression operations on text files.
 * Allows users to open text files, perform find/replace operations, filter matches,
 * and save results to new files.
 *
 * @author Vadim S
 */
public class RegexApp extends JFrame {
    JPanel topPanel, centerPanel, replacePanel;
    JButton openButton, saveButton, exitButton, replaceButton, filterButton;
    JTextArea textArea1, textArea2;
    JTextField findField, replaceField;
    ResourceBundle resourceBundle = ResourceBundle.getBundle("RegexApp");

    /**
     * Constructs the RegexApp and initializes the user interface.
     */
    public RegexApp(){initUI();}

    /**
     * Initializes the application's user interface components.
     * Creates and arranges buttons, text areas, and panels using BorderLayout.
     */
    private void initUI() {
        setLayout(new BorderLayout());

        //Top panel with Open, Save, and Exit buttons
        openButton = new JButton(resourceBundle.getString("Open"));
        saveButton = new JButton(resourceBundle.getString("Save"));
        exitButton = new JButton(resourceBundle.getString("Exit"));

        openButton.addActionListener(e -> openFile());
        saveButton.addActionListener(e -> saveFile());
        exitButton.addActionListener(e -> System.exit(0));

        topPanel = new JPanel();
        topPanel.add(openButton);
        topPanel.add(saveButton);
        topPanel.add(exitButton);

        // Text areas
        textArea1 = new JTextArea();
        textArea2 = new JTextArea();

        textArea1.setFont(new Font("SansSerif", Font.PLAIN, 18));
        textArea2.setFont(new Font("Arial", Font.PLAIN, 18));

        textArea1.setLineWrap(true);
        textArea2.setLineWrap(true);
        textArea1.setWrapStyleWord(true);
        textArea2.setWrapStyleWord(true);
        // top left bot right
        textArea1.setMargin(new Insets(10,20,10,20));
        textArea2.setMargin(new Insets(10,20,10,20));

        centerPanel = new JPanel(new GridLayout(1, 2));
        centerPanel.add(new JScrollPane(textArea1));
        centerPanel.add(new JScrollPane(textArea2));


        // Find and Replace/Filter panel
        findField = new JTextField(10);
        findField.setFont(new Font("SansSerif", Font.PLAIN, 18));

        replaceField = new JTextField(10);
        replaceButton = new JButton(resourceBundle.getString("Replace"));
        filterButton = new JButton(resourceBundle.getString("Filter"));
        replaceField.setFont(new Font("SansSerif", Font.PLAIN, 18));
        replaceButton.addActionListener(e -> searchAndReplace());
        filterButton.addActionListener(e -> filterString());

        replacePanel = new JPanel();
        replacePanel.add(new JLabel(resourceBundle.getString("Find")));
        replacePanel.add(findField);
        replacePanel.add(new JLabel(resourceBundle.getString("Replace")));
        replacePanel.add(replaceField);
        replacePanel.add(replaceButton);
        replacePanel.add(filterButton);

        if (textArea2.getText().isEmpty()){
            saveButton.setEnabled(false);
        }

        // Main layout
        add(topPanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
        add(replacePanel, BorderLayout.SOUTH);

        setTitle("Regex App");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(900, 800);
        setLocationRelativeTo(null);
    }
    /**
     * Filters text from the first text area using the provided regular expression
     * and displays matches in the second text area. Enables the save button when matches are found.
     */
    private void filterString() {
        String regex = findField.getText();
        String result = textArea1.getText();
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(result);

        while (matcher.find()){
            textArea2.append(matcher.group()+ "\n");
        }
        saveButton.setEnabled(true);
    }
    /**
     * Performs regex search-and-replace operation on text from the first text area
     * and displays results in the second text area. Enables the save button after replacement.
     */
    private void searchAndReplace() {
        String regex = findField.getText();
        String replacement = replaceField.getText();
        String result = textArea1.getText().replaceAll(regex, replacement);
        textArea2.setText(result);
        saveButton.setEnabled(true);
    }
    /**
     * Opens a file chooser dialog and loads the selected text file into the first text area.
     * Supports basic text file loading with error handling.
     */
    private void openFile(){
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(this);

        if (result == JFileChooser.APPROVE_OPTION){
            File selectedFile = fileChooser.getSelectedFile();
            try(Scanner scanner = new Scanner(selectedFile)) {
                StringBuilder content = new StringBuilder();
                while (scanner.hasNextLine()){
                    content.append(scanner.nextLine()).append(("\n"));
                }
                textArea1.setText(content.toString());

            } catch (FileNotFoundException ex){
                System.out.println(ex + "File not found");
            }
        }
    }
    /**
     * Saves the content of the second text area to a file using a file chooser dialog.
     * Shows success/error messages to the user and handles IO exceptions.
     */
    private void saveFile() {
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showSaveDialog(this);

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            try (FileWriter writer = new FileWriter(selectedFile)) {
                writer.write(textArea2.getText());
                JOptionPane.showMessageDialog(this, "File saved successfully!", "Save", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Error saving file: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                System.out.println("Error saving file: " + ex);
            }
        }
    }

    /**
     * Main method to launch the application.
     *
     * @param args Command-line arguments (not used)
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new RegexApp().setVisible(true);
        });
    }
}


