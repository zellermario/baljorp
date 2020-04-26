package projlab;

public class Eszkimo extends Szereplo{
	
	public Eszkimo(Jatek j, Mezo kezdomezo) {
		super(4, 5, j, kezdomezo);
	}
	/**Ez a fuggveny valositja meg az eszkimo kepesseget*/
	public void kepessegHasznal(Mezo cel) {
		cel.epit(new Iglu(this.getKurrensMezo()));
	}
	public String toString() {
		return "Eszkimo";
	}
}

