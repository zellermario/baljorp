package projlab;
/**A lapat viselkedeset megvalosito osztaly*/
public class Lapat extends Targy {
	/**a konstruktor beallitja a megfelelo id-t az osben*/
	public Lapat() {
		super(3);
	}
	
	/**Ez a fuggveny a lapat hasznalatat valositja meg. */
	public void hasznal(Szereplo sz) {
		sz.hoTakaritas(2);
	}
}
