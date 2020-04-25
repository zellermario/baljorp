package projlab;

public class Etel extends Targy{
	
	public Etel(int _id){
		super(_id);
	}
	
	/**Ez a fuggveny az etel felszedesevel jaro valtozasokat valositja meg.*/
	public void osszeszed(Szereplo sz) {
		sz.eves();
	}
}
