package projlab;

public class Raketaalkatresz extends Targy {
	/**J�t�k amihez az alkatr�sz tartozik.*/
	private Jatek jatek;
	/**Ez a f�ggv�ny az alkatr�sz felszed�s�n�l jelez a j�t�knak hogy megvan az egyik alkart�sz.*/
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
