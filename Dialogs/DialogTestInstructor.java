import javax.swing.*;

public class DialogTest extends JFrame implements Runnable {
	
	Integer a, b;
    
    private void returnToMainDialog() {
        String[] options = { "Yes", "No" };
        int selected = JOptionPane.showOptionDialog(
            null,
            "Nochmal Khawla?",
            "Mathematische Operation",
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

	class ValuePanel extends JPanel {
		
		private JLabel jlabel; 
		private JTextField value;
		
		public ValuePanel (String label, String defaultVal)
		{
			jlabel = new JLabel (label);
			value = new JTextField (5);
			if (defaultVal != null)
				value.setText (defaultVal);
			setLayout (new BoxLayout (this, BoxLayout.LINE_AXIS));
			add (jlabel);
			add (value);	
		}
		
		public String getText ()
		{
			return value.getText ();
		}
	}

    private void showOptionDialog () {
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
        } else 
        /** Ali: 
        {
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
					try
					{
						a = Integer.parseInt(inputA);
						b = Integer.parseInt(inputB);
					}
					catch (NumberFormatException nfe)
					{
						System.err.println (nfe.getMessage ());
						returnToMainDialog ();
						System.out.println ("Ende der NumberFormatException-Behandlung.");
						return; 
					}
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
        eoAli */
        {
			// JComponent [] jca = {new ValuePanel ("a: ", null), new ValuePanel ("b: ", "1"), new JButton ("ok"), new JButton ("esc")};
			Object [] jca = {new ValuePanel ("a: ", null), new ValuePanel ("b: ", "1"), "Yes", "Nono"};
			String [] element = {"Faktoren", "Summanden"};
			int auswahl = JOptionPane.showOptionDialog (
				null,
				element[selected],
				"Werte eingeben",
				JOptionPane.DEFAULT_OPTION,
				// JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE,
				null,
				jca,
				jca[0]
			);
			System.out.println ("Auswahl: " + auswahl + "dbg: 0: " + jca[0]  + "dbg: 1: " + jca[1]);
			String aS = (jca[0] instanceof ValuePanel vp) ? vp.getText () : "";
			String bS = (jca[1] instanceof ValuePanel vp) ? vp.getText () : "";
			System.out.println ("aS: " + aS + " bS: " + bS);
			// adaptierter Alicode
			if (aS.length () > 0)
			{	
				try
				{
					a = Integer.parseInt (aS);
					b = Integer.parseInt (bS);
				}
				catch (NumberFormatException nfe)
				{
					System.err.println (nfe.getMessage ());
					returnToMainDialog ();
					System.out.println ("Ende der NumberFormatException-Behandlung.");
					return; 
				}
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
        returnToMainDialog ();
    }

	public void run ()
	{

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        showOptionDialog ();
        
	}

    public static void main(String[] args) {
        SwingUtilities.invokeLater (new DialogTest());
    }
}
