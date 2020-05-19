package projlab;

import java.util.Map;

/**a sarkkutato viselkedeset megvalosito osztaly*/
public class Sarkkutato extends Szereplo{
	
	public Sarkkutato(Jatek j, Mezo kezdomezo) {
		super(4, 4, j, kezdomezo);
	}
	
	/**Ez a fuggveny a sarkkutato kepesseget valositja meg.*/ 
	public void kepessegHasznal() {
		Mezo cel = jatek.getKivalasztott_mezo();
		if(sorszam != jatek.getAktualis() || munkamennyiseg == 0) return;
		for( Map.Entry<Integer, Mezo> entry : kurrensmezo.getSzomszedos_mezok().entrySet()) {
			if(entry.getValue().getId() == cel.getId()) {
				int teher = cel.szereploVizsgal();
				if(teher == -1)
					cel.rajtalevok += "ST";
				else if(teher == 0)
					cel.rajtalevok += "LUK";
				else
					cel.rajtalevok += " "+ teher;
				munkamennyiseg--;
				if(munkamennyiseg == 0) munkamennyiseg = maxmunka;
				jatek.addToCounter(1);
				return;
			}
		}

	}
	/**a tesztelest segito fuggveny*/
	public String toString() {
		return "Sarkkutato";
	}
	
	public void rajzolSzereplo(Felulet f){
		f.rajzolSarkkutato(kurrensmezo);
		f.rajzolSarkkutato(sorszam, testho, munkamennyiseg);
		if(sorszam != jatek.getAktualis()) return;
		int i = 1;
		for(Targy t : sajat_targyak) {
			t.rajzolTargyInv(f, this, i++);
		}
	
	}
}

	
