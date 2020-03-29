package projlab;

public class Kotel extends Targy {
	/**Ez a függvény a kötél használatát valósítja meg. */
	public void hasznal(Szereplo sz) {
		Main.tabs++;
		Main.log(this, "hasznal(" + Main.nameOf(sz) +")");
		Mezo kurrens = sz.getKurrensMezo();
		Mezo szomszed = kurrens.getSzomszed(2);
		//átrakja a lukban állót a megfelelõ mezõre
		szomszed.kotellelKuld(kurrens);
		Main.tabs--;
	}
}
