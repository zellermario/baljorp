package projlab;
/**A stabl jegtablak mukodeset megvalosito osztaly*/
public class Stabil_Jegtabla extends Mezo {
	
	public Stabil_Jegtabla(Jatek j, int horeteg) {
		super(1, j);
		this.horeteg = horeteg;
	}
	/**Negativ ertekkel ter vissza innen lehet tudni hogy ez a jegtabla stabil.*/
	public int megvizsgal() {
		return -1;
	}
	public int szereploVizsgal() {
		vizsgalt = true;
		vizsgalt_ertek = -1;
		return -1;
	}
	/**Megfelelo kirajzolas, beleertve az epitmenyeket es belefagyott targyakat*/
	public void rajzolMezo(Felulet f) {
		epitmeny.rajzolEpitmeny(f, this);
		if(belefagyott_targy!=null)
			belefagyott_targy.rajzolTargy(f, this);
		f.rajzolStabilJegtabla(x, y);
	}
}
