package projlab;
import java.util.Scanner;

public class Instabil_Jegtabla extends Mezo {
	private int teherbiras = 2;
	
	/**Ez a f�ggv�ny az adott j�gt�bla �tfodul�s�st val�s�tja meg.*/ 
	public void atfordul() {
		Main.tabs++;
		Main.log(this, "atfordul()");
		//minden j�t�kost meg�l, aki rajta �ll
		this.jatekosok.forEach((sz) -> sz.halal()); 
		Main.tabs--;
	}
	/**Ezt a f�ggv�nyt visszaadja hogy az adott j�gt�bl�n h�ny j�t�kos f�r el.*/
	public int megvizsgal() {
		Main.tabs++;
		Main.log(this, "megvizsgal() : teherbiras");
		return teherbiras;}
	/**Ez a f�ggv�ny a param�terk�nt �tadott j�t�kost a j�gt�bl�ra helyezi.*/
	public void jatekosFogadas(Szereplo sz) {
		Main.tabs++;
		Main.log(this, "jatekosFogadas("+ Main.nameOf(sz) +")");
		jatekosok.add(sz);
		sz.setMezo(this);
		while(true) {
			// a felhaszn�l� d�nthet a kimenetelr�l
			Main.print("�tfordul a j�gt�bla a j�t�kos fogad�sakor? (i/n)");
			String ans = Main.scanner.next();
			if (ans.equals("i")) {
				atfordul();
				break;
			} else if (ans.equals("n")) {
				break;
			}
		}
		Main.tabs--;
	}
}
