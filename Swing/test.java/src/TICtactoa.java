import javax.swing.*;
import java.awt.*;

public class TICtactoa {
    private JPanel p;
    public TICtactoa() {
        JFrame frame = new JFrame("Tic-Tac-Toe");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        JPanel mainPanel = new JPanel( new BorderLayout());
        JPanel topPanel = new JPanel(new FlowLayout());
        topPanel.setBorder (BorderFactory.createEtchedBorder ());
        JPanel centerPanel = new JPanel(new FlowLayout());
        centerPanel.setBorder (BorderFactory.createEtchedBorder ());
        JPanel bottomPanel = new JPanel(new FlowLayout());
        bottomPanel.setBorder (BorderFactory.createEtchedBorder ());


        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                JButton button = new JButton();

                if (i == 0) {
                    topPanel.add(button);
                   // button.addActionListener(new ButtonListener())
                   
                   //TODO add action listener to the button.
                } else if (i == 1) {
                    centerPanel.add(button);
                } else {
                    bottomPanel.add(button);
                }
            }
        }


        mainPanel.add(topPanel,BorderLayout.NORTH);
        mainPanel.add(centerPanel,BorderLayout.CENTER);
        mainPanel.add(bottomPanel,BorderLayout.SOUTH);
        frame.add(mainPanel);

        frame.pack();
        frame.setVisible(true);
    }
     /*
    public class ButtonListener implements ActionListener 
    {      
			public void actionPerformed (ActionEvent e)
			{
				if(e.getActionCommand().equals(" ")
				{
					System.out.print(e);
					}
				}
			
		}
	*/
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new TICtactoa();
        });
    }
}
