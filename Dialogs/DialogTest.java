import javax.swing.*;

public class DialogTest extends JFrame implements Runnable {
	
	Integer a, b;
    
    private void returnToMainDialog() {
        Object[] options = { "Yes", "No" };
        int selected = JOptionPane.showOptionDialog(
            null,
            "Return Again?",
            "Operation Selection",
            JOptionPane.DEFAULT_OPTION,
            JOptionPane.QUESTION_MESSAGE,
            null,
            options,
            options[0]
        );
        
        if (selected == 0)
        {
			showOptionDialog();
		}
		else {
			System.out.print ("See you later!");
			dispose ();
		}
	}

    private void showOptionDialog() {
        // Object[] options = { "Multiplication", "Addition", "Division", "Subtraction" };
        // Object[] options = {"Multiplication", "Addition"};
        String[] options = {"Multiplication", "Addition"};
        int selected = JOptionPane.showOptionDialog(
            null,
            "Choose an operation",
            "Operation Selection",
            JOptionPane.DEFAULT_OPTION,
            JOptionPane.QUESTION_MESSAGE,
            null,
            options,
            options[0]
        );
        String operation = options[selected];
        if (selected == -1) {
            System.out.println("No option selected. Exiting.");
        } else {
			System.out.println("Selected option: " + operation);
			String inputA = JOptionPane.showInputDialog (
					null,
					"Enter value for 'a':",
					"Input for " + operation,
					JOptionPane.QUESTION_MESSAGE
			);
			if (! inputA.isEmpty ())
			{	
				String inputB = JOptionPane.showInputDialog (
					null,
					"Enter value for 'b':",
					"Input for " + operation,
					JOptionPane.QUESTION_MESSAGE
				);
				if (inputA != null && inputB != null) {
					a = Integer.parseInt(inputA);
					b = Integer.parseInt(inputB);
					int result; 
					if (operation.equals("Multiplication")) {
							result = a * b;
					} 
					else //if (operation.equals("Addition")) 
					{
							result = a + b;
					}
					JOptionPane.showMessageDialog(
						null,
						operation + " result: " + result,
						"Result",
						JOptionPane.INFORMATION_MESSAGE
					);
     			}
			}
        }
        returnToMainDialog ();
    }

	public void run ()
	{
		// this.setTitle("Dialog Test");
        // this.setSize(300, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // this.setVisible (false);
        showOptionDialog ();
        
	}

    public static void main(String[] args) {
        SwingUtilities.invokeLater (new DialogTest());
    }
}
