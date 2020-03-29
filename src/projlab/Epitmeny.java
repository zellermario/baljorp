package projlab;
//az építménytípusok viselkedését meghatározó absztrakt õsosztály
public abstract class  Epitmeny {
	/**Melyik mezõn van az építmény*/
	protected Mezo mezo;
	public void setMezo(Mezo m) {
		mezo = m;
	}
	/**Ez a függvény megvalósítja egy épület hatását a benne lévõ játékosokra hóvihar alatt. */ 
	public void hatas() 
	{
		
	}
}
