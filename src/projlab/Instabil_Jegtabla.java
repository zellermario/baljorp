package projlab;

public class Instabil_Jegtabla extends Mezo {
	private int teherbiras;
	
	public void atfordul() {
		Main.tabs++;
		Main.log(this, "atfordul()");
		this.jatekosok.forEach((sz) -> sz.halal()); 
		Main.tabs--;
	}
	public int megvizsgal() {return 1;}
	public void jatekosFogadas(Szereplo sz) {
		Main.tabs++;
		Main.log(this, "jatekosFogadas("+ Main.nameOf(sz) +")");
		jatekosok.add(sz);
		sz.setMezo(this);
		while(true) {
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
