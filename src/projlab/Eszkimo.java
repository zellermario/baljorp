package projlab;

public class Eszkimo extends Szereplo{
	
	public Eszkimo(Jatek j, Mezo kezdomezo) {
		super(4, 5, j, kezdomezo);
	}
	/**Ez a fuggveny valositja meg az eszkimo kepesseget*/
	public void kepessegHasznal(Mezo cel) {
		if(sorszam != jatek.getAktualis() || munkamennyiseg == 0) return;
		cel.epit(new Iglu(this.getKurrensMezo()));
		munkamennyiseg--;
		jatek.addToCounter(1);
	}
	public String toString() {
		return "Eszkimo";
	}
}

