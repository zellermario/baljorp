package projlab;

public class Sarkkutato extends Szereplo{
	
	public Sarkkutato(Jatek j) {
		super(4, 4, j);
	}
	
	/**Ez a fuggveny a sarkkutato kepesseget valositja meg.*/ 
	public void kepessegHasznal(Mezo cel) {
		int teher = cel.megvizsgal();
		munkamennyiseg--;
	}
}

	
