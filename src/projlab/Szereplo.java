package projlab;

import java.util.ArrayList;
import java.util.List;

public class Szereplo {
	/**A j�t�kos h�tra l�v� munkamennyis�ge.*/
	private int munkamennyiseg;
	/**A j�t�kos testh�je.*/
	private int testho;
	/**A mez� amin a j�t�kos �ll.*/
	private Mezo kurrensmezo;
	/**A j�t�kosn�l l�v� t�rgyak.*/
	private List<Targy> sajat_targyak = new ArrayList<Targy>();
	/**A j�t�k aminek a j�t�kos a r�sze.*/
	private Jatek jatek;
	
	public void setJatek(Jatek jatek) {
		this.jatek = jatek;
	}
	/**A j�t�kos l�p�seit megval�s�t� f�ggv�ny.*/
	public void lepes(int irany) {
		Main.tabs++;
		Main.log(this, "lepes(" + irany + ")");
		Mezo cel = kurrensmezo.getSzomszed(irany);
		kurrensmezo.jatekosKuldes(this, cel);
		Main.tabs--;
	}
	/**Ez a f�ggv�ny a h�vihar j�t�kosra gyakorolt hat�s�st val�s�tja meg.*/
	public void hovihar() {
		Main.tabs++;
		Main.log(this, "hovihar()");
		Main.tabs--;
	}
	/**Ez a f�ggv�ny az �tel elfogyaszt�s�nak hat�s�st val�s�tja meg.*/
	public void eves() {}
	/**A k�l�nb�z� szerepl�k k�pess�geit val�s�tja meg-*/
	public void kepessegHasznal(Mezo cel) {}
	/**Egy felvett t�rgy haszn�lat�t val�s�tja meg.*/
	public void targyHasznalat(int id) {}
	/**Ezzel a f�ggv�nnyel tudunk t�rgyakat ki�sni a mez�kb�l.*/
	public void targyKiasas() {
		Main.tabs++;
		Main.log(this, "targyKiasas()");
		kurrensmezo.targyAtad(this);
		Main.tabs--;
	}
	/**Ez a f�ggv�ny val�s�tja meg a h�r�teg elt�vol�t�s�t az adott mez�r�l.*/
	public void hoTakaritas(int i) {
		Main.tabs++;
		Main.log(this, "hoTakaritas(" + i + ")");
		kurrensmezo.hoTakarit(i);
		Main.tabs--;
	}
  /**Ezzel a f�ggv�nnyel tudjuk jelzi a j�t�knak ha a j�t�kos meghal.*/
  public void halal() {
		Main.tabs++;
		Main.log(this, "halal()");
		jatek.vereseg();
		Main.tabs--;
	}
  	/**Ez a f�ggv�ny val�s�tja meg a k�rv�lt�st.*/
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
