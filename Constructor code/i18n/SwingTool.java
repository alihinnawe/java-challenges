package glswsql.ui;

import java.awt.*;
import javax.swing.*;

public class SwingTool {
	
	public static void resize (JComponent jc, float size)
	{
		Font font = jc.getFont ();
		font = font.deriveFont (size);
		jc.setFont (font);
	}

	public static void center (JFrame jframe)
	{
		  Toolkit tk = Toolkit.getDefaultToolkit ();
		  Dimension screen = tk.getScreenSize ();
		  Dimension d = jframe.getSize ();
		  jframe.setLocation ((screen.width - d.width) / 2, (screen.height - d.height) / 2);
	}

	public static void setIcon (JFrame jframe)
	{
		String pfad = "./shira128x128.png";
		ImageIcon icon = new ImageIcon (pfad);
		Image image = icon.getImage ();
		jframe.setIconImage (image);
	}
}
