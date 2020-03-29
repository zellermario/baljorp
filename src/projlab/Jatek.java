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
	
	/**Ha ezt a függvényt meghívjuk akkor a visszatérési értékébõl kiderül hogy a játékoksok gyõztek e már vagy sem.*/
	public boolean gyozelem() {
		Main.tabs++;
		Main.log(this, "gyozelem() : true");
		while(true) {
			Main.print("Ezzel egy  (i/n)");
			String ans = Main.scanner.next();
			if (ans.equals("i")) {
				break;
			} else if (ans.equals("n")) {
				break;
			}
		}
		Main.tabs--;
		return true;
	}
	
	/**Játék elindításáért felelõs függvény.*/
	public void startJatek(int Jatekosszam) {}
	
	/**Ez a függvény hóvihart hoz létre a pálya egy részén.*/
	public void hovihar() {}
	
	/**Ezzel a függvénnyel tudjuk jelezni hogy felvettünk egy újabb alkatrészt.*/
	public void raketaOsszeszed() {
		Main.tabs++;
		Main.log(this, "raketaOsszeszed()");
		this.gyozelem();
		Main.tabs--;
	}
	
}
