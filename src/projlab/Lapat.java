package projlab;

public class Lapat extends Targy {
	/**Ez a f�ggv�ny a lap�t haszn�lat�t val�s�tja meg. */
	public void hasznal(Szereplo sz) {
		Main.tabs++;
		Main.log(this, "hasznal(" + Main.nameOf(sz) +")");
		//1 helyett 2 a param�ter, h�la a lap�tnak
		sz.hoTakaritas(2);
		Main.tabs--;
	}
}
