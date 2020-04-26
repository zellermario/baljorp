package projlab;

public class Sator extends Targy{

	public Sator() {
		super(5);
	}
	
	public void hasznal(Szereplo sz) {
		sz.getKurrensMezo().epit(new FelepitettSator(sz.getKurrensMezo()));
		sz.targyTorol(this);
	}
}
