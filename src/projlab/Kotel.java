package projlab;

public class Kotel extends Targy {
	public void hasznal(Szereplo sz) {
		Main.tabs++;
		Main.log(this, "hasznal(" + Main.nameOf(sz) +")");
		Mezo kurrens = sz.getKurrensmezo();
		Mezo szomszed = kurrens.getSzomszed(2);
		szomszed.kotellelKuld(kurrens);
		Main.tabs--;
	}
}
