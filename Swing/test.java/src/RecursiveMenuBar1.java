import java.awt.event.ActionEvent;
import java.io.File;
import javax.swing.*;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;
import java.awt.*;

public class RecursiveMenuBar1 extends JFrame implements Runnable {

    static File root = new File("./"); // Root directory
    static JMenuBar jmb = new JMenuBar();

    public RecursiveMenuBar1() {}

    @Override
    public void run() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); // Use system look and feel
        } catch (Exception e) {
            e.printStackTrace();
        }

        File[] files = root.listFiles();
        if (files == null) {
            JOptionPane.showMessageDialog(this, "No files found in the specified directory.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        for (File file : files) {
            if (file.isDirectory()) {
                JMenu jm = new JMenu(file.getName());
                addDirectory(jm, file); // Recursively add subdirectories and files
                jmb.add(jm);

                // Add PopupMenuListener to the popup menu of the JMenu
                JPopupMenu popupMenu = jm.getPopupMenu();
                popupMenu.addPopupMenuListener(new ImagePopupMenuListener(jm));
            }
        }

        setJMenuBar(jmb);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setVisible(true);
    }

    public static void addDirectory(JMenu jMenu, File dir) {
        File[] files = dir.listFiles();
        if (files == null) return;

        for (File file : files) {
            if (file.isDirectory()) {
                JMenu childMenu = new JMenu(file.getName());
                addDirectory(childMenu, file); // Recursively add subdirectories

                // Add PopupMenuListener to the popup menu of the child menu
                JPopupMenu popupMenu = childMenu.getPopupMenu();
                popupMenu.addPopupMenuListener(new ImagePopupMenuListener(childMenu));

                jMenu.add(childMenu);
            } else {
                JMenuItem item = new JMenuItem(file.getName());

                // Add an action listener to handle image preview
                item.addActionListener(e -> {
                    if (file.getName().toLowerCase().endsWith(".png")) {
                        ImageIcon image = new ImageIcon(file.getAbsolutePath());
                        Image scaledImage = image.getImage().getScaledInstance(64, 64, Image.SCALE_SMOOTH);
                        item.setIcon(new ImageIcon(scaledImage));

                        // Mark the menu as needing to stay open
                        JMenu parentMenu = (JMenu) SwingUtilities.getAncestorOfClass(JMenu.class, (Component) e.getSource());
                        if (parentMenu != null) {
                            parentMenu.putClientProperty("keepOpen", true);
                        }
                    } else {
                        // For non-image items, ensure the menu closes normally
                        JMenu parentMenu = (JMenu) SwingUtilities.getAncestorOfClass(JMenu.class, (Component) e.getSource());
                        if (parentMenu != null) {
                            parentMenu.putClientProperty("keepOpen", false);
                        }
                    }
                });

                jMenu.add(item);
            }
        }
    }

    // Custom PopupMenuListener to control menu closure
    static class ImagePopupMenuListener implements PopupMenuListener {
        private final JMenu menu;

        public ImagePopupMenuListener(JMenu menu) {
            this.menu = menu;
        }

        @Override
        public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
            // Reset the "keepOpen" property when the menu becomes visible
            menu.putClientProperty("keepOpen", false);
        }

        @Override
        public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {
            // Delay the decision to close the menu until after the ActionListener has executed
            SwingUtilities.invokeLater(() -> {
                Boolean keepOpen = (Boolean) menu.getClientProperty("keepOpen");
                if (Boolean.TRUE.equals(keepOpen)) {
                    // Re-show the menu to keep it open
                    menu.setSelected(true); // Keep the menu open
                }
            });
        }

        @Override
        public void popupMenuCanceled(PopupMenuEvent e) {
            // Do nothing here
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new RecursiveMenuBar1());
    }
}