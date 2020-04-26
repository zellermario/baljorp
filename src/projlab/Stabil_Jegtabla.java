package projlab;

public class Stabil_Jegtabla extends Mezo {
	
	public Stabil_Jegtabla(Jatek j, int horeteg) {
		super(1, j);
		this.horeteg = horeteg;
	}
	/**Negativ ertekkel ter vissza innen lehet tudni hogy ez a jegtabla stabil.*/
	public int megvizsgal() {
		return -1;
	}
}
