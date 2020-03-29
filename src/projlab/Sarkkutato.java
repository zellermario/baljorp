package projlab;

public class Sarkkutato extends Szereplo{
	/**Ez a függvény a sarkkutató képességét valósítja meg.*/ 
	public void kepessegHasznal(Mezo cel) {
	Main.tabs++;
	Main.log(this, "kepessegHasznal("+ Main.nameOf(cel) + ")");
	int teherbiras = cel.megvizsgal();
	Main.tabs--;
	}
}

	
