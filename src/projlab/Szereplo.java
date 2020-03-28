package projlab;

public class Szereplo {
	private int munkamennyiseg;
	private int testho;
	private Mezo kurrensmezo;
	private Targy sajat_targyak[];
	private Jatek jatek;
	private String nev;
	
	public Szereplo(String nev) { this.nev = nev; }
	public void lepes(int irany) {
		Main.tabs++;
		Main.print("Szereplo.lepes()");
		Mezo cel = kurrensmezo.getSzomszed(irany);
		kurrensmezo.jatekosKuldes(this, cel);
		Main.tabs--;
	}
	public void hovihar() {}
	public void eves() {}
	public void kepessegHasznalat(Mezo cel) {}
	public void targyHasznalat(int id) {}
	public void targyKiasas() {}
	public void hoTakaritas(int i) {}
	public void halal() {
		Main.tabs++;
		Main.print("Szereplo.halal()");
		Main.tabs--;
	}
	public void kor() {}
	public void setMezo(Mezo m) {
		kurrensmezo = m;
	}
}
