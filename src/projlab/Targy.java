package projlab;
//tárgytípusok viselkedését meghatározó absztrakt õsosztály
public abstract class Targy {
	/**A tárgy azonosítója.*/
	private int id;
	/**Ez a függvény a tárgy használatát valósítja meg.*/
	public void hasznal(Szereplo sz) {}
	/**Ez a függvény a tárgy felvételének hatásást valósítja meg.*/
	public void osszeszed(Szereplo sz) {}
}
