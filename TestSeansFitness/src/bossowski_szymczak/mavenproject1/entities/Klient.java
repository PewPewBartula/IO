/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bossowski_szymczak.mavenproject1.entities;

public class Klient extends Uzytkownik {

	private int id;

	public Klient(String _imie, String _nazwisko, String _email, int _tel) {
		super(_imie,_nazwisko,_email,_tel);
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}
}