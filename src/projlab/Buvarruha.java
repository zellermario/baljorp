package projlab;

import java.util.Map;

/**A buvarruha mukodeseert felelos osztaly*/
public class Buvarruha extends Targy {
	/**a konstruktor beallitja a megfelelo id-t az osben*/
	public Buvarruha() {
		super(0);
	}
	
	/**Ez a fuggveny a Buvarruha hasznalatat valositja meg. */
	public void hasznal(Szereplo sz) {
		if(sz.getJatek().getKivalasztott_mezo() == null) return; /**Ellenorizzuk, hogy lephetunk-e a kivalasztott mezore*/
		Mezo kurrens = sz.getKurrensMezo();
		for(Map.Entry<Integer, Mezo> entry : kurrens.getSzomszedos_mezok().entrySet()) {
			if(entry.getValue().getId() == sz.getJatek().getKivalasztott_mezo().getId()) {
				sz.getJatek().getKivalasztott_mezo().jatekosFogadas(sz);
				kurrens.jatekostorol(sz);
				return;
			}
		} 
	}
	//*Megfelelo kirajzolas*/
	public void rajzolTargy(Felulet f, Mezo m){
		f.rajzolBuvarruha(m);
	}
	/**Megfelelo kirajzolas*/
	public void rajzolTargyInv(Felulet f, Szereplo sz, int hanyadik){
		f.rajzolBuvarruhaInv(sz, hanyadik);
	}
}
