package projlab;

public class Etel extends Targy{
	/**Ez a függvény az étel felszedésével járó változásokat valósítja meg.*/
	public void osszeszed(Szereplo sz) {
		Main.tabs++;
		Main.log(this,"osszeszed()");
		sz.eves();
		
		Main.tabs--;
	}
}
