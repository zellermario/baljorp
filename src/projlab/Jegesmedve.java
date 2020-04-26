package projlab;

public class Jegesmedve extends Szereplo {
	private boolean halott; 
	public Jegesmedve(Jatek j, Mezo kezdomezo) {
		super(1, 1, j, kezdomezo);
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
	
	public String toString() {
		return "Jegesmedve";
	}
}
