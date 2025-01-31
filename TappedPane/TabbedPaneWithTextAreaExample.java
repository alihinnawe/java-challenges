import javax.swing.*;

public class TabbedPaneWithTextAreaExample {

    public static void main(String[] args) {
        // Create and display the GUI
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("JTabbedPane with JTextArea Example");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 300);

            // Create the TabbedPane
            JTabbedPane tabbedPane = new JTabbedPane();

            // Add two tabs with JTextArea
            tabbedPane.addTab("Tab 1", new TextAreaPanel("Tab 1"));
            tabbedPane.addTab("Tab 2", new TextAreaPanel("Tab 2"));

            frame.add(tabbedPane);
            frame.setVisible(true);
        });
    }
}

class TextAreaPanel extends JPanel {
    // Declare a JTextArea instance
    private JTextArea textArea;

    // Constructor where you can set up the panel with the JTextArea
    public TextAreaPanel(String tabName) {
        textArea = new JTextArea(10, 30);  // Create the text area with 10 rows and 30 columns
        textArea.setText("Text area for " + tabName);  // Set default text
        
        JScrollPane scrollPane = new JScrollPane(textArea);  // Add scrolling if content is large
        this.add(scrollPane);  // Add the scroll pane (which contains the text area) to the panel
    }

    public JTextArea getTextArea() {
        return textArea;
    }
}
