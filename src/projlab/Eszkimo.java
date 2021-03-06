package projlab;
/**Az eszkimok viselkedeset megvalosito osztaly*/
public class Eszkimo extends Szereplo{
	/**Konstruktorban beallitjuk a megfelelo kezdoertekeket*/
	public Eszkimo(Jatek j, Mezo kezdomezo) {
		super(4, 5, j, kezdomezo);
	}
	/**Ez a fuggveny valositja meg az eszkimo kepesseget*/
	public void kepessegHasznal() {
		if(sorszam != jatek.getAktualis() || munkamennyiseg == 0) return;
		kurrensmezo.epit(new Iglu(this.getKurrensMezo()));
		munkamennyiseg--;
		if(munkamennyiseg == 0) munkamennyiseg = maxmunka; /**Ha elfogy a munka, visszaallitjuk, hisz ekkor a kovetkezo jatekos jon*/
		jatek.addToCounter(1);
		jatek.kivalasztott(null);
		jatek.kepfrissites();
	}
	/**Tesztelest segito fuggveny*/
	public String toString() {
		return "Eszkimo";
	}
	/**Megfelelo kirajzolas, meghivja azon targyak kirajzolasat is, amik nala vannak*/
	public void rajzolSzereplo(Felulet f){
		f.rajzolEszkimo(kurrensmezo);
		f.rajzolEszkimo(sorszam, testho, munkamennyiseg);
		if(sorszam != jatek.getAktualis()) return;
		int i = 1;
		for(Targy t : sajat_targyak) {
			t.rajzolTargyInv(f, this, i++);
		}
	}
}

