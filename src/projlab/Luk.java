package projlab;

public class Luk extends Mezo{
	/**Ennek a f�ggv�nynek a visszat�r�si �rt�k�b�l tudhatjuk meg hogy ez luk.*/
	public int megvizsgal() {
		Main.tabs++;
		Main.log(this, "megvizsgal() : 0");
		Main.tabs--;
		return 0;
		}
	/**Ez a f�ggv�ny a param�terk�nt �tadott j�t�kost a lukba helyezi.*/
	public void jatekoFogadas(Mezo cel) {}
	/**Ez a f�ggv�ny val�s�tja meg a lukban l�v� j�t�kosok k�t�llel val� kih�z�s�t.*/
	public void kotellelKuld(Mezo cel) {
		Main.tabs++;
		Main.log(this, "kotellelKuld("+ Main.nameOf(cel)+")");
		cel.jatekosFogadas(jatekosok.get(0));
		Main.tabs--;
	}
	/**Ez a f�ggv�ny felel�s az Iglu �p�t�s�rt, de itt nem csin�l semmit mert lukban nem lehet �p�teni.*/
	public void igluEpit() {}
	/**Ezzel a f�ggv�nnyel lehet egy j�t�kost m�sik mez�re k�ldeni.*/
	public void jatekosKuldes(Szereplo sz, Mezo cel) {
		Main.tabs++;
		Main.log(this, "jatekosKuldes("+ Main.nameOf(sz) +", "+ Main.nameOf(cel) +")");
		Main.tabs--;
	}
}