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
	private Targy belefagyott_targy;
	private Epitmeny epitmeny = new Uresepulet();
	protected List<Szereplo> jatekosok = new ArrayList<Szereplo>();
	
  //todo: itt konstruktorban jöjjön létre az üresépület, vagy a tagváltozónál?
	Mezo() {
		epitmeny = new Uresepulet();
		Main.names.put(epitmeny, "ÜresÉpület");
		epitmeny.setMezo(this);
	}
	
	public void jatekosFogadas(Szereplo sz) {
		Main.tabs++;
		Main.log(this, "jatekosFogadas(" + Main.nameOf(sz) +")");
		jatekosok.add(sz);
		sz.setMezo(this);
		Main.tabs--;
	}
	public void jatekosKuldes(Szereplo sz, Mezo cel) {
		Main.tabs++;
		Main.log(this, "jatekosKuldes("+ Main.nameOf(sz) +", "+ Main.nameOf(cel) +")");
		cel.jatekosFogadas(sz);
		Main.tabs--;
	}
  
	public void kotellelKuld(Mezo cel) {}
  
	public void hovihar() {}
	public void hoTakarit(int i) {
		Main.tabs++;
		Main.log(this, "hoTakarit(" + i +")");
		Main.tabs--;
	}

	public void targyAtad(Szereplo sz) {
		Main.tabs++;
		Main.log(this, "targyAtad(" + Main.nameOf(sz) + ")");
		belefagyott_targy.osszeszed();
		Main.tabs--;
	}
	
	public void hovihar() {
		Main.tabs++;
		Main.log(this, "hovihar()");
		epitmeny.hatas();
		Main.tabs--;
	}
	public void hoTakarit(int i) {
		Main.tabs++;
		Main.log(this, "hoTakarit("+i+")");
		horeteg-=i;
		Main.tabs--;
	}
  
	public int megvizsgal() {return 1;}
	
	public boolean ellenoriz() {return true;}

	public void igluEpit() {
		Main.tabs++;
		Main.log(this, "igluEpit");
		this.epitmeny = new Iglu();
		Main.tabs--;
	}
  
	/*todo: ezt asszem ki lehet majd törölni, ez is kétszer van*/
	//public void igluEpit() {
	//	epitmeny = new Iglu();
	//	Main.names.put(epitmeny, "Iglu");
	//}
  
	public void tovabbad() {
		Main.tabs++;
		Main.log(this, "tovabbad()");
		for(Szereplo sz : jatekosok) {
			sz.hovihar();	
		}
		Main.tabs--;
	}

	public void setSzomszed(int irany, Mezo szomszed) {
		szomszedos_mezok.put(irany, szomszed);
	}
	
	public void addTargy(Targy t) {
		belefagyott_targyak.add(t);
	}
	
	public Mezo getSzomszed(int irany) {
		Main.tabs++;
		Main.log(this, "getSzomszed(" + irany + ") : " + Main.nameOf(szomszedos_mezok.get(irany)));
		Main.tabs--;
		return szomszedos_mezok.get(irany);
	}
	
	/* Ez a metódus csak a skeletonhoz van, hogy anélkül hozzá tudjunk adni szereplõt
	 * a mezõhöz az inicializáláskor, hogy a konzolra logolnánk a jatekosFogadas() metódussal. */
	public void AddJatekos(Szereplo sz) {
		jatekosok.add(sz);
		sz.setMezo(this);
	}

	public Targy getTargy() {
		return belefagyott_targy;
	}
	public void setTargy(Targy t) {
		this.belefagyott_targy = t;
	}
	public void setHoreteg(int i) {
		horeteg = i;
	}
  
}
