
package testyfitnessefixture;

import fit.ColumnFixture;
public class TestZaloguj extends ColumnFixture{
    String dane[];
    public boolean zmianaUprawnien(){
        int u1 = uprawnienie();
        SetUp.ap.zaloguj(dane[0],dane[1]);
        int u2 = uprawnienie();
        return u1!=u2;
    }
    public int uprawnienie(){
        return SetUp.ap.getUprawnienia();
    }
}
