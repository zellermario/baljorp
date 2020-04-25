package projlab;

public class Lapat extends Targy {
	
	public Lapat(int _id) {
		super(_id);
	}
	
	/**Ez a fuggveny a lapat hasznalatat valositja meg. */
	public void hasznal(Szereplo sz) {
		sz.hoTakaritas(2);
	}
}
