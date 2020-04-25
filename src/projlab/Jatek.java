package projlab;

import java.util.ArrayList;
import java.util.List;

public class Jatek {
	/**Eddig hany alkatreszt gyujottunk ossze a gyozedelmet jeleto alkatreszekbol.*/
	private int osszeszedett_alkatreszek;
	/**A jatekosok szama*/
	private int jatekosszam;
	/**Amelyik jatekos eppen tevekenykedhet.*/
	private int aktualisJatekos = 0;
	/**Jatekosok tombje.*/
	private List<Szereplo> szereplok = new ArrayList<Szereplo>();
	/**A palyan levo mezok tombje.*/
	private Mezo mezok[];
	
	public Jatek() {}
	/**Ez a fuggveny a jatek letrehozasaert felelos.*/
	public void ujJatek() {}
	
	/**Ha ezt a fuggvenyt meghivjuk a jatek vereseggel veget er.*/
	public void vereseg() {
		Main.tabs++;
		Main.log(this, "vereseg()");
		Main.tabs--;
	}
	
	/**Ha ezt a fuggvenyt meghivjuk akkor a visszateresi ertekebol kiderul hogy a jatekoksok gyoztek e mar vagy sem.*/
	public boolean gyozelem() {
		Main.tabs++;
		Main.log(this, "gyozelem() : true");
		Main.tabs--;
		return true;
	}
	/**Jatek elinditasaert felelos fuggveny.*/
	public void startJatek(int Jatekosszam) {}
	/**Ez a fuggveny hovihart hoz letre a palya egy reszen.*/
	public void hovihar() {}
	/**Ezzel a fuggvennyel tudjuk jelezni hogy felvettunk egy ujabb alkatreszt.*/
	public void raketaOsszeszed() {
		Main.tabs++;
		Main.log(this, "raketaOsszeszed()");
		this.gyozelem();
		Main.tabs--;
	}
//uj
	public int jatekosszam() {return szereplok.size();}
}
