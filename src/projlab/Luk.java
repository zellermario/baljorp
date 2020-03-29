package projlab;

public class Luk extends Mezo{
	/**Ennek a függvénynek a visszatérési értékébõl tudhatjuk meg hogy ez luk.*/
	public int megvizsgal() {
		Main.tabs++;
		Main.log(this, "megvizsgal() : 0");
		Main.tabs--;
		return 0;
		}
	/**Ez a függvény a paraméterként átadott játékost a lukba helyezi.*/
	public void jatekoFogadas(Mezo cel) {}
	/**Ez a függvény valósítja meg a lukban lévõ játékosok kötéllel való kihúzását.*/
	public void kotellelKuld(Mezo cel) {
		Main.tabs++;
		Main.log(this, "kotellelKuld("+ Main.nameOf(cel)+")");
		cel.jatekosFogadas(jatekosok.get(0));
		Main.tabs--;
	}
	/**Ez a függvény felelõs az Iglu építésért, de itt nem csinál semmit mert lukban nem lehet építeni.*/
	public void igluEpit() {}
	/**Ezzel a függvénnyel lehet egy játékost másik mezõre küldeni.*/
	public void jatekosKuldes(Szereplo sz, Mezo cel) {
		Main.tabs++;
		Main.log(this, "jatekosKuldes("+ Main.nameOf(sz) +", "+ Main.nameOf(cel) +")");
		Main.tabs--;
	}
}