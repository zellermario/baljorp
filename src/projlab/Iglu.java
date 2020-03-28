package projlab;

public class Iglu extends Epitmeny{
	public void hatas() {
		Main.tabs++;
		Main.log(this, "hatas()");
		Main.tabs--;
		return;
	}
}
