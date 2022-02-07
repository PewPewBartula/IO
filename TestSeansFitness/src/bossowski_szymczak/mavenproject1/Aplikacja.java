
package bossowski_szymczak.mavenproject1;

import java.util.*;
import bossowski_szymczak.mavenproject1.entities.*;


public class Aplikacja {

	public static List<Seans> repertuar = new ArrayList<>();
	public static List<Rezerwacja> rezerwacje = new ArrayList<>();
	public static List<Pracownik> pracownicy = new ArrayList<>();
	private List<Klient> klienci = new ArrayList<>();
	private static int uprawnienia = 0;

	static Scanner scan = new Scanner(System.in);
	static Fabryka f = new Fabryka();
	static DaneTestowe daneTestowe = new DaneTestowe();
	public Aplikacja() {

	}
        
        public void dodajPracownik(Pracownik pracownik){
            pracownicy.add(pracownik);
        }

	public static void TEST() {
		Pracownik p = new Pracownik("Adam", "Kowalski", "adkow@gmail.com", 728223989, "admin", "admin");
		Seans seans = f.stworzSeans(daneTestowe.daneSeansow[0]);
		repertuar.add(seans);
		pracownicy.add(p);
	}

	public static void menu() {
		TEST();
		int choice = 0;
		do {
			if (uprawnienia == 0) {
				System.out.println("Panel klienta");
				System.out.println("0 - Zakoncz program");
				System.out.println("1 - Zaloguj");
				System.out.println("2 - Zobacz repertuar");
				System.out.println("3 - Wyszukaj rezerwacje");
				System.out.println("4 - Rezerwuj miejsce");
				System.out.print("> ");
				choice = scan.nextInt();
			} else if (uprawnienia == 1){
				System.out.println("Panel pracownika");
				System.out.println("0 - Zakoncz program");
				System.out.println("1 - Wyloguj");
				System.out.println("2 - Modyfikacja seansu");
				System.out.println("3 - Modyfiakcja rezerwacji");
				System.out.println("4 - Przegladaj seanse");
				System.out.println("5 - Rezerwuj miejsce");
				System.out.print("> ");
				choice = scan.nextInt();
			}
			if (uprawnienia == 0) {
				switch (choice) {
				case 0:
					break;
				case 1:
					zalogujMenu();
					break;
				case 2:
					przegladajSeanse();
					break;
				default:
					System.out.println("Nieprawidlowy numer");
					break;
				}
			} else if (uprawnienia == 1) {
				switch (choice) {
				case 0:
					break;
				case 1:
					wyloguj();
					break;
				case 2:
					modyfikujSeansMenu();
					break;
				case 4:
					przegladajSeanse();
					break;
				default:
					System.out.println("Nieprawidlowy numer");
					break;
				}
			}
			System.out.println();
		} while (choice != 0);
	}

	public static void zalogujMenu() {
		String login, haslo;
		System.out.println("Podaj login: ");
		login = scan.next();
		System.out.println("Podaj haslo: ");
		haslo = scan.next();
		if (zaloguj(login, haslo) == 1)
			System.out.println("Zalogowano pomyslnie");
		else
			System.out.println("Logowanie nieudane");
	}
	
