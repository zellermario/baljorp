package projlab;

public class Eszkimo extends Szereplo{
	/**Ez a függvény valósítja meg az eszkimó képességét*/
	public void kepessegHasznal(Mezo cel) {
		Main.tabs++;
		Main.log(this, "kepessegHasznal(" + Main.nameOf(cel) +")");
		cel.igluEpit();
		Main.tabs--;
	}
}

