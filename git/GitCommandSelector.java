import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class GitCommandSelector {

    // Define base Git commands and their options with descriptions
    private static final String[][] GIT_BASE_COMMANDS = {
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

    // Define other Git commands and their options with descriptions
    private static final String[][] GIT_OTHER_COMMANDS = {
        {"git stash", 
            "git stash save \"message\" - Save the current changes with a message.",
            "git stash pop - Apply the most recent stashed changes and remove them from the stash.",
            "git stash list - List all stashed changes.",
            "git stash apply - Apply the most recent stashed changes without removing them from the stash.",
            "git stash drop - Remove the most recent stash."},

        {"git reset", 
            "git reset --soft HEAD~1 - Undo the last commit but keep the changes in the working directory.",
            "git reset --hard HEAD~1 - Undo the last commit and discard the changes.",
            "git reset <file> - Unstage a file from the staging area."},

        {"git merge", 
            "git merge <branch-name> - Merge the specified branch into the current branch.",
            "git merge --no-ff <branch-name> - Perform a merge even if it could be fast-forwarded."},

        {"git rebase", 
            "git rebase <branch-name> - Rebase the current branch onto the specified branch.",
            "git rebase --continue - Continue after resolving conflicts.",
            "git rebase --abort - Abort the rebase operation."},

        {"git cherry-pick", 
            "git cherry-pick <commit-hash> - Apply the changes from the specified commit."},

        {"git tag", 
            "git tag <tag-name> - Create a lightweight tag.",
            "git tag -a <tag-name> -m \"message\" - Create an annotated tag with a message.",
            "git push origin <tag-name> - Push a tag to the remote repository."},

        {"git remote", 
            "git remote add <name> <url> - Add a new remote repository.",
            "git remote -v - List all configured remotes with their URLs.",
            "git remote remove <name> - Remove a remote repository."},

        {"git diff", 
            "git diff - Show unstaged changes.",
            "git diff --staged - Show staged changes.",
            "git diff <commit1> <commit2> - Compare two commits."},

        {"git blame", 
            "git blame <file> - Show who last modified each line in the file."},

        {"git bisect", 
            "git bisect start - Start the bisect process.",
            "git bisect good <commit> - Mark a commit as good.",
            "git bisect bad <commit> - Mark a commit as bad.",
            "git bisect reset - Reset the repository to the original state."}
    };

    public static void main(String[] args) {
        // Create the frame
        JFrame frame = new JFrame("Git Command Selector");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        // Create a JTabbedPane for organizing commands into tabs
        JTabbedPane tabbedPane = new JTabbedPane();

        // Create panels for each tab
        JPanel basePanel = createCommandPanel(GIT_BASE_COMMANDS, "Git Base Commands");
        JPanel otherPanel = createCommandPanel(GIT_OTHER_COMMANDS, "Other Git Commands");

        // Add panels to the tabbed pane
        tabbedPane.addTab("Git Base", basePanel);
        tabbedPane.addTab("Others", otherPanel);

        // Add the tabbed pane to the frame
        frame.add(tabbedPane);
        frame.setVisible(true);
    }

    // Helper method to create a panel for displaying commands
    private static JPanel createCommandPanel(String[][] commands, String title) {
        // Create a panel with a BorderLayout
        JPanel panel = new JPanel(new BorderLayout());

        // Create a label for instructions
        JLabel label = new JLabel("Select a Git command to see its options:");
        label.setHorizontalAlignment(SwingConstants.CENTER);

        // Create a ComboBox for selecting Git commands
        JComboBox<String> commandSelector = new JComboBox<>();
        for (String[] command : commands) {
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
                // Find the selected command in the commands array
                for (String[] command : commands) {
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
        panel.add(topPanel, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);

        return panel;
    }
}
