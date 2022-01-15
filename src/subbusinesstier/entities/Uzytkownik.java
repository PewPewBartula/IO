package subbusinesstier.entities;

public abstract class Uzytkownik {

	private String imie;
	private String nazwisko;
	private String email;
	private int telefon;

	public Uzytkownik(String _imie, String _nazwisko, String _email, int _tel) {
		setImie(_imie);
		setNazwisko(_nazwisko);
		setEmail(_email);
		setTelefon(_tel);
	}

	public String getImie() {
		return this.imie;
	}

	public void setImie(String imie) {
		this.imie = imie;
	}

	public String getNazwisko() {
		return this.nazwisko;
	}

	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getTelefon() {
		return this.telefon;
	}

	public void setTelefon(int telefon) {
		this.telefon = telefon;
	}

}