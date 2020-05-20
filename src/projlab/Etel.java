package projlab;
/**Az etel mukodeseert felelos osztaly*/
public class Etel extends Targy{
	/**a konstruktor beallitja a megfelelo id-t az osben*/
	public Etel(){
		super(1);
	}
	
	/**Ez a fuggveny az etel felszedesevel jaro valtozasokat valositja meg.*/
	public void osszeszed(Szereplo sz) {
		sz.eves();
		sz.targyTorol(this);
	}
	//*Megfelelo kirajzolas*/
	public void rajzolTargy(Felulet f, Mezo m){
		f.rajzolEtel(m);
	}
	/**Megfelelo kirajzolas*/
	public void rajzolTargyInv(Felulet f, Szereplo sz, int hanyadik){
	
	}	
	
}
