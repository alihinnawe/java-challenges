import javax.swing.*;

public class DialogTest extends JFrame {
    Integer a, b;

    public DialogTest() {
       
        this.setTitle("Dialog Test");
        this.setSize(300, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        showOptionDialog();
    }

    private void showOptionDialog() {
        Object[] options = { "Multiplication", "Addition" };
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

        if (selected == -1) {
            System.out.println("No option selected. Exiting.");
        } else {
            System.out.println("Selected option: " + options[selected]);

                String inputA = JOptionPane.showInputDialog(
                    null,
                    "Enter value for 'a':",
                    "Input for Multiplication",
                    JOptionPane.QUESTION_MESSAGE
                );

                String inputB = JOptionPane.showInputDialog(
                    null,
                    "Enter value for 'b':",
                    "Input for Multiplication",
                    JOptionPane.QUESTION_MESSAGE
                );
            a = Integer.parseInt(inputA);
			b = Integer.parseInt(inputB);
			if (inputA != null && inputB != null) {
				if (options[selected].equals("Multiplication")) {
						int result = a * b;
						JOptionPane.showMessageDialog(
							null,
							"Multiplication result: " + result,
							"Result",
							JOptionPane.INFORMATION_MESSAGE
						);
                } 
				 else if (options[selected].equals("Addition")) {

						int result = a + b;
						JOptionPane.showMessageDialog(
							null,
							"Addition result: " + result,
							"Result",
							JOptionPane.INFORMATION_MESSAGE
						);
				}
				else {
                    JOptionPane.showMessageDialog(
                        null,
                        "Input canceled. No values provided.",
                        "Warning",
                        JOptionPane.WARNING_MESSAGE
                    );
                }
			}
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new DialogTest());
    }
}
