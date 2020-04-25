package projlab;

public class Luk extends Mezo{
	
	public Luk(int _id, Jatek j) {
		super(_id, j);
	}
	
	/**Ennek a fuggvenynek a visszateresi ertekebol tudhatjuk meg hogy ez luk.*/
	public int megvizsgal() { return 0;}
	
	/**Ez a fuggveny felelos az Iglu epitesert, de itt nem csinal semmit mert lukban nem lehet epiteni.*/
	public void epit() {}
	
	/**Ezzel a fuggvennyel lehet egy jatekost masik mezore kuldeni.*/
	public void jatekosKuldes(Szereplo sz, Mezo cel) {}
	
	public void atleptet(Szereplo sz, Mezo cel) {
		cel.jatekosFogadas(sz);
	}
}