package projlab;

public class Iglu extends Epitmeny{

	public Iglu() {
		Main.tabs++;
		Main.print("<<destroy>> Uresepulet");
		Main.print("<<create>> Iglu");
		Main.tabs--;
	}
	/**Ez a függvény az iglu hatásást valósítja meg a benne jévõ játékosokra hóvihar alatt.*/
	public void hatas() {
		//ha van iglu az adott mezõn, akkor a hóviharnak nincsen hatása
		Main.tabs++;
		Main.log(this, "hatas()");
		Main.tabs--;
		return;
	}

}
