package projlab;
/**A raketaalkatreszek viselkedeset megvalosito osztaly*/
public class Raketaalkatresz extends Targy {
	/**Jatek amihez az alkatresz tartozik.*/
	private Jatek jatek;
	
	public Raketaalkatresz(Jatek j) {
		super(4);
		jatek = j;
	}
	/**Ez a fuggveny az alkatresz felszedesenel jelez a jateknak hogy megvan az egyik alkartesz.*/
	public void osszeszed(Szereplo sz) {
		jatek.raketaOsszeszed();
	}
	
	public void rajzolTargy(Felulet f, Mezo m){
		f.rajzolRaketaalkatresz(m);
	}
	
	public void rajzolTargyInv(Felulet f, Szereplo sz, int hanyadik){
		f.rajzolRaketaalkatreszInv(sz, hanyadik);
	}
}
