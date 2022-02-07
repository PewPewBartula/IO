
package testyfitnessefixture;

import fit.ColumnFixture;
public class TestUsunSeans extends ColumnFixture{
    String dane[];
    public boolean usunSeans(){
        int s1 = liczbaSeansow();
        SetUp.ap.usunSeans(dane);
        int s2 = liczbaSeansow();
        return s1!=s2;
    }
    public int liczbaSeansow(){
        return SetUp.ap.getRepertuar().size();
    }
}
