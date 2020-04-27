package projlab;
import java.util.Random;
import java.util.Scanner;
/**Az instabil jegtablak viselkedeset megvalosito osztaly*/
public class Instabil_Jegtabla extends Mezo {
	/**A teherbirast megado mennyiseg*/
	private int teherbiras = 2;
	
	public Instabil_Jegtabla(Jatek j, int horeteg, int teherbiras) {
		super(2, j);
		//Random rand = new Random();
		this.teherbiras = teherbiras;
		this.horeteg = horeteg;
	}
	
	/**Ez a fuggveny az adott jegtabla atfodulasat valositja meg.*/ 
	public void atfordul() {
		for(Szereplo i : jatekosok)
			i.halal();
	}
	/**Ez a fuggveny visszaadja hogy az adott jegtablan hany jatekos fer el.*/
	public int megvizsgal() {
		if (teherbiras - rajta_levo_jatekosok() == 0) return -2;
		return teherbiras - rajta_levo_jatekosok();
	}
	/**Ez a fuggveny a parameterkent atadott jatekost a jegtablara helyezi.*/
	public void jatekosFogadas(Szereplo sz) {
		//super.jatekosFogadas(sz);
		jatekosok.add(sz);
		sz.setKurrensMezo(this);
		if(!(teherbiras >= rajta_levo_jatekosok())) atfordul();
		ellenoriz();
	}
	/** A jegtabla teherbirasat adja vissza */
	public int getTeherbiras() { return teherbiras; }
}
