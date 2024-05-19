/** MARK TABOR, PROGRAMIRANJE 1
 * Java skripta, ki ustvari razred Student
 * Vhodni podatki /
 * Izhodni podatki /
 * @author Mark Tabor
 * @version Vaja 30
*/

// Naredimo javni Razred student, ki deduje iz Oseba.java
public class Student extends Oseba {
    //Naredimo private integer letnik
    private int letnik;

    // Naredimo konstruktor, ki bo vlekel vse spremenljivke iz Oseba.java, samo int letnik je nova
    public Student(String i, int v, int t, int s, boolean j, int l) {
        super(i, v, t, s, j);
        letnik = l;
    }

    public void napredujLetnik() throws Exception {
        if (letnik < 0) {
            throw new Exception("Letnik ne sme biti manjši od 0.");
        }
        letnik += 1;
        System.out.println(getIme() + " je napredoval/a v " + letnik + ". letnik.");
    }

    public int getLetnik() {
        return letnik;
    }
}
