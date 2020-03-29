package projlab;

public class Raketaalkatresz extends Targy {
	/**Játék amihez az alkatrész tartozik.*/
	private Jatek jatek;
	/**Ez a függvény az alkatrész felszedésénél jelez a játéknak hogy megvan az egyik alkartész.*/
	public void osszeszed() {
		Main.tabs++;
		Main.log(this, "osszeszed()");
		jatek.raketaOsszeszed();
		Main.tabs--;
	}
  
	public void setJatek(Jatek jatek) {
		this.jatek = jatek;
	}
  
}
