package projlab;
/**A buvarruha mukodeseert felelos osztaly*/
public class Buvarruha extends Targy {
	/**a konstruktor beallitja a megfelelo id-t az osben*/
	public Buvarruha() {
		super(0);
	}
	
	/**Ez a fuggveny a Buvarruha hasznalatat valositja meg. */
	public void hasznal(Szereplo sz, int irany) {
		Mezo kurrens = sz.getKurrensMezo();
		if(kurrens.megvizsgal() == 0) {
			Luk l = (Luk)kurrens;
			l.atleptet(sz, sz.getKurrensMezo().getSzomszed(irany));
			l.jatekosok.remove(sz);
		}
	}
	
	public void rajzolTargy(Felulet f, Mezo m){
		f.rajzolBuvarruha(m);
	}
	
	public void rajzolTargyInv(Felulet f, Szereplo sz, int hanyadik){
		f.rajzolBuvarruhaInv(sz, hanyadik);
	}
}
