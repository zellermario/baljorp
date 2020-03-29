package projlab;

public class Uresepulet extends Epitmeny{
	/**Ez a függvény az üres épület hatását valósítja meg hóvihar alatt.*/
	public void hatas() {
		
		Main.tabs++;
		Main.log(this, "hatas()");
		mezo.tovabbad();
		Main.tabs--;
	}
}
