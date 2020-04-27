package projlab;
/**Az iglu mukodeset megvalosito osztaly*/
public class Iglu extends Epitmeny{
	/**Melyik mezon van az epitmeny*/
	public Iglu(Mezo m) {
		super(m);
	}
	/**Ez a fuggveny az iglu hatasast valositja meg a benne jevo jatekosokra hovihar alatt.*/
	public void hatas() {}
	/**Ez a fuggveny teszi semmisse a medve hatasat, ha a mezon iglu van*/
	public void medve() {}
	/**Tesztelest segito fuggveny*/
	public String toString() {
		return "Iglu";
	}

}
