package projlab;

public class Buvarruha extends Targy {
	/**Ez a f�ggv�ny a Buv�rruha haszn�lat�t val�s�tja meg. */
	public void hasznal(Szereplo sz, int irany) {
		Main.tabs++;
		Main.log(this, "hasznal(" + Main.nameOf(sz) + ", " + irany + ")");
		Mezo m = sz.getKurrensMezo();
		sz.lepes(irany);
		Main.tabs--;
	}
}
