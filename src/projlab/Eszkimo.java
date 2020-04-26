package projlab;

public class Eszkimo extends Szereplo{
	
	public Eszkimo( Jatek j) {
		super(4, 5, j);
	}
	/**Ez a fuggveny valositja meg az eszkimo kepesseget*/
	public void kepessegHasznal(Mezo cel) {
		cel.epit(new Iglu(this.getKurrensMezo()));
		munkamennyiseg--;
	}
}