	public static void modyfikujSeansMenu() {
		int op = 0;
		String[] dane = {"","",""};
		do {
		System.out.println("0 - Wstecz");
		System.out.println("1 - Dodaj seans");
		System.out.println("2 - Modyfikuj seans");
		System.out.println("3 - Usun seans");
		System.out.println("> ");
		op = scan.nextInt();
		switch(op) {
		case 0:
			break;
		case 1:
			System.out.println("Podaj tytul filmu");
			dane[0] = scan.next();
			System.out.println("Podaj date filmu");
			dane[1] = scan.next();
			dane[1] += " ";
			System.out.println("Podaj godzine filmu");
			dane[1] += scan.next();
			System.out.println("Podaj rozklad miejsc (s1;r1;m1:s1;r1;m2 itd.)");
			dane[2] = scan.next();
			if(dodajSeans(dane)==1) System.out.println("Seans dodany pomyslnie");
			else System.out.println("Blad przy tworzeniu seansu");
			break;
		case 2:
			Seans seans;
			System.out.println("Podaj tytul filmu");
			dane[0] = scan.next();
			System.out.println("Podaj date filmu");
			dane[1] = scan.next();
			dane[1] += " ";
			System.out.println("Podaj godzine filmu");
			dane[1] += scan.next();
			seans = wyszukajSeans(dane[0],dane[1]);
			if(seans==null) System.out.println("Podany seans nie istnieje");
			else {
				System.out.println("Podaj nowy tytul filmu");
				dane[0] = scan.next();
				System.out.println("Podaj nowa date filmu");
				dane[1] = scan.next();
				dane[1] += " ";
				System.out.println("Podaj nowa godzine filmu");
				dane[1] += scan.next();
				System.out.println("Podaj nowy rozklad miejsc (s1;r1;m1:s1;r1;m2 itd.)");
				dane[2] = scan.next();
				if(modyfikujDaneSeansu(seans,dane)==1) System.out.println("Seans zmodyfikowany pomyslnie");
				else System.out.println("Blad przy modyfiakcji seansu");
			}
			break;
		case 3:
			System.out.println("Podaj tytul filmu");
			dane[0] = scan.next();
			System.out.println("Podaj date filmu");
			dane[1] = scan.next();
			dane[1] += " ";
			System.out.println("Podaj godzine filmu");
			dane[1] += scan.next();
			if(usunSeans(dane)==0) System.out.println("Podany seans nie istnieje");
			else System.out.println("Seans usuniety pomyslnie");
			break;
		}
		} while(op!=0);
	}
	
	public static void przegladajSeanse() {
		for(Seans s : repertuar){
			System.out.println(s.toString());
		}
	}
	
	public static void przegladajRezerwacje() {
		for(Rezerwacja r : rezerwacje) {
			System.out.println(r.toString());
		}
	}

	public List<Rezerwacja> getRezerwacje() {
		return rezerwacje;
	}

	public List<Seans> getRepertuar() {
		return repertuar;
	}
        
        public int getUprawnienia() {
		return uprawnienia;
	}

	public void addToRepertuar(Seans seans) {
		repertuar.add(seans);
	}

	public List<Pracownik> getPracowmicy() {
		return pracownicy;
	}

	public List<Klient> getKlienci() {
		return klienci;
	}
        
        public void dodajSeans(Seans seans){
            repertuar.add(seans);
        }

	public static int dodajSeans(String[] data) throws NumberFormatException {
            try{
		if (wyszukajSeans(data) != null) {
			return 0;
		} else {
			Fabryka f = new Fabryka();
			Seans seans = f.stworzSeans(data);
			repertuar.add(seans);
			return 1;
		}
            }
            catch (Exception e){
                e = new NumberFormatException();
            }
            return 0;
	}

	public static Seans wyszukajSeans(Seans seans) {
		for (Seans s : repertuar) {
			if (s.equals(seans))
				return s;
		}
		return null;
	}
	
	public static Seans wyszukajSeans(String _film, String _data) {
		for(Seans s : repertuar) {
			if(s.getFilm().equals(_film) && s.getData().equals(_data)) return s;
		}
		return null;
	}

	public static Seans wyszukajSeans(String[] dane) {
		Fabryka fabryka = new Fabryka();
		Seans s = fabryka.stworzSeans(dane);
		for (Seans seans : repertuar) {
			if (s.equals(seans))
				return s;
		}
		return null;
	}


	public static int modyfikujDaneSeansu(Seans seans,String[] dane) {
		if(wyszukajSeans(seans)==null) {
			return 0;
		}
		else {
			int index = repertuar.indexOf(seans);
			repertuar.remove(seans);
			repertuar.add(index, f.stworzSeans(dane));
			return 1;
		}
	}

	public static int usunSeans(String[] dane) {
		if(wyszukajSeans(dane[0],dane[1])==null) return 0;
		else {
			repertuar.remove(wyszukajSeans(dane[0],dane[1]));
			return 1;
		}
	}

	public static int zaloguj(String log, String has) {
		for (Pracownik p : pracownicy) {
			if (p.getLogin().equals(log) && p.getHaslo().equals(has)) {
				uprawnienia = 1;
				return 1;
			}
		}
		return 0;

	}

	public static void wyloguj() {
		if (uprawnienia == 1) {
			uprawnienia = 0;
			System.out.println("Wylogowano pomyœlnie");
		} else
			System.out.println("Nie ma potrzeby wylogowania");
	}

	public static void main(String[] args) {
		menu();
	}

