package projlab;

public class Raketaalkatresz extends Targy {
	/**Játék amihez az alkatrész tartozik.*/
	private Jatek jatek;
	/**Ez a függvény az alkatrész felszedésénél jelez a játéknak hogy megvan az egyik alkartész.*/
	public void osszeszed(Szereplo sz) {
		Main.tabs++;
		Main.log(this, "osszeszed("+ Main.nameOf(sz)+ ")");
		//jelzi a játéknak, hogy összeszedték
		jatek.raketaOsszeszed();
		Main.tabs--;
	}
	//beállítja a tagváltozót, hogy tudjon szólni neki
	public void setJatek(Jatek jatek) {
		this.jatek = jatek;
	}
  
}
