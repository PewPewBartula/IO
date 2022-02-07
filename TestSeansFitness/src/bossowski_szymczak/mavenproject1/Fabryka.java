/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bossowski_szymczak.mavenproject1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import bossowski_szymczak.mavenproject1.entities.*;

public class Fabryka {


    public Seans stworzSeans(String[] dane){
       String[] m = dane[2].split(":");
       List<Miejsce> l = new ArrayList<>();
       for(int i = 0; i < m.length; i++){
           Miejsce _miejsce = stworzMiejsce(m[i].split(";"));
           l.add(_miejsce); 
       }
       Seans out = new Seans(dane[0], dane[1], l);
       return out;
    }


	public Rezerwacja stworzRezerwacje(String[] data) {
		// TODO - implement Fabryka.stworzRezerwacje
		throw new UnsupportedOperationException();
	}

	public Miejsce stworzMiejsce(String[] data) {
            return new Miejsce(Integer.parseInt(data[0]), Integer.parseInt(data[1]), Integer.parseInt(data[2]));
	}

}