package projlab;
/**Az eszkimok viselkedeset megvalosito osztaly*/
public class Eszkimo extends Szereplo{
	/**Konstruktorban beallitjuk a megfelelo kezdoertekeket*/
	public Eszkimo(Jatek j, Mezo kezdomezo) {
		super(4, 5, j, kezdomezo);
	}
	/**Ez a fuggveny valositja meg az eszkimo kepesseget*/
	public void kepessegHasznal(Mezo cel) {
		if(sorszam != jatek.getAktualis() || munkamennyiseg == 0) return;
		cel.epit(new Iglu(this.getKurrensMezo()));
		munkamennyiseg--;
		jatek.addToCounter(1);
	}
	/**Tesztelest segito fuggveny*/
	public String toString() {
		return "Eszkimo";
	}
	
	public void rajzolSzereplo(Felulet f){
		f.rajzolEszkimo(kurrensmezo);
		int i = 1;
		for(Targy t : sajat_targyak) {
			t.rajzolTargyInv(f, this, i++);
		}
	}
}

