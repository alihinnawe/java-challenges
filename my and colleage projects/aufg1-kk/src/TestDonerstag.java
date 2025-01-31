/**
 * Ein <h1>GUI-Programm</h1> zur Textverarbeitung mit Ersetzungs- und Filterfunktionen.
 * Es ermöglicht das Öffnen, Bearbeiten, Speichern und Filtern von Textdateien.
 * Die Benutzeroberfläche enthält verschiedene Panels und Steuerelemente.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.Font;
import java.io.*;
import java.util.ResourceBundle;
import java.util.Scanner;
import javax.swing.JFileChooser;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.*;


/**
 * <h2>Hauptklasse für das Programm</h2>, erbt von JFrame und implementiert Runnable.
 */
public class TestDonerstag extends JFrame implements Runnable {
    /**
     * <u>Konstruktor</u> für das Hauptfenster.
     * @param title Titel des Fensters.
     */

    public TestDonerstag(String title) throws HeadlessException {
        super(title);
    }
    // Sprachressourcen für die Benutzeroberfläche
    ResourceBundle rb = ResourceBundle.getBundle ("TestDonerstag_ar");
    /**
     * Methode zur Initialisierung und Anzeige der Benutzeroberfläche.
     */
    @Override
    public void run() {

        JPanel panelMein = new JPanel();
        JPanel panelbtn = new JPanel();
        JPanel panelText = new JPanel();
        JPanel panelFiel = new JPanel();
        JPanel panelFilter = new JPanel();
        JTabbedPane tabbedPane = new JTabbedPane();
        panelbtn.setBackground(Color.GRAY);

        // Buttons für verschiedene Aktionen
        JButton buttonOpen = new JButton(rb.getString("Open"));
        JButton buttonSave = new JButton(rb.getString("Save"));
        JButton buttonRun = new JButton(rb.getString("Run"));
        JButton buttonFilter = new JButton("Filter");
        JButton buttonExit = new JButton(rb.getString("Exit"));


        // Textbereiche mit automatischem Zeilenumbruch
        JTextArea textArea1 = new JTextArea(10,10);
        JTextArea textArea2 = new JTextArea(10,10);
        textArea1.setBackground(Color.WHITE);
        textArea2.setBackground(Color.WHITE);
        textArea1.setLineWrap(true);
        textArea1.setWrapStyleWord(true);
        textArea2.setLineWrap(true);
        textArea2.setWrapStyleWord(true);

        // Schriftart für die Textbereiche
        Font font = new Font("Arial",Font.ITALIC,40);
        textArea1.setFont(font);
        textArea2.setFont(font);

        // Scrollbars für die Textbereiche
        JScrollPane scrollPane1 = new JScrollPane(textArea1, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        JScrollPane scrollPane2 = new JScrollPane(textArea2, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

        // Hinzufügen der Textbereiche zum Panel
        panelText.add(scrollPane1);
        panelText.add(scrollPane2);

        // Aktion für den "Öffnen"-Button
        buttonOpen.addActionListener(e -> {
        JFileChooser fileChooser = new JFileChooser("./");
        int returnedValue = fileChooser.showOpenDialog(null);
        if(returnedValue==fileChooser.APPROVE_OPTION){
            File fileSelected = fileChooser.getSelectedFile();
            Scanner scanner = null;
            try {
                scanner = new Scanner(fileSelected);
                StringBuilder text = new StringBuilder();
                while (scanner.hasNextLine()) {
                    text.append(scanner.nextLine()).append("\n");
                    textArea1.setText(text.toString());
                }
                if (text.length() == 0) {
                    JOptionPane.showMessageDialog(null, "File ist empty", "Fehler", JOptionPane.WARNING_MESSAGE);
                }
            } catch (FileNotFoundException ex) {
                throw new RuntimeException(ex);
            }
        }
        });

        // Aktion für den "Speichern"-Button
        buttonSave.addActionListener(e -> {
            JFileChooser fileChooser1 = new JFileChooser("./");
            int returnedValue1 = fileChooser1.showSaveDialog(null);
            if (returnedValue1==fileChooser1.APPROVE_OPTION) {
                String save = textArea2.getText();
                try {
                    FileWriter fileWriter = new FileWriter( fileChooser1.getSelectedFile());
                    fileWriter.write(save);
                    fileWriter.close();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        // Aktion für den "Beenden"-Button
        buttonExit.addActionListener(e -> {
            if (e.getSource()==buttonExit){
                System.exit(0);
            }
        });

        // Eingabefelder für die Ersetzungsfunktion
        JTextField textFieldSuche = new JTextField("suchen worte",20);
        JTextField textFieldErsetz =  new JTextField("erseten",20);
        JTextField textFieldFilter = new JTextField("Filter",20);

        // Aktion für den "Ersetzen"-Button
        buttonRun.addActionListener(e -> {
            if (e.getSource()==buttonRun){
                System.out.println("Hello "+textFieldSuche.getText());
                String repleace = textArea1.getText().replaceAll(textFieldSuche.getText(),textFieldErsetz.getText());

                textArea2.setText(repleace.toString());
                buttonRun.setEnabled(false);
            }
        });
        // Aktion für den "Filter"-Button
        buttonFilter.addActionListener(e -> {
            String text = textArea1.getText().trim();
            if (text.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No text loaded!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String[] lines = text.split("\n");
            String patternText = textFieldFilter.getText().trim();

            if (patternText.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Enter a search pattern!", "Warning", JOptionPane.WARNING_MESSAGE);
                return;
            }

            StringBuilder filteredText = new StringBuilder();
            Pattern pattern = Pattern.compile(patternText, Pattern.CASE_INSENSITIVE);

            for (String line : lines) {
                Matcher matcher = pattern.matcher(line);
                if (matcher.find()) {
                    filteredText.append(line).append("\n");
                }
            }

            textArea2.setText(filteredText.length() == 0 ? "No matches found!" : filteredText.toString());
        });


        // Hinzufügen der Komponenten zu den Panels
        panelbtn.add(buttonOpen);
        panelbtn.add(buttonSave);
        panelbtn.add(buttonExit);

        panelFiel.add(textFieldSuche);
        panelFiel.add(buttonRun);
        panelFiel.add(textFieldErsetz);

        panelFilter.add(textFieldFilter);
        panelFilter.add(buttonFilter);

        // Aufbau des Hauptpanels
        panelMein.setLayout(new BorderLayout());
        panelMein.add(panelbtn,BorderLayout.NORTH);
        panelMein.add(panelText,BorderLayout.CENTER);
        // TabbedPane für verschiedene Funktionen
        tabbedPane.addTab("ersetzen",panelFiel);
        tabbedPane.addTab("Filter",panelFilter);
        // Konfiguration des Hauptfensters
        this.setLayout(new BorderLayout());
        this.add(panelMein,BorderLayout.CENTER);
        this.add(tabbedPane,BorderLayout.SOUTH);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);

    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new TestDonerstag("test"));
    }
}
