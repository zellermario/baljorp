package projlab;

public class Buvarruha extends Targy {
	/**Ez a függvény a Buvárruha használatát valósítja meg. */
	public void hasznal(Szereplo sz, int irany) {
		Main.tabs++;
		Main.log(this, "hasznal(" + Main.nameOf(sz) + ", " + irany + ")");
		Mezo m = sz.getKurrensMezo();
		sz.lepes(irany);
		Main.tabs--;
	}
}
