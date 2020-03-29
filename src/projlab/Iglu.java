package projlab;

public class Iglu extends Epitmeny{

	public Iglu() {
		Main.tabs++;
		Main.print("<<destroy>> Uresepulet");
		Main.print("<<create>> Iglu");
		Main.tabs--;
	}
	public void hatas() {
		Main.tabs++;
		Main.log(this, "hatas()");
		Main.tabs--;
		return;
	}

}
