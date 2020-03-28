package projlab;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Mezo {
	private int horeteg;
	private int id;
	private Map<Integer, Mezo> szomszedos_mezok = new HashMap<Integer, Mezo>();
	private Jatek jatek;
	private List<Targy> belefagyott_targyak = new ArrayList<Targy>();
	private Epitmeny epitmeny;
	private List<Szereplo> jatekosok = new ArrayList<Szereplo>();
	
	public void jatekosFogadas(Szereplo sz) {
		Main.tabs++;
		Main.print("jatekosFogadas()");
		jatekosok.add(sz);
		sz.setMezo(this);
		Main.tabs--;
	}
	public void jatekosKuldes(Szereplo sz, Mezo cel) {
		Main.tabs++;
		Main.print("jatekosKuldes()");
		cel.jatekosFogadas(sz);
		Main.tabs--;
	}
	public void kotellelKüld(Mezo cel) {}
	public void targyAtad(Szereplo sz) {}
	public void hovihar() {}
	public void hoTakarit() {}
	public int megvizsgal() {return 1;}
	public boolean ellenoriz() {return true;}
	public void igluEpit() {}
	public void tovabbad() {}
	public void setSzomszed(int irany, Mezo szomszed) {
		szomszedos_mezok.put(irany, szomszed);
	}
	public Mezo getSzomszed(int irany) {
		Main.tabs++;
		Main.print("getSzomszed()");
		Main.tabs--;
		return szomszedos_mezok.get(irany);
	}
	public void AddJatekos(Szereplo sz) {
		jatekosok.add(sz);
		sz.setMezo(this);
	}
}
