package projlab;

import java.util.ArrayList;
import java.util.List;

public class Jatek {
	
	/**Eddig hány alkatrészt gyûjöttünk össze a gyõzedelmet jeletõ alkatrészekbõl.*/
	private int osszeszedett_alkatreszek = 0;
	/**A játékosok száma*/
	private int jatekosszam;
	/**Amelyik játékos éppen tevékenykedhet.*/
	private int aktualisJatekos = 0;
	/**Játékosok tömbje.*/
	private List<Szereplo> szereplok = new ArrayList<Szereplo>();
	/**A pályán lévõ mezõk tömbje.*/
	private Mezo mezok[];
	
	public Jatek() {}
	/**Ez a függvény a játék létrehozásáért felelõs.*/
	public void ujJatek() {}
	
	/**Ha ezt a függvényt meghívjuk a játék vereséggel véget ér.*/
	public void vereseg() {
		Main.tabs++;
		Main.log(this, "vereseg()");
		Main.tabs--;
	}
	
	/**Ha ezt a függvényt meghívjuk akkor a játék gyõzelemmel zárul */
	private void gyozelem() {
		Main.tabs++;
		Main.log(this, "gyozelem()");
		Main.tabs--;
	}
	
	/**Játék elindításáért felelõs függvény.*/
	public void startJatek(int Jatekosszam) {}
	
	/**Ez a függvény hóvihart hoz létre a pálya egy részén.*/
	public void hovihar() {}
	
	/**Ezzel a függvénnyel tudjuk jelezni hogy felvettünk egy újabb alkatrészt.*/
	public void raketaOsszeszed() {
		Main.tabs++;
		Main.log(this, "raketaOsszeszed()");
		while(true) {
			Main.print("Ezzel együtt már megvan az összes rakétalkatrész? (i/n)");
			String ans = Main.scanner.next();
			if (ans.equals("i")) {
				this.gyozelem();
				break;
			} else if (ans.equals("n")) {
				break;
			}
		}
		Main.tabs--;
	}
	
}
