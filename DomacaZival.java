/** MARK TABOR, PROGRAMIRANJE 1
 * Java skripta, ki ustvari razred DomacaZival
 * Vhodni podatki /
 * Izhodni podatki /
 * @author Mark Tabor
 * @version Vaja 30
*/

// Naredimo javni Razred student, ki deduje iz Oseba.java

public class DomacaZival extends Oseba {
    private String vrsta;

    public DomacaZival(String i, int v, int t, int s, boolean j, String vrsta) {
        super(i, v, t, s, j);
        // Tukaj sem dal this. da program ve, da je vrsta, ki smo jo navedli v DomacaZival extends Oseba enaka vrsti v DomacaZival()
        this.vrsta = vrsta;
    }

    // Naredimo void funkcijo, ki je samo if stavek ki gleda, katera vrsta je žival ko jo pobožamo. Konzoli vrne, kako odreagira, ko jo pobožamo.
    public void pobozaj() throws Exception{
        //Dodamo izjemo, če je vrsta prazna v kodi (more biti vsaj nekaj napisano)
        if (vrsta == null || vrsta.isEmpty()) {
            throw new Exception("Vrsta živali ni določena.");
        }
        
        if ("pes".equalsIgnoreCase(vrsta)) {
            System.out.println(getIme() + " zamiga z repom.");
        } else if ("mačka".equalsIgnoreCase(vrsta)) {
            System.out.println(getIme() + " prede.");
        } else {
            System.out.println(getIme() + " uživa v čohanju.");
        }
    }

    // getVrsta: Omogoča pridobivanje vrednosti lastnosti vrsta.
    // setVrsta: Omogoča spreminjanje vrednosti lastnosti vrsta.
    public String getVrsta() {
        return vrsta;
    }

    public void setVrsta(String vrsta) {
        this.vrsta = vrsta;
    }
}