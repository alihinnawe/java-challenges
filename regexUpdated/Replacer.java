import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class Replacer extends JFrame implements Runnable {
    static int argsbtnsCount;
    static int textFieldsCount;
    static int argstxtAreaCount;
    static int pnCount;
    private JPanel mainPanel1;
    private JPanel mainPanel2;
    private JPanel cardPanel;
    private CardLayout cardLayout;
    private JButton button;

    List<JButton> listbtns1 = new ArrayList<>();
    List<JButton> listbtns2 = new ArrayList<>();
    List<JTextField> txtFields1 = new ArrayList<>();
    List<JTextField> txtFields2 = new ArrayList<>();
    List<JTextArea> txtAreas1 = new ArrayList<>();
    List<JTextArea> txtAreas2 = new ArrayList<>();

    public Replacer() {
    }

    public void createTextFields(List<JTextField> txtFieldslist) {
        for(int i = 0; i < textFieldsCount; ++i) {
            JTextField textField = new JTextField();
            textField.setColumns(10);
            if (i == 0) {
                textField.setText("(.)(.*)");
            } else if (i == 1) {
                textField.setText("$1$2");
            } else {
                textField.setText("textField" + i);
            }

            txtFieldslist.add(textField);
        }
    }

    public void createButtons(List<JButton> buttonsList, String panelType) {
        for(int i = 0; i < argsbtnsCount; ++i) {
            switch (i) {
                case 0:
                    button = new JButton("open");
                    break;
                case 1:
                    button = new JButton("save");
                    break;
                case 2:
                    button = new JButton("exit");
                    break;
                case 3:
                    if (!panelType.equals("Replacement")) {
                        continue;
                    }
                    button = new JButton("run");
                    break;
                case 4:
                    if (!panelType.equals("Filter")) {
                        continue;
                    }
                    button = new JButton("filter");
                    break;
                default:
                    button = new JButton("button" + i);
            }

            button.addActionListener(new NewActionListener(button, txtFields1, txtFields2, txtAreas1, txtAreas2, cardLayout, cardPanel));
            buttonsList.add(button);
        }
    }

    public void createTextAreas(List<JTextArea> textAreasList) {
        for(int i = 0; i < argstxtAreaCount; ++i) {
            JTextArea textArea = new JTextArea();
            textAreasList.add(textArea);
        }
    }

    public void createMainPanel(JPanel tabbedPanelName, List<JButton> buttonsList, List<JTextField> txtFieldslist, List<JTextArea> txtAreasList, String panelType) {
        tabbedPanelName.setLayout(new BorderLayout());
        createTextFields(txtFieldslist);
        createButtons(buttonsList, panelType);
        createTextAreas(txtAreasList);
        JPanel buttonPanel = new JPanel();

        for(int i = 0; i < buttonsList.size(); ++i) {
            if (i < 3) {
                if (!panelType.equals("Filter")) {
                    buttonPanel.add(buttonsList.get(i));
                } else {
                    buttonPanel.add(buttonsList.get(2));
                }
            }
        }

        tabbedPanelName.add(buttonPanel, "North");
        JPanel textFieldPanel = new JPanel();
        if (panelType.equals("Filter")) {
            textFieldPanel.add(txtFieldslist.get(0));
        } else {
            for(JTextField textField : txtFieldslist) {
                textFieldPanel.add(textField);
            }
        }

        JPanel southP = new JPanel();

        for(int i = 3; i < buttonsList.size(); ++i) {
            southP.add(buttonsList.get(i));
        }

        southP.add(textFieldPanel);
        tabbedPanelName.add(southP, "South");
        JPanel textAreaPanel = new JPanel();
        textAreaPanel.setLayout(new BoxLayout(textAreaPanel, 0));

        for(JTextArea textArea : txtAreasList) {
            textArea.setRows(10);
            textArea.setColumns(30);
            textArea.setEditable(false);
            textArea.setLineWrap(false);
            textArea.setWrapStyleWord(false);
            JScrollPane scrollPane = new JScrollPane(textArea);
            scrollPane.setPreferredSize(new Dimension(250, 200));
            textAreaPanel.add(scrollPane);
        }

        tabbedPanelName.add(textAreaPanel, "Center");
    }

    public void run() {
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);
        mainPanel1 = new JPanel();
        mainPanel2 = new JPanel();
        createMainPanel(mainPanel1, listbtns1, txtFields1, txtAreas1, "Replacement");
        createMainPanel(mainPanel2, listbtns2, txtFields2, txtAreas2, "Filter");
        cardPanel.add(mainPanel1, "Replacement Panel");
        cardPanel.add(mainPanel2, "Filter Panel");
        cardLayout.show(cardPanel, "Replacement Panel");
        setDefaultCloseOperation(3);
        setSize(800, 600);
        setVisible(true);
        add(cardPanel);
    }

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Usage: java Replacer btn-<number> txtF-<number> txtA-<number> pn-<number>");
            System.exit(1);
        } else {
            for(int i = 0; i <= args.length - 1; ++i) {
                String[] newArgs = args[i].split("-");
                switch (newArgs[0]) {
                    case "btn":
                        argsbtnsCount = Integer.parseInt(newArgs[1]);
                        break;
                    case "txtF":
                        textFieldsCount = Integer.parseInt(newArgs[1]);
                        break;
                    case "txtA":
                        argstxtAreaCount = Integer.parseInt(newArgs[1]);
                        break;
                    case "pn":
                        pnCount = Integer.parseInt(newArgs[1]);
                        break;
                    default:
                        System.out.println("Invalid argument: " + newArgs[0]);
                        return;
                }
            }
        }
        SwingUtilities.invokeLater(new Replacer());
    }
}
