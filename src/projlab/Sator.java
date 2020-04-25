package projlab;

public class Sator extends Targy{

	public Sator(int _id) {
		super(_id);
	}
	
	public void hasznal(Szereplo sz) {
		sz.getKurrensMezo().epit(new FelepitettSator(sz.getKurrensMezo()));
		sz.targyTorol(this);
	}
}
