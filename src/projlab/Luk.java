package projlab;

public class Luk extends Mezo{	
	public int megvizsgal() {
		Main.tabs++;
		Main.log(this, "megvizsgal() : 0");
		Main.tabs--;
		return 0;
		}
	public void jatekoFogadas(Mezo cel) {}
	public void kotellelKuld(Mezo cel) {
		Main.tabs++;
		Main.log(this, "kotellelKuld("+ Main.nameOf(cel)+")");
		cel.jatekosFogadas(jatekosok.get(0));
		Main.tabs--;
	}
	public void igluEpit() {}
	public void jatekosKuldes(Szereplo sz, Mezo cel) {
		Main.tabs++;
		Main.log(this, "jatekosKuldes("+ Main.nameOf(sz) +", "+ Main.nameOf(cel) +")");
		Main.tabs--;
	}
}