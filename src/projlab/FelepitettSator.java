package projlab;
/**Ideiglenes epuletet (Satort) megvalosito osztaly*/
public class FelepitettSator extends Epitmeny {
	/**Melyik mezon van az epitmeny*/
	public FelepitettSator(Mezo m) {
		super(m);
	}
	/**ez a fuggveny teszi semmisse a hovihar hatasat*/
	public void hatas() {}
	
	/**ezzel a fuggvennyel romboljuk le a satrat - epitunk helyette egy uresepuletet*/
	public void rombol() {
		getMezo().epit(new Uresepulet(getMezo()));
	}
	/**Tesztelest segito fuggveny*/
	public String toString() {
		return "FelepitettSator";
	}
}
