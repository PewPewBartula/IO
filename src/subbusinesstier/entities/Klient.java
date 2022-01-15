package subbusinesstier.entities;

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