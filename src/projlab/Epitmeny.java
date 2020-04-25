package projlab;

public class Epitmeny {
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
	
	public void medve() {
		mezo.medvemegol();
	}
	
	public void rombol() {}
	
	public Mezo getMezo() {
		return mezo;
	}
	
}
