package projlab;

import java.util.Map;

public class Kotel extends Targy {

	public Kotel() {
		super(2);
	}
	
	/**Ez a fuggveny a kotel hasznalatat valositja meg. */
	public void hasznal(Szereplo sz) {
		 Map<Integer, Mezo> szomszedok =  sz.getKurrensMezo().getSzomszedos_mezok();
		for( Map.Entry<Integer, Mezo> entry : szomszedok.entrySet()) {
			if(entry.getValue().megvizsgal() == 0) {
				entry.getValue().kiment_mindenkit(sz.getKurrensMezo());
			}
		}
	}	
}
