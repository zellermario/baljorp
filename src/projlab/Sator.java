package projlab;
/**A sator viselkedeset megvalosito osztaly*/
public class Sator extends Targy{
	/**a konstruktor beallitja a megfelelo id-t az osben*/
	public Sator() {
		super(5);
	}
	/**a sator felepiteset megvalosito fuggveny*/
	public void hasznal(Szereplo sz) {
		sz.getKurrensMezo().epit(new FelepitettSator(sz.getKurrensMezo()));
		sz.targyTorol(this);
	}
	/**Megfelelo kirajzolas*/
	public void rajzolTargy(Felulet f, Mezo m){
		f.rajzolSator(m);
	}
	/**Megfelelo kirajzolas*/
	public void rajzolTargyInv(Felulet f, Szereplo sz, int hanyadik){
		f.rajzolSatorInv(sz, hanyadik);
	}
}
