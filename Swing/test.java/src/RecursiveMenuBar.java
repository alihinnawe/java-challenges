import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class RecursiveMenuBar extends JFrame implements Runnable {
	static File f = new File("./");
	static JMenuBar jmb = new JMenuBar();

	public RecursiveMenuBar() {}

	public void run() {
		File[] files = f.listFiles();
        System.out.print(files);

		for (File file : files) {
			JMenu jm = new JMenu(file.getName());
			if (file.isDirectory()) {
				jmb.add(jm);
			}
			addDirectory(jm, file);
		}


		setJMenuBar(jmb);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 400);
		setVisible(true);
	}

	public static void addDirectory(JMenu jMenu, File f) {
		File[] files = f.listFiles();
		if (files == null) return;

		for (File file : files) {
			if (file.isDirectory()) {
				JMenu childMenu = new JMenu(file.getName());
				addDirectory(childMenu, file);
				jMenu.add(childMenu);
			} else {

				JMenuItem item = new JMenuItem(file.getName());

				item.addActionListener(e -> {
				if (file.getName().endsWith("PNG") || file.getName().endsWith("png"))
					{
					ImageIcon image = new ImageIcon(file.getAbsolutePath());
					Image scaledImage = image.getImage().getScaledInstance(64, 64, Image.SCALE_SMOOTH);

					item.setIcon(new ImageIcon(scaledImage));
				}
				});


				jMenu.add(item);
			}
		}
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new RecursiveMenuBar());
	}
}
