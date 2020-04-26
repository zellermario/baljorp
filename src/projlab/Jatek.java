package projlab;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Jatek {
	/**Eddig hany alkatreszt gyujottunk ossze a gyozedelmet jeleto alkatreszekbol.*/
	private int osszeszedett_alkatreszek = 0;

	/**Amelyik jatekos eppen tevekenykedhet.*/
	private int aktualisJatekos = 0;
	
	private boolean jatekvege = false;
	
	private int jegesmedveszam = 0;
	/**Jatekosok tombje.*/
	private List<Szereplo> szereplok = new ArrayList<Szereplo>();
	
	/**A palyan levo mezok tombje.*/
	private List<Mezo> mezok = new ArrayList<Mezo>();
	
	private int jatekosCounter = 0;
	
	public void addToCounter(int i) {
		jatekosCounter = (i+jatekosCounter) % (4*szereplok.size());
		aktualisJatekos = jatekosCounter / 4;
		szereplok.get(aktualisJatekos).kor();
	}
	public int getAktualis() {return aktualisJatekos;}
	
	public Jatek() {}
	
	
	
	public void addSzereplo(Szereplo sz) {
		szereplok.add(sz);
	}
	public void addJegesmedve() {
		szereplok.add(new Jegesmedve(this));
		jegesmedveszam++;
	}
	
	public void addMezo(Mezo m) {
		mezok.add(m);
	}
	public void epuletRombol() {
		for(Mezo m : mezok) m.epuletRombol();
	}
	
	/**Ez a fuggveny a jatek letrehozasaert felelos.*/
	public void ujJatek() {}
	
	/**Ha ezt a fuggvenyt meghivjuk a jatek vereseggel veget er.*/
	public void vereseg() {
		jatekvege = true;
	}
	
	public void nextJatekos() {
		aktualisJatekos++;
		if(aktualisJatekos == szereplok.size()) aktualisJatekos = 0;
		}
	
	public void kor() {
		epuletRombol();
		for(aktualisJatekos = 0; aktualisJatekos < szereplok.size(); aktualisJatekos++) {
			szereplok.get(aktualisJatekos).kor();
			if(jatekvege) break;
		}
		hovihar();
	}
	
	/**Ha ezt a fuggvenyt meghivjuk akkor a visszateresi ertekebol kiderul hogy a jatekoksok gyoztek-e mar vagy sem.*/
	public boolean gyozelem() {	
		if(osszeszedett_alkatreszek == 3)
			return true;
		else return false;
	}
	/**Jatek elinditasaert felelos fuggveny.*/
	public void startJatek(int jatekosszam) {
		while(!jatekvege) {
			kor();
		}
	}
	/**Ez a fuggveny hovihart hoz letre a palya egy reszen.*/
	public void hovihar() {
		/*Random rand = new Random();
		for(Mezo m : mezok) {
			int temp = rand.nextInt(6);
			if(temp == 0) m.hovihar();
		}*/
		
	}
	/**Ezzel a fuggvennyel tudjuk jelezni hogy felvettunk egy ujabb alkatreszt.*/
	public void raketaOsszeszed() {
		osszeszedett_alkatreszek++;
	}
//uj
	public int jatekosszam() {return szereplok.size()-jegesmedveszam;}
}
