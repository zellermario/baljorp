package projlab;
/**Az epitmenyek kozos ososztalya*/
public abstract class Epitmeny {
	/**Melyik mezon van az epitmeny*/
	protected Mezo mezo;
	public Epitmeny(Mezo m) {
		mezo = m;
	}
	/**Ez a fuggveny megvalositja egy epulet hatasat a benne levo jatekosokra hovihar alatt. */ 
	public void hatas() 
	{
		mezo.tovabbad();
	}
	/**a medve hatasat ervenyesito fuggveny*/
	public void medve() {
		mezo.medvemegol();
	}
	/**A rombolasert felelos fuggveny - az ideiglenes epitmenyekben felul van definialva*/
	public void rombol() {}
	/**mezo attributum getterje*/
	public Mezo getMezo() {
		return mezo;
	}
	/**A teszteket segitendo fuggveny*/
	public abstract String toString();
	
	/**Megfelelo kirajzolas - implementacio a leszarmazottakban, ha kell*/
	public void rajzolEpitmeny(Felulet f, Mezo m){
		
	}
}
