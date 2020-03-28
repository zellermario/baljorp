package projlab;

public class Szereplo {
	private int munkamennyiseg;
	private int testho;
	private Mezo kurrensmezo;
	private Targy sajat_targyak[];
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
	public void hovihar() {}
	public void eves() {}
	public void kepessegHasznalat(Mezo cel) {}
	public void targyHasznalat(int id) {}
	public void targyKiasas() {
		Main.tabs++;
		Main.log(this, "targyKiasas()");
		kurrensmezo.targyAtad(this);
		Main.tabs--;
	}
	
	public void hoTakaritas(int i) {
		Main.tabs++;
		Main.log(this, "hoTakaritas(" + i +")");
		kurrensmezo.hoTakarit(2);
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
	public Mezo getKurrensmezo() {
		Main.tabs++;
		Main.log(this, "getKurrensmezo()");
		Main.tabs--;
		return kurrensmezo;
	}
}
