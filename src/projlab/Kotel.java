package projlab;

public class Kotel extends Targy {
	/**Ez a f�ggv�ny a k�t�l haszn�lat�t val�s�tja meg. */
	public void hasznal(Szereplo sz) {
		Main.tabs++;
		Main.log(this, "hasznal(" + Main.nameOf(sz) +")");
		Mezo kurrens = sz.getKurrensMezo();
		Mezo szomszed = kurrens.getSzomszed(2);
		szomszed.kotellelKuld(kurrens);
		Main.tabs--;
	}
}
