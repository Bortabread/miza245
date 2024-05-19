/** MARK TABOR, PROGRAMIRANJE 1
 * Glavna skripta Clovestvo
 * Vhodni podatki /
 * Izhodni podatki /
 * @author Mark Tabor
 * @version Vaja 34
 */

 import java.io.*;
 import java.util.ArrayList;
 
 public class Clovestvo {
 
     // Deklariramo lastnost (objekt) za vnos iz konzole
     private static BufferedReader in;
 
     // Deklariramo dinamični seznam za shranjevanje objektov Oseba
     private static ArrayList<Oseba> osebe = new ArrayList<>();
 
     public static void main(String[] args) {
         try {
             // Inicializiramo statično lastnost za vnos iz tipkovnice
             in = new BufferedReader(new InputStreamReader(System.in));
 
             // Zanka za vnos lastnosti in ustvarjanje objektov
             while (true) {
                 System.out.println("Vnesite ime osebe (ali pritisnite Enter za konec vnosa):");
                 String ime = in.readLine();
                 if (ime.isEmpty()) {
                     break; // Prekinemo zanko, če je vnos prazen
                 }
                 System.out.println("Vnesite visino osebe (v cm):");
                 int visina = Integer.parseInt(in.readLine());
                 System.out.println("Vnesite tezo osebe (v kg):");
                 int teza = Integer.parseInt(in.readLine());
                 System.out.println("Vnesite starost osebe:");
                 int starost = Integer.parseInt(in.readLine());
                 System.out.println("Ali je oseba živa? (true/false):");
                 boolean jeZiv = Boolean.parseBoolean(in.readLine());
 
                 // Ustvarimo nov objekt Oseba s prebranimi vrednostmi
                 Oseba oseba = new Oseba(ime, visina, teza, starost, jeZiv);
                 // Kličemo metode, ki izvajajo poslovno logiko za ta objekt
                 oseba.izracunITT();
                 oseba.smrtZaradiDebelosti();
                 oseba.jePolnoleten();
                 oseba.jeMrtev();
                 //Spremenimo osebi razpolozenje (ročno oz hardcoded)
                 oseba.spremeniRazpolozenje("srečno");
                 // Dodamo objekt v seznam
                 osebe.add(oseba);
                 System.out.println("____________________________________________________________");
             }
 
             // Ročno dodane osebe
             Oseba clovek2 = new Oseba("LaraHiti", 172, 60, 19, true);
             clovek2.izracunITT();
             clovek2.smrtZaradiDebelosti();
             clovek2.jePolnoleten();
             clovek2.jeMrtev();
             //Spremenimo osebi razpolozenje (ročno oz hardcoded)
             clovek2.spremeniRazpolozenje("zaspano");
             osebe.add(clovek2);
             System.out.println("____________________________________________________________");
 
             Oseba clovek3 = new Oseba("FlorjanZgonc", 190, 251, 40, true);
             clovek3.izracunITT();
             clovek3.smrtZaradiDebelosti();
             clovek3.jePolnoleten();
             clovek3.jeMrtev();
             //Spremenimo osebi razpolozenje (ročno oz hardcoded)
             clovek3.spremeniRazpolozenje("jezno");
             osebe.add(clovek3);
             System.out.println("____________________________________________________________");
 
             // Ročno dodana domača žival (pes)
             DomacaZival pes = new DomacaZival("Medo", 50, 20, 5, true, "pes");
             pes.pobozaj();
             pes.jeMrtev();
             osebe.add(pes);
 
             // Ročno dodana domača žival (mačka)
             DomacaZival macka = new DomacaZival("Chonky", 30, 5, 3, true, "mačka");
             macka.pobozaj();
             macka.jeMrtev();
             osebe.add(macka);
 
             // Izpis vseh objektov v seznamu
             izpisVsehOseb();
 
         } catch (Exception e) {
             System.out.println("Napaka: " + e.getMessage());
         }
     }
 
     // Metoda za izpis vseh oseb v seznamu
     private static void izpisVsehOseb() {
         System.out.println("Izpis vseh oseb v seznamu:");
         for (int i = 0; i < osebe.size(); i++) {
             Oseba oseba = osebe.get(i);
             // Izpis podatkov za vsako osebo
             System.out.println("Ime: " + oseba.getIme() + ", Visina: " + oseba.getVisina() + " cm, Teza: " + oseba.getTeza() + " kg, Starost: " + oseba.getStarost());
         }
     }
 }
 