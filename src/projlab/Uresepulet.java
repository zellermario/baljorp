package projlab;

public class Uresepulet extends Epitmeny{
	/**Ez a f�ggv�ny az �res �p�let hat�s�t val�s�tja meg h�vihar alatt.*/
	public void hatas() {
		//az �res�p�let hat�sa, hogy a j�t�kosokat el�ri a h�vihar, ez�rt tov�bb�tja azt fel�j�k
		Main.tabs++;
		Main.log(this, "hatas()");
		mezo.tovabbad();
		Main.tabs--;
	}
}
