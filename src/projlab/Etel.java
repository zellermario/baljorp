package projlab;

public class Etel extends Targy{
	/**Ez a f�ggv�ny az �tel felszed�s�vel j�r� v�ltoz�sokat val�s�tja meg.*/
	public void osszeszed(Szereplo sz) {
		Main.tabs++;
		Main.log(this,"osszeszed()");
		sz.eves();
		
		Main.tabs--;
	}
}
