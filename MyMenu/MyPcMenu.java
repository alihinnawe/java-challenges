import java.io.*;
import java.awt.*;
import javax.swing.*;

public class MyPcMenu extends JFrame implements Runnable {
	

	private boolean isPathDirectory(String myPath) {
			
			File test = new File(myPath);
			if (!test.exists()) {
				return test.getName().lastIndexOf('.') == -1;
			} else {
				System.out.print("is directory " + test.isDirectory() );
				return test.isDirectory();
			}
	}
	
	public void run ()
	{
		isPathDirectory("C:\\Users\\hinnawe.ali\\Desktop\\test");
		}
	
	public static void main (String[] args) {
		
		SwingUtilities.invokeLater(new MyPcMenu());
		}

}
