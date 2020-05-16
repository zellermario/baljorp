package projlab;
/**A targyakat osszefogo ososztaly*/
public class Targy {
	/**A targy azonositoja.*/
	private int id;
	/**beallitjuk a megfelelo id-t a leszarmazottaktol fuggoen*/
	public Targy(int _id) {
		id = _id;
	}
	/**Ez a fuggveny a targy hasznalatat valositja meg.*/
	public void hasznal(Szereplo sz) {}
	/**Ez a fuggveny a targy felvetelenek hatasast valositja meg.*/
	public void osszeszed(Szereplo sz) {}
	/**az id gettere*/
	public int getId() {return id;}
	
	public void rajzolTargy(Felulet f, Mezo m){
		
	}
	
	public void rajzolTargyInv(Felulet f, Szereplo sz, int hanyadik){
		
	}
}
