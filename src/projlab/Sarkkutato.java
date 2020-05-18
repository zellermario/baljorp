package projlab;
/**a sarkkutato viselkedeset megvalosito osztaly*/
public class Sarkkutato extends Szereplo{
	
	public Sarkkutato(Jatek j, Mezo kezdomezo) {
		super(4, 4, j, kezdomezo);
	}
	
	/**Ez a fuggveny a sarkkutato kepesseget valositja meg.*/ 
	public void kepessegHasznal(Mezo cel) {
		if(sorszam != jatek.getAktualis() || munkamennyiseg == 0) return;
		int teher = cel.megvizsgal();
		if (teher == -2) teher += 2;
		munkamennyiseg--;
		jatek.addToCounter(1);
	}
	/**a tesztelest segito fuggveny*/
	public String toString() {
		return "Sarkkutato";
	}
	
	public void rajzolSzereplo(Felulet f){
		f.rajzolSarkkutato(kurrensmezo);
		f.rajzolSarkkutato(sorszam, testho);
		int i = 1;
		for(Targy t : sajat_targyak) {
			t.rajzolTargyInv(f, this, i++);
		}
	}
}

	
