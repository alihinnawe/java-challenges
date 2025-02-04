
import java.io.File;
import java.io.*;
import javax.swing.*;
import java.awt.*;

public class JMenuBarAli extends JFrame implements Runnable{
	
	public JMenuBarAli ()
	{}
	
	static File f = new File("./test");
	JMenu jm = new JMenu(f.getName());
	
	public void run ()
	{
		JMenuBar jmb =  new JMenuBar();
		if (f.isDirectory()){
			
				addDirectory(jm);
			}
		
		jmb.add(jm);
		setJMenuBar(jmb);
		setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE); 
		add(jmb);
		setVisible (true); 		
		setSize(400,400);
		}
		
       public static void addDirectory(JMenu jMenu) {
        File[] files = f.listFiles();
        
            for (File file : files) {
                if (file.isDirectory()) {
                    JMenu childMenu = new JMenu(file.getName());
                   
                    jMenu.add(childMenu);
                    
                } else {
                    JMenuItem item = new JMenuItem(file.getName());
                    jMenu.add(item);
                }
            }
        }
	
	public static void main (String [] args)
	{
		SwingUtilities.invokeLater(new JMenuBarAli());
		}
	}



