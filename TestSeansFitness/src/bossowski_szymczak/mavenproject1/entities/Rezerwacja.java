/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bossowski_szymczak.mavenproject1.entities;

import java.util.*;

public class Rezerwacja {

	private String nrRezerwacji;
	private Seans seans;
	private List<Miejsce> miejsca = new ArrayList<>();
	private Klient klient;

	public Rezerwacja(String _nr, Seans _seans, List<Miejsce> _miejsca, Klient _klient) {
		setNr(_nr);
		setSeans(_seans);
		setMiejsca(_miejsca);
		setKlient(_klient);
	}

	public String getNr() {
		return nrRezerwacji;
	}

	public void setNr(String nr) {
		nrRezerwacji = nr;
	}

	public Seans getSeans() {
		return this.seans;
	}

	public void setSeans(Seans seans) {
		this.seans = seans;
	}

	public Klient getKlient() {
		return this.klient;
	}

	public void setKlient(Klient klient) {
		this.klient = klient;
	}

	public List<Miejsce> getMiejsca() {
		return this.miejsca;
	}

	public void setMiejsca(List<Miejsce> miejsca) {
		this.miejsca = miejsca;
	}

}