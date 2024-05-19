/** MARK TABOR, PROGRAMIRANJE 1
 * Java skripta, ki ustvari razred OsebaTableModel
 * Vhodni podatki /
 * Izhodni podatki /
 * @author Mark Tabor
 * @version Vaja 35
 */

 import javax.swing.table.DefaultTableModel;
 import java.util.ArrayList;
 
 public class OsebaTableModel extends DefaultTableModel {
 
     // Dinamični seznam za shranjevanje objektov Oseba
     private ArrayList<Oseba> osebe;
 
     /** Konstruktor za ustvarjanje modela tabele
      */
     public OsebaTableModel() {
         // Nastavitev imen stolpcev tabele
         super(new String[]{"Ime", "Višina", "Teža", "Starost", "Živ", "Razpoloženje"}, 0);
         osebe = new ArrayList<>();
     }
 
     @Override
     public boolean isCellEditable(int row, int column) {
         return false; // Prepreči urejanje celic v tabeli
     }
 
     /** Dodajanje osebe v tabelo
      * @param oseba Objekt Oseba, ki ga želimo dodati
      */
     public void dodajOsebo(Oseba oseba) {
         osebe.add(oseba);
         addRow(new Object[]{oseba.getIme(), oseba.getVisina(), oseba.getTeza(), oseba.getStarost(), oseba.isJeZiv(), oseba.pridobiRazpolozenje()});
     }
 
     /** Pridobivanje osebe iz tabele
      * @param row Vrstica tabele
      * @return Objekt Oseba na določeni vrstici
      */
     public Oseba getOsebaAt(int row) {
         return osebe.get(row);
     }
 }