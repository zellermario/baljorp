package projlab;

public class Stabil_Jegtabla extends Mezo {
	/**Negatív értékkel tér vissza innen lehet tudni hogy ez a jégtábla stabil.*/
	public int megvizsgal() {
		Main.tabs++;
		Main.log(this, "megvizsgal() : -1");
		return -1;}
}
