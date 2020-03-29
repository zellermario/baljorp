package projlab;

import java.util.ArrayList;
import java.util.List;

public class Szereplo {
	private int munkamennyiseg;
	private int testho;
	private Mezo kurrensmezo;
	private List<Targy> sajat_targyak = new ArrayList<Targy>();
	private Jatek jatek;
	
	public void setJatek(Jatek jatek) {
		this.jatek = jatek;
	}
  
	public void lepes(int irany) {
		Main.tabs++;
		Main.log(this, "lepes(" + irany + ")");
		Mezo cel = kurrensmezo.getSzomszed(irany);
		kurrensmezo.jatekosKuldes(this, cel);
		Main.tabs--;
	}
  
	public void hovihar() {
		Main.tabs++;
		Main.log(this, "hovihar()");
		Main.tabs--;
	}
	public void eves() {}
	public void kepessegHasznal(Mezo cel) {}
	public void targyHasznalat(int id) {}

	public void targyKiasas() {
		Main.tabs++;
		Main.log(this, "targyKiasas()");
		kurrensmezo.targyAtad(this);
		Main.tabs--;
	}
  
	public void hoTakaritas(int i) {
		Main.tabs++;
		Main.log(this, "hoTakaritas(" + i + ")");
		kurrensmezo.hoTakarit(i);
		Main.tabs--;
	}
  
  public void halal() {
		Main.tabs++;
		Main.log(this, "halal()");
		jatek.vereseg();
		Main.tabs--;
	}
  
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
