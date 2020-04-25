package projlab;

public class Targy {
	/**A targy azonositoja.*/
	private int id;
	
	public Targy(int _id) {
		id = _id;
	}
	/**Ez a fuggveny a targy hasznalatat valositja meg.*/
	public void hasznal(Szereplo sz) {}
	/**Ez a fuggveny a targy felvetelenek hatasast valositja meg.*/
	public void osszeszed(Szereplo sz) {}
	
	public int getId() {return id;}
}
