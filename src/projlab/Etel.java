package projlab;

public class Etel extends Targy{
	/**a konstruktor beallitja a megfelelo id-t az osben*/
	public Etel(){
		super(1);
	}
	
	/**Ez a fuggveny az etel felszedesevel jaro valtozasokat valositja meg.*/
	public void osszeszed(Szereplo sz) {
		sz.eves();
		sz.targyTorol(this);
	}
}
