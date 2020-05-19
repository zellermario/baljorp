package projlab;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
/**A jatek lebonyolitasaert felelos osztaly*/
public class Jatek {
	/**Eddig hany alkatreszt gyujottunk ossze a gyozedelmet jeleto alkatreszekbol.*/
	private int osszeszedett_alkatreszek = 0;

	/**Amelyik jatekos eppen tevekenykedhet.*/
	private int aktualisJatekos = 0;
	/**ez alkapjan dontjuk el, hogy vege-e a jateknak*/
	private boolean jatekvege = false;
	/**szamontartjuk, hogy hany jegesmedve van a jatekosok kozott - ez a gyozelmi feltetelek meghatarozasanal fontos*/
	private int jegesmedveszam = 0;
	/**Jatekosok tombje.*/
	private List<Szereplo> szereplok = new ArrayList<Szereplo>();
	
	/**A palyan levo mezok tombje.*/
	private List<Mezo> mezok = new ArrayList<Mezo>();
	
	/**jatekosok altal hasznalt munka alapjan szamlal, a segitsegevel hatarozzuk meg, hogy ki kovetkezik*/
	private int jatekosCounter = 0;
	
	private Mezo kivalasztott_mezo = null;
	
	private Felulet felulet;
	
	/** A Jatek osztaly konstruktora */
	public Jatek() {
		
		Szereplo.resetCounter();
		felulet = new Felulet(this);
	}
	
	/**a koroket vezerlo fuggveny, a munkamennyisegek alapjan tudjuk ezt szamon tartani, ebben segit a passz fuggvenye a Szereplonek*/
	public void addToCounter(int i) {
		jatekosCounter += i;
		if(jatekosCounter == szereplok.size() * 4) { 
			epuletRombol();
			
			jatekosCounter = 0;
			hovihar();
		}
		aktualisJatekos = jatekosCounter / 4;
		if(jatekosCounter % 4 == 0) {
			szereplok.get(aktualisJatekos).kor();
			kepfrissites();
		}
	}
	
	/**visszaadja az epp soron kovetkezo jatekos sorszamat*/
	public int getAktualis() {return aktualisJatekos;}
	
	
	/**ennek a fuggvenynek a segitsegevel adhatunk hozza ujabb jatekosokat a jatekhoz*/
	public void addSzereplo(Szereplo sz) {
		szereplok.add(sz);
		sz.getKurrensMezo().addJatekos(sz);
	}
	/**kulon hozzaadas a jegesmedveknek -  nyilvantartjuk, hogy mennyi van belole*/
	public void addJegesmedve(Jegesmedve j) {
		szereplok.add(j);
		jegesmedveszam++;
		j.getKurrensMezo().addJatekos(j);
	}
	/**Mezok hozzaadasa a jatekhoz
	 * a mezok szomszedossagi viszonyat mar korabban definialtuk*/
	public void addMezo(Mezo m) {
		mezok.add(m);
	}
	
	/**kor elejen leromboljuk az osszes olyan epuletet, ami ideiglenes
	 * most a tesztek egyszerubb vegrehajtasa erdekeben determinisztikusan hivjuk meg
	 */
	public void epuletRombol() {
		for(Mezo m : mezok) m.epuletRombol();
	}
	
	/**Ez a fuggveny a jatek letrehozasaert felelos
	 * most a tartalma lenyegeben a tesztesetekben kerul megvalositasra*/
	public void ujJatek() {}
	
	/**Ha ezt a fuggvenyt meghivjuk a jatek vereseggel veget er.*/
	public void vereseg() {
		jatekvege = true;
		felulet.getCardLayout().show(felulet.getControlPanel(), "veresegpanel");
		//valami kirajzolas a grafikus programban
	}
	/**jatekosok kozotti valtas, a teszteles soran ezt a passzolassal valositjuk meg*/
	public void nextJatekos() {
		aktualisJatekos++;
		if(aktualisJatekos == szereplok.size()) {
			aktualisJatekos = 0;
			hovihar();
		}
	}
	
	/**a fo ciklus, de a tesztek kedveert a determinisztikus leptetest a jatekosCounter segitsegevel tesszuk meg*/
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
		{
			felulet.getCardLayout().show(felulet.getControlPanel(), "gyozelempanel");
			return true;
		}
		else return false;
	}
	/**Jatek elinditasaert felelos fuggveny. A teszteknel nem hasznaljuk, hogy a determinisztikus leptetes egyszeruen megvalosithato legyen*/
	public void startJatek(int jatekosszam) {
		while(!jatekvege) {
			kor();
		}
	}
	/**Ez a fuggveny hovihart hoz letre a palya egy reszen.*/
	public void hovihar() {
		Random rand = new Random();
		for(Mezo m : mezok) {
			int temp = rand.nextInt(6);
			if(temp == 0) m.hovihar();
		}
		
	}
	/**Ezzel a fuggvennyel tudjuk jelezni hogy felvettunk egy ujabb alkatreszt.*/
	public void raketaOsszeszed() {
		osszeszedett_alkatreszek++;
	}

	/**ezzel a fuggvennyel tudjuk lekerdezni, hogy hany jatekos van*/
	public int jatekosszam() {return szereplok.size()-jegesmedveszam;}
  
	public List<Szereplo> getSzereplok() {
		return szereplok;
	}

	public List<Mezo> getMezok() {
		return mezok;
	}

	public void kepfrissites() {
		felulet.frissites();
	}
	
	public void feluletInit() {
		
	}
	
	public void kivalasztott(Mezo cel) {
		kivalasztott_mezo = cel;
	}
	
	public void lep_mezo() {
		szereplok.get(aktualisJatekos).getKurrensMezo().jatekosKuldes(szereplok.get(aktualisJatekos), kivalasztott_mezo);
	}

	public Felulet getFelulet() {
		return felulet;
	}
	
	public Mezo getKivalasztott_mezo() {
		return kivalasztott_mezo;
	}

	public void targy_hasznal(int indx) {
		if(indx <= szereplok.get(aktualisJatekos).getTargyak().size()) {
			szereplok.get(aktualisJatekos).getTargyak().get(indx - 1).hasznal(szereplok.get(aktualisJatekos));
		}
	}
}
