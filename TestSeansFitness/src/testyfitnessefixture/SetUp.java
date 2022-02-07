
package testyfitnessefixture;

import fit.Fixture;
import bossowski_szymczak.mavenproject1.Aplikacja;
import bossowski_szymczak.mavenproject1.DaneTestowe;
import bossowski_szymczak.mavenproject1.Fabryka;
import bossowski_szymczak.mavenproject1.entities.Pracownik;
import bossowski_szymczak.mavenproject1.entities.Seans;

public class SetUp extends Fixture{
    static Aplikacja ap;
    static Fabryka f;
    public SetUp(){
        ap = new Aplikacja();
        f = new Fabryka();
        Pracownik p = new Pracownik("Adam", "Kowalski", "adkow@gmail.com", 728223989, "admin", "admin");
        String seansDane[] = {"Spider-man", "2021-12-27 20:30", "1;1;1:1;1;2:1;1;3:1;1;4"};
		Seans seans = f.stworzSeans(seansDane);
		ap.dodajSeans(seans);
                ap.dodajPracownik(p);
    }
    
}
