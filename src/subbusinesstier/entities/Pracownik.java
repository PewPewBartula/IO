package subbusinesstier.entities;

public class Pracownik extends Uzytkownik {

	private String login;
	private String haslo;

	public Pracownik(String _imie, String _nazwisko, String _email, int _tel, String _login, String _haslo) {
		super(_imie,_nazwisko,_email,_tel);
		setLogin(_login);
		setHaslo(_haslo);
	}
	
	void setLogin(String login) {
		this.login = login;
	}

	public String getLogin() {
		return this.login;
	}

	public void setHaslo(String haslo) {
		this.haslo = haslo;
	}

	public String getHaslo() {
		return this.haslo;
	}

}