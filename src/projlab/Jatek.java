package projlab;

import java.util.ArrayList;
import java.util.List;

public class Jatek {
	/**Eddig h�ny alkatr�szt gy�j�tt�nk �ssze a gy�zedelmet jelet� alkatr�szekb�l.*/
	private int osszeszedett_alkatreszek;
	/**A j�t�kosok sz�ma*/
	private int jatekosszam;
	/**Amelyik j�t�kos �ppen tev�kenykedhet.*/
	private int aktualisJatekos = 0;
	/**J�t�kosok t�mbje.*/
	private List<Szereplo> szereplok = new ArrayList<Szereplo>();
	/**A p�ly�n l�v� mez�k t�mbje.*/
	private Mezo mezok[];
	
	public Jatek() {}
	/**Ez a f�ggv�ny a j�t�k l�trehoz�s��rt felel�s.*/
	public void ujJatek() {}
	
	/**Ha ezt a f�ggv�nyt megh�vjuk a j�t�k veres�ggel v�get �r.*/
	public void vereseg() {
		Main.tabs++;
		Main.log(this, "vereseg()");
		Main.tabs--;
	}
	
	/**Ha ezt a f�ggv�nyt megh�vjuk akkor a visszat�r�si �rt�k�b�l kider�l hogy a j�t�koksok gy�ztek e m�r vagy sem.*/
	public boolean gyozelem() {
		Main.tabs++;
		Main.log(this, "gyozelem() : true");
    // todo: kérdést feltenni annak eldöntéséhez, hogy most győzelem van-e
		Main.tabs--;
		return true;
	}
	/**J�t�k elind�t�s��rt felel�s f�ggv�ny.*/
	public void startJatek(int Jatekosszam) {}
	/**Ez a f�ggv�ny h�vihart hoz l�tre a p�lya egy r�sz�n.*/
	public void hovihar() {}
	/**Ezzel a f�ggv�nnyel tudjuk jelezni hogy felvett�nk egy �jabb alkatr�szt.*/
	public void raketaOsszeszed() {
		Main.tabs++;
		Main.log(this, "raketaOsszeszed()");
		this.gyozelem();
		Main.tabs--;
	}
}
