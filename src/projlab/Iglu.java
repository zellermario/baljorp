package projlab;

public class Iglu extends Epitmeny{

	public Iglu() {
		Main.tabs++;
		Main.print("<<destroy>> Uresepulet");
		Main.print("<<create>> Iglu");
		Main.tabs--;
	}
	/**Ez a f�ggv�ny az iglu hat�s�st val�s�tja meg a benne j�v� j�t�kosokra h�vihar alatt.*/
	public void hatas() {
		Main.tabs++;
		Main.log(this, "hatas()");
		Main.tabs--;
		return;
	}

}
