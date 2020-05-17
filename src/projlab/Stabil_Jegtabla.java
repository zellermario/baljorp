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
	
	public void rajzolMezo(Felulet f) {
		f.rajzolStabilJegtabla(x, y);
		epitmeny.rajzolEpitmeny(f, this);
		if(belefagyott_targy!=null)
			belefagyott_targy.rajzolTargy(f, this);
	}
}
