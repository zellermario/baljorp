package projlab;

import java.util.ArrayList;
import java.util.List;

public class Szereplo {
	/**A jatekos hatra levo munkamennyisege.*/
	protected int munkamennyiseg;
	
	private int maxmunka;
	
	private int maxtestho;
	
	/**A jatekos testhoje.*/
	private int testho;
	/**A mezo amin a jatekos all.*/
	private Mezo kurrensmezo;
	/**A jatekosnal levo targyak.*/
	private List<Targy> sajat_targyak = new ArrayList<Targy>();
	/**A jatek aminek a jatekos a resze.*/
	private Jatek jatek;
	
	public Szereplo(int maxm, int maxh, Jatek j) {
		jatek = j;
		maxmunka = maxm;
		munkamennyiseg = maxm;
		maxtestho = maxh;
		testho = maxh;
	}
	
	/**A jatekos lepeseit megvalosito fuggveny.*/
	public void lepes(int irany) {
		if(munkamennyiseg == 0) return;
		Mezo cel = kurrensmezo.getSzomszed(irany);
		kurrensmezo.jatekosKuldes(this, cel);
		munkamennyiseg--;
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
		if(munkamennyiseg == 0) return;
		for(Targy t : sajat_targyak) {
			if(t.getId() == id) t.hasznal(this);
		}
		munkamennyiseg--;
	}
	
	/**Ezzel a fuggvennyel tudunk targyakat kiasni a mezokbol.*/
	public void targyKiasas() {
		if(munkamennyiseg == 0) return;
		kurrensmezo.targyAtad(this);
		munkamennyiseg--;
	}
	/**Ez a fuggveny valositja meg a horeteg eltavolitasat az adott mezorol.*/
	public void hoTakaritas(int i) {
		if(munkamennyiseg == 0) return;
		kurrensmezo.hoTakarit(i);
		munkamennyiseg--;
	}
  /**Ezzel a fuggvennyel tudjuk jelzi a jateknak ha a jatekos meghal.*/
  public void halal() {
		jatek.vereseg();
	}
  	/**Ez a fuggveny valositja meg a korvaltast.*/
	public void kor() {
		if(kurrensmezo.megvizsgal() == 0) halal();
		
	}
    
	public void passz() {
		munkamennyiseg = maxmunka;
	}
	
	public void setMezo(Mezo m) {
		kurrensmezo = m;
	}
  
	public Mezo getKurrensMezo() {
		return kurrensmezo;
	}
	
	public void AddTargy(Targy t) {
		sajat_targyak.add(t);
	}
 //Uj resz
	public void targyTorol(Targy t) {
		sajat_targyak.remove(t);
	}
}
