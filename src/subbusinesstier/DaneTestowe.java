package subbusinesstier;

import java.util.Arrays;
import subbusinesstier.entities.Miejsce;
import subbusinesstier.entities.Seans;

public class DaneTestowe {
    public int liczbaSeansow = 2;
    public String[][] daneSeansow = {
        {"Spider-man", "2021-12-27 20:30", "1;1;1:1;1;2:1;1;3:1;1;4"},
        {"Matrix", "2021-12-27 20:30", "2;1;1:2;1;2:2;2;1:2;2;2"}
    };
    
    public String[][][] miejscaStr = {
        {{"1", "1", "1"}, {"1", "1", "2"}, {"1", "1", "3"}, {"1", "1", "4"}},
        {{"2", "1", "1"}, {"2", "1", "2"}, {"2", "2", "1"}, {"2", "2", "2"}}
    };
    
    public Miejsce[][] miejsca = {
        {new Miejsce(1, 1, 1), new Miejsce(1, 1, 2), new Miejsce(1, 1, 3), new Miejsce(1, 1, 4)},
        {new Miejsce(2, 1, 1), new Miejsce(2, 1, 2), new Miejsce(2, 2, 1), new Miejsce(2, 2, 2)}
    };
    
    public Seans[] seanse = {
        new Seans("Spider-man", "2021-12-27 20:30", Arrays.asList(miejsca[0])),
        new Seans("Matrix", "2021-12-27 20:30", Arrays.asList(miejsca[1]))
    };
}