package projlab;
import java.util.Scanner;

public class Instabil_Jegtabla extends Mezo {
	private int teherbiras = 2;
	
	/**Ez a függvény az adott jégtábla átfodulásást valósítja meg.*/ 
	public void atfordul() {
		Main.tabs++;
		Main.log(this, "atfordul()");
		//minden játékost megöl, aki rajta áll
		this.jatekosok.forEach((sz) -> sz.halal()); 
		Main.tabs--;
	}
	/**Ezt a függvényt visszaadja hogy az adott jégtáblán hány játékos fér el.*/
	public int megvizsgal() {
		Main.tabs++;
		Main.log(this, "megvizsgal() : teherbiras");
		return teherbiras;}
	/**Ez a függvény a paraméterként átadott játékost a jégtáblára helyezi.*/
	public void jatekosFogadas(Szereplo sz) {
		Main.tabs++;
		Main.log(this, "jatekosFogadas("+ Main.nameOf(sz) +")");
		jatekosok.add(sz);
		sz.setMezo(this);
		while(true) {
			// a felhasználó dönthet a kimenetelrõl
			Main.print("Átfordul a jégtábla a játékos fogadásakor? (i/n)");
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
