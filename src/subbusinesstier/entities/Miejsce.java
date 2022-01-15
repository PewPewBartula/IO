package subbusinesstier.entities;

public class Miejsce {

	private int sala;
	private int rzad;
	private int nr;
	private boolean czyWolne;

	public Miejsce(int _sala, int _rzad, int _nr) {
		setSala(_sala);
		setRzad(_rzad);
		setNr(_nr);
		czyWolne = true;
	}

	public int getSala() {
		return this.sala;
	}

	public int getRzad() {
		return this.rzad;
	}

	public int getNR() {
		return nr;
	}
	
	public void setNr(int nr) {
		this.nr = nr;
	}

	public boolean getCzyWolne() {
		return this.czyWolne;
	}

	public void setSala(int sala) {
		this.sala = sala;
	}

	public void setRzad(int rzad) {
		this.rzad = rzad;
	}

	public void setCzyWolne(boolean czyWolne) {
		this.czyWolne = czyWolne;
	}

	public String toString() {
		return sala + ";" + rzad + ";" + nr + ":";
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Miejsce))
			return false;
		Miejsce miejsce = (Miejsce) obj;
		return sala == miejsce.getSala() && nr == miejsce.getNR() && rzad == miejsce.getRzad();
	}
}