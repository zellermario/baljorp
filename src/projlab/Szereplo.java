package projlab;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
/**A szereplok alapveto viselkedeset megvalosito osztaly*/
public abstract class Szereplo implements KeyListener{
	/**A jatekos hatra levo munkamennyisege.*/
	protected int munkamennyiseg;
	/**statikus valtozo, ami alapjan a jatekosok sorszam attributumat beallitjuk*/
	private static int hanyadik = 0;
	/**azt tarolja el, hogy a jatekos hanyadikkent lephet*/
	protected int sorszam;
	/**nyilvantartja, hogy hany munkat vegezhet koronkent a jatekos, ezt reseteli*/
	private int maxmunka;
	/**nyilvantartja, hogy maximum mennyi testhoje lehet egy jatekosnak - nem mehet evessel sem e fole*/
	private int maxtestho;
	
	/**A jatekos testhoje.*/
	protected int testho;
	/**A mezo amin a jatekos all.*/
	protected Mezo kurrensmezo;
	/**A jatekosnal levo targyak.*/
	protected List<Targy> sajat_targyak = new ArrayList<Targy>();
	/**A jatek aminek a jatekos a resze.*/
	protected Jatek jatek;
	
	/** A Szereplo osztaly konstruktora */
	public Szereplo(int maxm,  int maxh, Jatek j, Mezo kezdomezo) {
		jatek = j;
		maxmunka = maxm;
		munkamennyiseg = maxm;
		kurrensmezo = kezdomezo;
		maxtestho = maxh;
		testho = maxh;
		sorszam = hanyadik;
		hanyadik++;
	}
	
	/** Kinullazza a jatekosokat szamlalo countert, ha uj 
	 *  jatekot szeretnenk kezdeni uresen. */
	public static void resetCounter() {
		hanyadik = 0;
	}
	
	/**A jatekos lepeseit megvalosito fuggveny, az ellenorzes a teszteket elosegitendo*/
	public void lepes(int irany) {
		if(sorszam != jatek.getAktualis() || munkamennyiseg == 0) return;
		Mezo cel = kurrensmezo.getSzomszed(irany);
		kurrensmezo.jatekosKuldes(this, cel);
		munkamennyiseg--;
		jatek.addToCounter(1);
	}
	/**Ez a fuggveny a hovihar jatekosra gyakorolt hatasast valositja meg.*/
	public void hovihar() {
		testho--;
		if(testho == 0) halal();
	}
	/**Ez a fuggveny az etel elfogyasztasanak hatasast valositja meg.*/
	public void eves() {
		if(testho < maxtestho) testho++;
	}
	
	/**A kulonbozo szereplok kepessegeit valositja meg-*/
	public void kepessegHasznal(Mezo cel) {}
	
	/**Egy felvett targy hasznalatat valositja meg.*/
	public void targyHasznalat(int id) {
		if(sorszam != jatek.getAktualis() || munkamennyiseg == 0) return;
		for(Targy t : sajat_targyak) {
			if(t.getId() == id) t.hasznal(this);
		}
		munkamennyiseg--;
		jatek.addToCounter(1);
	}
	
	/**Ezzel a fuggvennyel tudunk targyakat kiasni a mezokbol.*/
	public void targyKiasas() {
		if(sorszam != jatek.getAktualis() || munkamennyiseg == 0) return;
		kurrensmezo.targyAtad(this);
		munkamennyiseg--;
		jatek.addToCounter(1);
	}
	/**Ez a fuggveny valositja meg a horeteg eltavolitasat az adott mezorol.*/
	public void hoTakaritas(int i) {
		if(sorszam != jatek.getAktualis() || munkamennyiseg == 0) return;
		kurrensmezo.hoTakarit(i);
		munkamennyiseg--;
		jatek.addToCounter(1);
	}
  /**Ezzel a fuggvennyel tudjuk jelzi a jateknak ha a jatekos meghal.*/
  public void halal() {
	  	testho = 0;
		jatek.vereseg();
	}
  	/**Ez a fuggveny valositja meg a korvaltast.*/
	public void kor() {
		if(kurrensmezo.megvizsgal() == 0) halal();
		
	}
    /**ezzel a fuggvennyel jelzi a jatekos a kore veget*/
	public void passz() {
		jatek.addToCounter(munkamennyiseg);
		munkamennyiseg = maxmunka;
		
	}
	/**beallitjuk a kurrensmezot*/
	public void setMezo(Mezo m) {
		kurrensmezo = m;
	}
	/**lekerdezzuk a kurrensmezot*/
	public Mezo getKurrensMezo() {
		return kurrensmezo;
	}
	/**hozzaadunk egy targyat az inventoryhoz*/
	public void AddTargy(Targy t) {
		sajat_targyak.add(t);
	}
	/**ezzel a fuggvennyel tudunk torolni egy targyat az inventorybol, ha elhasznaltuk azt*/
	public void targyTorol(Targy t) {
		sajat_targyak.remove(t);
	}
	/**A leszarmazottak miatt*/
	public abstract String toString();
	
	/**egyszeru getter*/
	public int getTestho() {
		return testho;
	}
	/**egyszeru getter*/
	public List<Targy> getTargyak() {
		return sajat_targyak;
	}
	/**egyszeru setter*/
	public void setKurrensMezo(Mezo m) {
		kurrensmezo = m;
	}
	
	public void rajzolSzereplo(Felulet f){
		
	}
	

	public void setTestho(int testho) {
		this.testho = testho;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();

	    if (key == KeyEvent.VK_A) {
	        hoTakaritas(1);
	        jatek.kepfrissites();
	    }
	   
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