	public void dodajRezerwacje(Rezerwacja rezerwacja) {
		rezerwacje.add(rezerwacja);
	}

	public void usunRezerwacje(Rezerwacja rezerwacja) {
		if (rezerwacje.contains(rezerwacja)) {
			rezerwacje.remove(rezerwacja);
		}
	}

	public void usunRezerwacje(int idx) {
		if (idx != -1) {
			rezerwacje.remove(idx);
		}
	}

	public void modyfikujRezerwacje(int idx) {

	}

	public void zarzadzajRezerwacjami() {
		int operacja;
		String[] dane = {};
		System.out.println("1 - Usun rezerwacje");
		System.out.println("2 - Modyfikuj rezerwacje");
		System.out.println("3 - Rezerwuj miejsce");
		System.out.println("Podaj nr operacji: ");
		operacja = scan.nextInt();

		switch (operacja) {
		case 1: {
			String info;
			System.out.println("Podaj numer rezerwacji");
			info = scan.nextLine();
			dane[0] = info;
			if (wyszukajRezerwacje(dane[0]) != -1) {
				usunRezerwacje(Integer.valueOf(dane[0]));
			} else
				System.out.println("Niepoprawny numer");
		}
			break;
		case 2: {
			String info;
			System.out.println("Podaj numer rezerwacji");
			info = scan.nextLine();
			dane[0] = info;
			if (wyszukajRezerwacje(dane[0]) != -1) {
				modyfikujRezerwacje(Integer.valueOf(dane[0]));
			} else
				System.out.println("Niepoprawny numer");
		}
			break;
		case 3: {
			rezerwujMiejsca();
		}
			break;

		default:
			System.out.println("Nieprawid³owy numer operacji");

		}
	}

	public int wyszukajRezerwacje(Rezerwacja rezerwacja) {
		return rezerwacje.indexOf(rezerwacja);
	}

	public int wyszukajRezerwacje(String numerRezerwacji) {
		for (int i = 0; i < rezerwacje.size(); i++) {
			if (rezerwacje.get(i).getNr().equals(numerRezerwacji))
				return i;
		}
		return -1;
	}

	private void rezerwujMiejsca() {
		for (int i = 0; i < repertuar.size(); i++) {
			System.out.println(i + ".: " + repertuar.get(i).toString());
		}
		System.out.println("Podaj numer filmu");
		int filmIdx = scan.nextInt();
		List<Miejsce> wolneMiejsca = repertuar.get(filmIdx).getWolneMiejsca();
		if (wolneMiejsca.isEmpty()) {
			System.out.println("Nie ma wolnych miejsc na wybrany seans.");
			return;
		}
		System.out.println("Podaj liczbê rezerwowanych miejsc.");
		int liczbaMiejsc = scan.nextInt();
		if (wolneMiejsca.size() < liczbaMiejsc) {
			System.out.println("Na ten seans nie ma wystarczaj¹co wolnych miejsc");
			return;
		}
		System.out.println("Lista wolnych miejsc: ");
		for (int i = 0; i < wolneMiejsca.size(); i++) {
			System.out.println(i + ".: " + wolneMiejsca.get(i).toString());
		}

		System.out.println("Podaj wybrane numery miejsc");

		int[] miejsca = new int[liczbaMiejsc];
		for (int i = 0; i < liczbaMiejsc; i++) {
			miejsca[i] = scan.nextInt();
		}

		System.out.println("Podaj id klienta");
		int idKlienta = scan.nextInt();
		if (wyszukajKlienta(idKlienta) == -1) {
			System.out.println("Nie znaleziono klienta");
			return;
		}
		String[] dane = new String[3];
		dane[0] = Integer.toString(filmIdx);
		String miejscaString = "";
		for (int i = 0; i < liczbaMiejsc; i++) {
			miejscaString += miejsca[i] + "|";
		}
		dane[1] = miejscaString;
		dane[2] = Integer.toString(idKlienta);
		Fabryka fabryka = new Fabryka();
		Rezerwacja r = fabryka.stworzRezerwacje(dane);
		dodajRezerwacje(r);
		System.out.println("Numer Rezerwacji: " + r.getNr());
	}

	public int wyszukajKlienta(int id) {
		for (int i = 0; i < klienci.size(); i++) {
			if (klienci.get(i).getId() == id)
				return i;
		}
		return -1;
	}

}