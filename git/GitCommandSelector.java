import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class GitCommandSelector {

    // Define Git commands and their options with descriptions
    private static final String[][] GIT_COMMANDS = {
        {"git add", 
            "git add . - Stages all changes in the current directory and subdirectories.",
            "git add <file> - Stages a specific file.",
            "git add -A - Stages all changes, including new, modified, and deleted files.",
            "git add -u - Stages only modified and deleted files (tracked files only).",
            "git add -p - Interactively stages changes hunk by hunk."},

        {"git config", 
            "git config --global user.name - Sets the global username for commits.",
            "git config --global user.email - Sets the global email for commits.",
            "git config --list - Lists all configuration settings."},

        {"git commit", 
            "git commit -m \"message\" - Commits changes with a specified message.",
            "git commit --amend - Modifies the last commit.",
            "git commit -a - Stages and commits all modified and deleted files.",
            "git commit -s - Adds a Signed-off-by line to the commit message."},

        {"git push", 
            "git push origin main - Pushes changes to the 'main' branch on the remote repository.",
            "git push --force - Forces the push, overwriting the remote history.",
            "git push --tags - Pushes all tags to the remote repository."},

        {"git pull", 
            "git pull origin main - Pulls changes from the 'main' branch on the remote repository.",
            "git pull --rebase - Rebases your local changes on top of the fetched changes."},

        {"git clone", 
            "git clone <repository-url> - Clones a remote repository to your local machine.",
            "git clone --depth 1 <repository-url> - Clones only the latest commit for faster cloning."},

        {"git branch", 
            "git branch - Lists all branches.",
            "git branch <branch-name> - Creates a new branch.",
            "git branch -d <branch-name> - Deletes a branch."},

        {"git checkout", 
            "git checkout <branch-name> - Switches to an existing branch.",
            "git checkout -b <new-branch-name> - Creates and switches to a new branch."},

        {"git status", 
            "git status - Shows the status of the working directory and staging area."},

        {"git log", 
            "git log - Displays the commit history.",
            "git log --oneline - Displays the commit history in a condensed format.",
            "git log --graph - Displays the commit history with a graphical representation of branches."}
    };

    public static void main(String[] args) {
        // Create the frame
        JFrame frame = new JFrame("Git Command Selector");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        // Create a main panel with a BorderLayout
        JPanel mainPanel = new JPanel(new BorderLayout());

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
                        // Display all subcommands/options for the selected command with descriptions
                        StringBuilder options = new StringBuilder();
                        for (int i = 1; i < command.length; i++) {
                            options.append(command[i]).append("\n");
                        }
                        outputArea.setText(options.toString().trim());
                        break;
                    }
                }
            } else {
                outputArea.setText("");
            }
        });

        // Create a panel for the top section (label + combo box)
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(label, BorderLayout.NORTH);
        topPanel.add(commandSelector, BorderLayout.CENTER);

        // Add components to the main panel
        mainPanel.add(topPanel, BorderLayout.NORTH);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        // Add the main panel to the frame and make it visible
        frame.add(mainPanel);
        frame.setVisible(true);
    }
}
