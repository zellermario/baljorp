package projlab;

public class Etel extends Targy{
	/**Ez a f�ggv�ny az �tel felszed�s�vel j�r� v�ltoz�sokat val�s�tja meg.*/
	public void osszeszed(Szereplo sz) {
		Main.tabs++;
		Main.log(this,"osszeszed(" + Main.nameOf(sz)+")");
		//az �tel a felv�telekor egyb�l elhaszn�l�dik, gy�gy�tja a szerepl�t
		sz.eves();
		Main.tabs--;
	}
}
