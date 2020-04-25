package projlab;

public class Raketaalkatresz extends Targy {
	/**Jatek amihez az alkatresz tartozik.*/
	private Jatek jatek;
	
	public Raketaalkatresz(int _id, Jatek j) {
		super(_id);
		jatek = j;
	}
	/**Ez a fuggveny az alkatresz felszedesenel jelez a jateknak hogy megvan az egyik alkartesz.*/
	public void osszeszed(Szereplo sz) {
		jatek.raketaOsszeszed();
	}
}
