package projlab;

public class Eszkimo extends Szereplo{
	/**Ez a f�ggv�ny val�s�tja meg az eszkim� k�pess�g�t*/
	public void kepessegHasznal(Mezo cel) {
		Main.tabs++;
		Main.log(this, "kepessegHasznal(" + Main.nameOf(cel) +")");
		cel.igluEpit();
		Main.tabs--;
	}
}

