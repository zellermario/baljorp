package projlab;

import java.util.ArrayList;
import java.util.List;

public abstract class Szereplo {
	/**A játékos hátra lévõ munkamennyisége.*/
	private int munkamennyiseg;
	/**A játékos testhõje.*/
	private int testho;
	/**A mezõ amin a játékos áll.*/
	private Mezo kurrensmezo;
	/**A játékosnál lévõ tárgyak.*/
	private List<Targy> sajat_targyak = new ArrayList<Targy>();
	/**A játék aminek a játékos a része.*/
	private Jatek jatek;
	
	public void setJatek(Jatek jatek) {
		this.jatek = jatek;
	}
	/**A játékos lépéseit megvalósító függvény.*/
	public void lepes(int irany) {
		Main.tabs++;
		Main.log(this, "lepes(" + irany + ")");
		Mezo cel = kurrensmezo.getSzomszed(irany);
		kurrensmezo.jatekosKuldes(this, cel);
		Main.tabs--;
	}
	/**Ez a függvény a hóvihar játékosra gyakorolt hatásást valósítja meg.*/
	public void hovihar() {
		Main.tabs++;
		Main.log(this, "hovihar()");
		Main.tabs--;
	}
	/**Ez a függvény az étel elfogyasztásának hatásást valósítja meg.*/
	public void eves() {
		Main.tabs++;
		Main.log(this, "eves()");
		Main.tabs--;
	}
	/**A különbözõ szereplõk képességeit valósítja meg-*/
	public void kepessegHasznal(Mezo cel) {}
	/**Egy felvett tárgy használatát valósítja meg.*/
	public void targyHasznalat(int id) {}
	/**Ezzel a függvénnyel tudunk tárgyakat kiásni a mezõkbõl.*/
	public void targyKiasas() {
		Main.tabs++;
		Main.log(this, "targyKiasas()");
		kurrensmezo.targyAtad(this);
		Main.tabs--;
	}
	/**Ez a függvény valósítja meg a hóréteg eltávolítását az adott mezõrõl.*/
	public void hoTakaritas(int i) {
		Main.tabs++;
		Main.log(this, "hoTakaritas(" + i + ")");
		kurrensmezo.hoTakarit(i);
		Main.tabs--;
	}
  /**Ezzel a függvénnyel tudjuk jelzi a játéknak ha a játékos meghal.*/
  public void halal() {
		Main.tabs++;
		Main.log(this, "halal()");
		jatek.vereseg();
		Main.tabs--;
	}
  	/**Ez a függvény valósítja meg a körváltást.*/
	public void kor() {
		Main.tabs++;
		Main.log(this, "kor()");
		kurrensmezo.megvizsgal();
		this.halal();
		Main.tabs--;
	}
    
	public void setMezo(Mezo m) {
		kurrensmezo = m;
	}
  
	public void addTargy(Targy t) {
		sajat_targyak.add(t);
	}
  
	public Mezo getKurrensMezo() {
		Main.tabs++;
		Main.log(this, "getKurrensMezo() : " + Main.nameOf(kurrensmezo));
		Main.tabs--;
		return kurrensmezo;
	}
  
}
