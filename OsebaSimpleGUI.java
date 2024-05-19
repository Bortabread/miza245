/** MARK TABOR, PROGRAMIRANJE 1
 * Java skripta, ki ustvari razred OsebaSimpleGUI
 * Vhodni podatki /
 * Izhodni podatki /
 * @author Mark Tabor
 * @version Vaja 35
 */

 import javax.swing.*;
 import java.awt.*;
 import java.awt.event.*;
 import java.util.ArrayList;
 
 public class OsebaSimpleGUI extends JFrame {
 
     // Dinamični seznam za shranjevanje objektov Oseba
     private ArrayList<Oseba> osebe;
     private JTextField imeField;
     private JTextField visinaField;
     private JTextField tezaField;
     private JTextField starostField;
     private JCheckBox jeZivCheckBox;
     private JTextArea outputArea;
 
     /** Konstruktor za ustvarjanje GUI-ja
      */
     public OsebaSimpleGUI() {
         osebe = new ArrayList<>();
         initComponents();
     }
 
     /** Inicializacija komponent GUI-ja
      */
     private void initComponents() {
         setTitle("Oseba GUI");
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         setLayout(new BorderLayout());
 
         JPanel inputPanel = new JPanel(new GridLayout(6, 2));
         inputPanel.add(new JLabel("Ime:"));
         imeField = new JTextField();
         inputPanel.add(imeField);
 
         inputPanel.add(new JLabel("Višina (v cm):"));
         visinaField = new JTextField();
         inputPanel.add(visinaField);
 
         inputPanel.add(new JLabel("Teža (v kg):"));
         tezaField = new JTextField();
         inputPanel.add(tezaField);
 
         inputPanel.add(new JLabel("Starost:"));
         starostField = new JTextField();
         inputPanel.add(starostField);
 
         inputPanel.add(new JLabel("Je živa:"));
         jeZivCheckBox = new JCheckBox();
         inputPanel.add(jeZivCheckBox);
 
         JButton addButton = new JButton("Dodaj osebo");
         addButton.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent e) {
                 addOseba();
             }
         });
         inputPanel.add(addButton);
 
         add(inputPanel, BorderLayout.NORTH);
 
         outputArea = new JTextArea();
         outputArea.setEditable(false);
         add(new JScrollPane(outputArea), BorderLayout.CENTER);
 
         setSize(400, 300);
         setLocationRelativeTo(null);
     }
 
     /** Metoda za dodajanje osebe
      */
     private void addOseba() {
         try {
             String ime = imeField.getText();
             int visina = Integer.parseInt(visinaField.getText());
             int teza = Integer.parseInt(tezaField.getText());
             int starost = Integer.parseInt(starostField.getText());
             boolean jeZiv = jeZivCheckBox.isSelected();
 
             Oseba oseba = new Oseba(ime, visina, teza, starost, jeZiv);
             oseba.izracunITT();
             oseba.smrtZaradiDebelosti();
             oseba.jePolnoleten();
             oseba.jeMrtev();
 
             osebe.add(oseba);
             outputArea.append("Dodana oseba: " + oseba.getIme() + "\n");
             clearFields();
         } catch (Exception ex) {
             JOptionPane.showMessageDialog(this, "Napaka pri vnosu: " + ex.getMessage(), "Napaka", JOptionPane.ERROR_MESSAGE);
         }
     }
 
     /** Metoda za čiščenje vnosnih polj
      */
     private void clearFields() {
         imeField.setText("");
         visinaField.setText("");
         tezaField.setText("");
         starostField.setText("");
         jeZivCheckBox.setSelected(false);
     }
 
     /** Glavna metoda za zagon GUI-ja
      * @param args Vhodni parametri
      */
     public static void main(String[] args) {
         SwingUtilities.invokeLater(new Runnable() {
             public void run() {
                 new OsebaSimpleGUI().setVisible(true);
             }
         });
     }
 }
 