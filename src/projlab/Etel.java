package projlab;

public class Etel extends Targy{
	/**Ez a függvény az étel felszedésével járó változásokat valósítja meg.*/
	public void osszeszed() {
		Main.tabs++;
		Main.log(this,"osszeszed()");
	//???
		
		Main.tabs--;
	}
}
