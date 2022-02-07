/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bossowski_szymczak.mavenproject1.entities;

import java.util.*;

import bossowski_szymczak.mavenproject1.*;

public class Seans {

	private List<Miejsce> miejsca = new ArrayList<>();
	private String film;
	private String data;
	private Fabryka f;

	public Seans(String _film, String _data, List<Miejsce> _miejsca) {
		setFilm(_film);
		setData(_data);
		setMiejsca(_miejsca);
	}

	public Seans(String _film, String _data, String _miejsca) {
		setFilm(_film);
		setData(_data);
		setMiejsca(_miejsca);
	}

	public List<Miejsce> getMiejsca() {
		return this.miejsca;
	}

	public List<Miejsce> getWolneMiejsca() {
		List<Miejsce> wolneMiejsca = new ArrayList<>();
		for (Miejsce m : miejsca) {
			if (m.getCzyWolne())
				wolneMiejsca.add(m);
		}
		return wolneMiejsca;
	}

	public void setMiejsca(List<Miejsce> miejsca) {
		this.miejsca = miejsca;
	}

	public void setMiejsca(String miejsca) {
		String[] m = miejsca.split(":");
		List<Miejsce> l = new ArrayList<>();
		for (int i = 0; i < m.length; i++) {
			Miejsce _miejsce = f.stworzMiejsce(m[i].split(";"));
			l.add(_miejsce);
		}
		this.miejsca = l;
	}

	public String getFilm() {
		return this.film;
	}

	public String getData() {
		return this.data;
	}

	public void setFilm(String film) {
		this.film = film;
	}

	public void setData(String data) {
		this.data = data;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Seans))
			return false;
		Seans seans = (Seans) obj;
		if (seans.getData() == this.getData() && seans.getFilm() == this.getFilm())
			return true;
		else
			return false;
	}

	public String toString() {
		return film + " - " + data;
	}

}