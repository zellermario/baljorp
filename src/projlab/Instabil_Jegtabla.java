package projlab;
import java.util.Random;
import java.util.Scanner;

public class Instabil_Jegtabla extends Mezo {
	/**A teherbirast megado mennyiseg*/
	private int teherbiras = 2;
	
	public Instabil_Jegtabla(int _id, Jatek j) {
		super(_id, j);
		Random rand = new Random();
		teherbiras = rand.nextInt(j.jatekosszam()) + 1;
	}
	
	/**Ez a fuggveny az adott jegtabla atfodulasat valositja meg.*/ 
	public void atfordul() {
		for(Szereplo i : jatekosok)
			i.halal();;
	}
	/**Ez a fuggveny visszaadja hogy az adott jegtablan hany jatekos fer el.*/
	public int megvizsgal() {
		return teherbiras - rajta_levo_jatekosok();
	}
	/**Ez a fuggveny a parameterkent atadott jatekost a jegtablara helyezi.*/
	public void jatekosFogadas(Szereplo sz) {
		super.jatekosFogadas(sz);
		if(teherbiras < rajta_levo_jatekosok()) atfordul();
	}
}
