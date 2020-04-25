package projlab;

public class Jegesmedve extends Szereplo {
	private boolean halott; 
	public Jegesmedve(Jatek j) {
		super(1, 1, j);
		halott = false;
	}
	
	public void kor() {}
	
	public void halal() {
		halott = true;
	}
	
	public void tamad() {
		getKurrensMezo().medvetamad();
	}
	
	public void hovihar() {}
}
