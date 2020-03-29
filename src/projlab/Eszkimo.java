package projlab;

public class Eszkimo extends Szereplo{
	public void kepessegHasznal(Mezo cel) {
		Main.tabs++;
		Main.log(this, "kepessegHasznal(" + Main.nameOf(cel) +")");
		cel.igluEpit();
		Main.tabs--;
	}
}

