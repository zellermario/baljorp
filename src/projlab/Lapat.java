package projlab;

public class Lapat extends Targy {
	public void hasznal(Szereplo sz) {
		Main.tabs++;
		Main.log(this, "hasznal(" + Main.nameOf(sz) +")");
		sz.hoTakaritas(2);
		Main.tabs--;
	}
}
