package projlab;

import java.util.ArrayList;
import java.util.List;

public class Jatek {
	private int osszeszedett_alkatreszek;
	private int jatekosszam;
	private int aktualisJatekos = 0;
	private List<Szereplo> szereplok = new ArrayList<Szereplo>();
	private Mezo mezok[];
	
	public Jatek() {}
	public void ujJatek() {}
	public void vereseg() {}
	public boolean gyozelem() {return true;}
	public void startJatek(int Jatekosszam) {}
	public void hovihar() {}
	public void raketaOsszeszed() {
		Main.tabs++;
		Main.log(this, "raketaOsszeszed()");
		Main.tabs--;
	}
}
