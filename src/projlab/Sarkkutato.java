package projlab;
/**a sarkkutato viselkedeset megvalosito osztaly*/
public class Sarkkutato extends Szereplo{
	
	public Sarkkutato(Jatek j, Mezo kezdomezo) {
		super(4, 4, j, kezdomezo);
	}
	
	/**Ez a fuggveny a sarkkutato kepesseget valositja meg.*/ 
	public void kepessegHasznal() {
		Mezo cel = jatek.getKivalasztott_mezo();
		if(sorszam != jatek.getAktualis() || munkamennyiseg == 0) return;
		int teher = cel.megvizsgal();
		cel.rajtalevok += " " + teher;
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
		if(sorszam != jatek.getAktualis()) return;
		int i = 1;
		for(Targy t : sajat_targyak) {
			t.rajzolTargyInv(f, this, i++);
		}
	}
}

	
