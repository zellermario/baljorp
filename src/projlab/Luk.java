package projlab;

public class Luk extends Mezo{	
	public int megvizsgal() {
		Main.tabs++;
		Main.log(this, "megvizsgal() : 0");
		Main.tabs--;
		return 0;
		}
	public void jatekoFogadas(Mezo cel) {}
	public void kotellelKuld(Mezo cel) {}
	public void igluEpit() {}
}