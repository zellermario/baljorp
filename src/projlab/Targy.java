package projlab;
//t�rgyt�pusok viselked�s�t meghat�roz� absztrakt �soszt�ly
public abstract class Targy {
	/**A t�rgy azonos�t�ja.*/
	private int id;
	/**Ez a f�ggv�ny a t�rgy haszn�lat�t val�s�tja meg.*/
	public void hasznal(Szereplo sz) {}
	/**Ez a f�ggv�ny a t�rgy felv�tel�nek hat�s�st val�s�tja meg.*/
	public void osszeszed(Szereplo sz) {}
}
