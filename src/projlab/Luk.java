package projlab;

public class Luk extends Mezo{
	
	public Luk(Jatek j, int horeteg) {
		super(3, j);
		this.horeteg = horeteg;
	}
	
	/**Ennek a fuggvenynek a visszateresi ertekebol tudhatjuk meg hogy ez luk.*/
	public int megvizsgal() { return 0;}
	
	/**Ez a fuggveny felelos az Iglu epitesert, de itt nem csinal semmit mert lukban nem lehet epiteni.*/
	public void epit() {}
	
	/**Ezzel a fuggvennyel lehetne egy jatekost masik mezore kuldeni, hanem lukban allnank.*/
	public void jatekosKuldes(Szereplo sz, Mezo cel) {}
	
	/**Ezzel a fuggvennyel mindenkeppen atleptetjuk az adott jatekost, fuggetlenul attol, hogy lukban allunk*/
	public void atleptet(Szereplo sz, Mezo cel) {
		cel.jatekosFogadas(sz);
		jatekosok.remove(sz);
	}
}