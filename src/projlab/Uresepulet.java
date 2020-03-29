package projlab;

public class Uresepulet extends Epitmeny{
	/**Ez a függvény az üres épület hatását valósítja meg hóvihar alatt.*/
	public void hatas() {
		//az Üresépület hatása, hogy a játékosokat eléri a hóvihar, ezért továbbítja azt feléjük
		Main.tabs++;
		Main.log(this, "hatas()");
		mezo.tovabbad();
		Main.tabs--;
	}
}
