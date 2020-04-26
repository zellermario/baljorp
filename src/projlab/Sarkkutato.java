package projlab;

public class Sarkkutato extends Szereplo{
	
	public Sarkkutato(Jatek j, Mezo kezdomezo) {
		super(4, 4, j, kezdomezo);
	}
	
	/**Ez a fuggveny a sarkkutato kepesseget valositja meg.*/ 
	public void kepessegHasznal(Mezo cel) {
		int teher = cel.megvizsgal();
	}
	
	public String toString() {
		return "Sarkkutato";
	}
}

	
