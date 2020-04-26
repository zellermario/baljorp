package projlab;

public class TorekenyAso extends Lapat {
	/**nyilvantartjuk, hanyszor hasznalhato meg a targy*/
	private int tartossag; 
	/**tartossag beallitasa konstruktorban*/
	public TorekenyAso() {
		tartossag = 3;
	}
	/**a targy hasznalatat megvalosito fuggveny*/
	public void hasznal(Szereplo sz) {
		sz.hoTakaritas(2);
		tartossag--;
		if(tartossag == 0) {
			sz.targyTorol(this);
		}
	}
}
