import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class GitCommandSelector {

    // Define Git commands and their options
    private static final String[][] GIT_COMMANDS = {
        {"git add", "git add .", "git add <file>", "git add -A", "git add -u", "git add -p"},
        {"git config", "git config --global user.name", "git config --global user.email", "git config --list"},
        {"git commit", "git commit -m", "git commit --amend", "git commit -a", "git commit -s"},
        {"git push", "git push origin main", "git push --force", "git push --tags"},
        {"git pull", "git pull origin main", "git pull --rebase"},
        {"git clone", "git clone <repository-url>", "git clone --depth 1 <repository-url>"},
        {"git branch", "git branch", "git branch <branch-name>", "git branch -d <branch-name>"},
        {"git checkout", "git checkout <branch-name>", "git checkout -b <new-branch-name>"},
        {"git status", "git status"},
        {"git log", "git log", "git log --oneline", "git log --graph"}
    };

    public static void main(String[] args) {
        // Create the frame
        JFrame frame = new JFrame("Git Command Selector");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        // Create a panel with a vertical layout
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // Create a label for instructions
        JLabel label = new JLabel("Select a Git command to see its options:");
        label.setHorizontalAlignment(SwingConstants.CENTER);

        // Create a ComboBox for selecting Git commands
        JComboBox<String> commandSelector = new JComboBox<>();
        for (String[] command : GIT_COMMANDS) {
            commandSelector.addItem(command[0]);
        }

        // Create a TextArea to display the options for the selected command
        JTextArea outputArea = new JTextArea();
        outputArea.setEditable(false);
        outputArea.setLineWrap(true);
        outputArea.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(outputArea);

        // Add an action listener to the ComboBox
        commandSelector.addActionListener((ActionEvent e) -> {
            String selectedCommand = (String) commandSelector.getSelectedItem();
            if (selectedCommand != null) {
                // Find the selected command in the GIT_COMMANDS array
                for (String[] command : GIT_COMMANDS) {
                    if (command[0].equals(selectedCommand)) {
                        // Display all subcommands/options for the selected command
                        StringBuilder options = new StringBuilder();
                        for (int i = 1; i < command.length; i++) {
                            options.append(command[i]).append("\n");
                        }
                        outputArea.setText(options.toString());
                        break;
                    }
                }
            } else {
                outputArea.setText("");
            }
        });

        // Add components to the panel
        panel.add(label, BorderLayout.NORTH);
        panel.add(commandSelector, BorderLayout.CENTER);
        panel.add(scrollPane, BorderLayout.SOUTH);

        // Add the panel to the frame and make it visible
        frame.add(panel);
        frame.setVisible(true);
    }
}
