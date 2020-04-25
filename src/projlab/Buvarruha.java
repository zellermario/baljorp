package projlab;

public class Buvarruha extends Targy {
	
	public Buvarruha() {
		super(0);
	}
	
	/**Ez a fuggveny a Buvarruha hasznalatat valositja meg. */
	public void hasznal(Szereplo sz, int irany) {
		Mezo konkurens = sz.getKurrensMezo();
		konkurens.atleptet(sz, sz.getKurrensMezo().getSzomszed(irany));
		
	}
}
