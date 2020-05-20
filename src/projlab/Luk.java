package projlab;

public class Luk extends Mezo{
	
	public Luk(Jatek j, int horeteg) {
		super(3, j);
		this.horeteg = horeteg;
	}
	
	/**Ennek a fuggvenynek a visszateresi ertekebol tudhatjuk meg hogy ez luk.*/
	public int megvizsgal() { 
		return 0;}
	
	public int szereploVizsgal() {
		vizsgalt = true;
		vizsgalt_ertek = 0;
		return 0;}
	
	/**Ez a fuggveny felelos az Iglu epitesert, de itt nem csinal semmit mert lukban nem lehet epiteni.*/
	public void epit() {}
	
	/**Ezzel a fuggvennyel lehetne egy jatekost masik mezore kuldeni, hanem lukban allnank.*/
	public void jatekosKuldes(Szereplo sz, Mezo cel) {}
	
	/**Ezzel a fuggvennyel mindenkeppen atleptetjuk az adott jatekost, fuggetlenul attol, hogy lukban allunk*/
	public void atleptet(Szereplo sz, Mezo cel) {
		cel.jatekosFogadas(sz);
		
	}
	
	public void jatekosFogadas(Szereplo sz) {
		horeteg = 0;
		jatekosok.add(sz);
		sz.setKurrensMezo(this);
		sz.munkamennyiseg = sz.munkamennyiseg - 1;
		jatek.addToCounter(1);
		if(sz.munkamennyiseg == 0) sz.munkamennyiseg = sz.maxmunka;
		ellenoriz();
		jatek.kepfrissites();
	}
	
	public void kiment_mindenkit(Mezo cel) {
		for(Szereplo sz : jatekosok) {
			atleptet(sz,cel);
		}
		jatekosok.clear();
	}
	/**Megfelelo kirajzolas*/
	public void rajzolMezo(Felulet f) {
		f.rajzolLuk(x, y);
	}
}