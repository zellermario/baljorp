package projlab;

public class Lapat extends Targy {
	/**Ez a függvény a lapát használatát valósítja meg. */
	public void hasznal(Szereplo sz) {
		Main.tabs++;
		Main.log(this, "hasznal(" + Main.nameOf(sz) +")");
		//1 helyett 2 a paraméter, hála a lapátnak
		sz.hoTakaritas(2);
		Main.tabs--;
	}
}
