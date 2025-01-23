import javax.swing.*;

public class DialogTest2 extends JFrame implements Runnable {
	
	Integer a, b;
    
    private void returnToMainDialog() {
       Object[] options = {  "yes", "no", "khawla"};
        int selected = JOptionPane.showOptionDialog(
            null,
            "Return Again?",
            "Operation Selection",
            JOptionPane.YES_NO_CANCEL_OPTION,
            JOptionPane.INFORMATION_MESSAGE,
            null,
            options,
            options[2]
        );
	  if (selected == 0) {
        System.out.println("User selected Yes");
		} else if (selected == 1) {
        System.out.println("User selected No");
    } else if (selected == 2) {
        System.out.println("User selected Cancel");
    }
        
	}
	
	
	public void run ()
	{
		
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        returnToMainDialog();
        
	}

    public static void main(String[] args) {
        SwingUtilities.invokeLater (new DialogTest2());
    }
}
