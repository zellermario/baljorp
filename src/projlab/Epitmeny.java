package projlab;

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
	
	public void rombol() {}
	
	public Mezo getMezo() {
		return mezo;
	}
	public abstract String toString();
	
}
