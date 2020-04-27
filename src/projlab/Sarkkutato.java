package projlab;

public class Sarkkutato extends Szereplo{
	
	public Sarkkutato(Jatek j, Mezo kezdomezo) {
		super(4, 4, j, kezdomezo);
	}
	
	/**Ez a fuggveny a sarkkutato kepesseget valositja meg.*/ 
	public void kepessegHasznal(Mezo cel) {
		if(sorszam != jatek.getAktualis() || munkamennyiseg == 0) return;
		int teher = cel.megvizsgal();
		if (teher == -2) teher += 2;
		munkamennyiseg--;
		jatek.addToCounter(1);
	}
	
	public String toString() {
		return "Sarkkutato";
	}
}

	
