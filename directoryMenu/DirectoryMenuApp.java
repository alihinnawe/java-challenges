import javax.swing.*;
import java.awt.*;
import java.io.File;

public class DirectoryMenuApp extends JFrame {

    public DirectoryMenuApp(String directoryPath) {
        setTitle("Directory Menu");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JMenuBar menuBar = new JMenuBar();

        File rootDir = new File(directoryPath);
        if (rootDir.exists() && rootDir.isDirectory()) {
            JMenu rootMenu = new JMenu(rootDir.getName());
            buildMenu(rootMenu, rootDir);
            menuBar.add(rootMenu);
        } else {
            JOptionPane.showMessageDialog(this, "Invalid directory path!", "Error", JOptionPane.ERROR_MESSAGE);
        }

        setJMenuBar(menuBar);
    }

    private void buildMenu(JMenu menu, File directory) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {   
                    JMenu subMenu = new JMenu(file.getName());
                    buildMenu(subMenu, file);
                    menu.add(subMenu);
                } else {
                    JMenuItem fileItem = new JMenuItem(file.getName());
                    menu.add(fileItem);
                }
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            String directoryPath = "C:\\Users\\hinnawe.ali\\Desktop\\test";
            new DirectoryMenuApp(directoryPath).setVisible(true);
        });
    }
}
