package projlab;

public class FelepitettSator extends Epitmeny {

	public FelepitettSator(Mezo m) {
		super(m);
	}
	
	public void hatas() {}
	
	public void rombol() {
		getMezo().epit(new Uresepulet(getMezo()));
	}
	
	public String toString() {
		return "FelepitettSator";
	}
}
