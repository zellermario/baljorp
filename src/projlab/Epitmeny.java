package projlab;
//az �p�tm�nyt�pusok viselked�s�t meghat�roz� absztrakt �soszt�ly
public abstract class  Epitmeny {
	/**Melyik mez�n van az �p�tm�ny*/
	protected Mezo mezo;
	public void setMezo(Mezo m) {
		mezo = m;
	}
	/**Ez a f�ggv�ny megval�s�tja egy �p�let hat�s�t a benne l�v� j�t�kosokra h�vihar alatt. */ 
	public void hatas() 
	{
		
	}
}
