package projlab;

public class Lapat extends Targy {
	/**Ez a f�ggv�ny a lap�t haszn�lat�t val�s�tja meg. */
	public void hasznal(Szereplo sz) {
		Main.tabs++;
		Main.log(this, "hasznal(" + Main.nameOf(sz) +")");
		sz.hoTakaritas(2);
		Main.tabs--;
	}
}
