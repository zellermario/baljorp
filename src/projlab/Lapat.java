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
	/**Megfelelo kirajzolas*/
	public void rajzolTargy(Felulet f, Mezo m){
		f.rajzolLapat(m);
	}
	/**Megfelelo kirajzolas*/
	public void rajzolTargyInv(Felulet f, Szereplo sz, int hanyadik){
		f.rajzolLapatInv(sz, hanyadik);
	}
}
