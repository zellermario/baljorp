package projlab;

public class Raketaalkatresz extends Targy {
	private Jatek jatek;
	
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
