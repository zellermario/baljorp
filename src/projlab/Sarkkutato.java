package projlab;

public class Sarkkutato extends Szereplo{
	/**Ez a f�ggv�ny a sarkkutat� k�pess�g�t val�s�tja meg.*/ 
	public void kepessegHasznal(Mezo cel) {
	Main.tabs++;
	Main.log(this, "kepessegHasznal("+ Main.nameOf(cel) + ")");
	int teherbiras = cel.megvizsgal();
	Main.tabs--;
	}
}

	
