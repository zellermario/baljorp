package projlab;

public class Uresepulet extends Epitmeny{
	/**Ez a f�ggv�ny az �res �p�let hat�s�t val�s�tja meg h�vihar alatt.*/
	public void hatas() {
		
		Main.tabs++;
		Main.log(this, "hatas()");
		mezo.tovabbad();
		Main.tabs--;
	}
}
