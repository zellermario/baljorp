package projlab;

public class Raketaalkatresz extends Targy {
	/**J�t�k amihez az alkatr�sz tartozik.*/
	private Jatek jatek;
	/**Ez a f�ggv�ny az alkatr�sz felszed�s�n�l jelez a j�t�knak hogy megvan az egyik alkart�sz.*/
	public void osszeszed(Szereplo sz) {
		Main.tabs++;
		Main.log(this, "osszeszed("+ Main.nameOf(sz)+ ")");
		//jelzi a j�t�knak, hogy �sszeszedt�k
		jatek.raketaOsszeszed();
		Main.tabs--;
	}
	//be�ll�tja a tagv�ltoz�t, hogy tudjon sz�lni neki
	public void setJatek(Jatek jatek) {
		this.jatek = jatek;
	}
  
}
