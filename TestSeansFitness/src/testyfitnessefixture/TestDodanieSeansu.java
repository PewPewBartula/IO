
package testyfitnessefixture;

import fit.ColumnFixture;
public class TestDodanieSeansu extends ColumnFixture{
    String dane[];
    public boolean dodajSeans(){
        int s1 = liczbaSeansow();
        SetUp.ap.dodajSeans(dane);
        int s2 = liczbaSeansow();
        return s1!=s2;
    }
    public int liczbaSeansow(){
        return SetUp.ap.getRepertuar().size();
    }
}
