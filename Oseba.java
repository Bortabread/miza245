/** MARK TABOR, PROGRAMIRANJE 1
 * Java skripta, ki ustvari razred Oseba
 * Vhodni podatki /
 * Izhodni podatki /
 * @author Mark Tabor
 * @version Vaja 30
*/

public class Oseba implements Razpolozenje {

    //Deklariramo lastnosti razreda Oseba
      private String ime;
      private int visina; // v cm
      private float teza; // v kg
      private int starost;
      private boolean jeZiv; // da ali ne
      private String razpolozenje; // novo polje za razpoloženje

    /** Definiramo konstruktor, ki ustvari nov objekt tipa Oseba 
     * @param i in v,t,s,j bodo vsi parametri, ki jih bomo ročno izpolnili
     * 
     */
    public Oseba(String i, int v, int t, int s, boolean j){

    //Inicializiramo lastnosti objekta (poljubne vrednosti)
        ime = i;
        visina = v;
        teza = t;
        starost = s;
        jeZiv = j;
        razpolozenje = "nevtralno"; // privzeto razpoloženje
        
        System.out.println("____________________________________________________________");
        System.out.println("Ustvarili smo osebo/žival: ");
        System.out.println("Ime in priimek: " + i);
        System.out.println("Višina osebe/živali: " + v);
        System.out.println("Teža osebe/živali: " + t);
        System.out.println("Starost osebe: " + s);
        System.out.println("Ali je oseba živa: " + j);
        System.out.println("Razpoloženje: " + razpolozenje);

  }

    //Skripta, ki izračuna indeks telesne teže osebe. 
    public float izracunITT() throws Exception{
        //dodamo izjemo, če je višina < ali = 0. Program javi, da more biti višina večja od 0.        
        if (visina <= 0) {
            throw new Exception("Višina mora biti večja od 0.");
        }
        //Visino moramo najprej spremeniti v metre
        float v = (visina / 100f);
        //Izracunamo ITT
        float ITT = (teza / (v * v));
        //V konzolo izpišemo ITT
        System.out.println("Od osebe ITT je: " + ITT);

        //Izpišemo še, kakšno oceno ITT ima proti povprečju
        if(ITT<10) {
            System.out.println("Oseba ima nizek ITT");

        } else if (ITT>10 && ITT <30) {
            System.out.println("Oseba ima povprečen ITT");

        } else {
            System.out.println("Oseba ima visok ITT");

        }

        // Vrnemo ITT programu
        return ITT;

  }
    public void jeMrtev() throws Exception {
        if (!jeZiv) {
            System.out.println("Rest in Peace...");
        }
        else {
            System.out.println("Oseba/žival je živa.");
    }
}
    // Skripta za pogled, če je oseba polnoletna.
    public boolean jePolnoleten() throws Exception {
        
        if (starost < 0) {
            throw new Exception("Starost ne more biti manjša od 0.");
        }

        if (starost >= 18) {
            System.out.println("Oseba je polnoletna.");
            return true;
        } else {
            System.out.println("Oseba ni polnoletna.");
            return false;
    }
}
    // Skripta, ki pogleda, če ima oseba več kot 250 kg.
    public void smrtZaradiDebelosti() throws Exception{
        if(teza>250) {
           System.out.println("Diabetes bo žal vašo osebo pokopal...");

        }
        else if (teza < 0 || teza > 500)  
            throw new Exception("Teža nesme biti manjša od 0 ali večja kot 500");
    }

    // Implementacija vmesnika Razpolozenje

    public void spremeniRazpolozenje(String novoRazpolozenje) {
        this.razpolozenje = novoRazpolozenje;
        System.out.println("Razpoloženje osebe " + ime + " je spremenjeno na: " + novoRazpolozenje);
    }

    public String pridobiRazpolozenje() {
        return this.razpolozenje;
    }

    // Naredimo par funkcij, ki kličejo podatke (to bom kasneje uporabil v Clovestvo.java)
    public String getIme(){
        return ime;
    }

    public int getVisina(){
        return visina;
    }

    public float getTeza(){
        return teza;
    }

    public int getStarost(){
        return starost;
  }

  public boolean isJeZiv() {
    return jeZiv;
}


}
