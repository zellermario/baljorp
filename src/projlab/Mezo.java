package projlab;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Mezo {
	/**Mezõn lévõ hórétegek száma.*/
	private int horeteg;
	/**Mezõ azonosítója.*/
	private int id;
	/**Szomszédos mezõk.*/
	private Map<Integer, Mezo> szomszedos_mezok = new HashMap<Integer, Mezo>();
	/**A játék aminek a rész a mezõ.*/
	private Jatek jatek;
	/**A mezõben lévõ tárgy.*/
	private Targy belefagyott_targy;
	/**A mezõn lévõ épület.*/
	private Epitmeny epitmeny = new Uresepulet();
	/**A mezõn lévõ játékosok.*/
	protected List<Szereplo> jatekosok = new ArrayList<Szereplo>();
	
  //todo: itt konstruktorban jÃ¶jjÃ¶n lÃ©tre az Ã¼resÃ©pÃ¼let, vagy a tagvÃ¡ltozÃ³nÃ¡l?
	Mezo() {
		epitmeny = new Uresepulet();
		Main.names.put(epitmeny, "ÃœresÃ‰pÃ¼let");
		epitmeny.setMezo(this);
	}
	/**Ez a függvény a paraméterként adott játékost a mezõre helyezi.*/
	public void jatekosFogadas(Szereplo sz) {
		Main.tabs++;
		Main.log(this, "jatekosFogadas(" + Main.nameOf(sz) +")");
		jatekosok.add(sz);
		sz.setMezo(this);
		Main.tabs--;
	}
	/**Ez a függvény a paraméterként adott játékost, a paraméterként adott mezõre küldi.*/
	public void jatekosKuldes(Szereplo sz, Mezo cel) {
		Main.tabs++;
		Main.log(this, "jatekosKuldes("+ Main.nameOf(sz) +", "+ Main.nameOf(cel) +")");
		cel.jatekosFogadas(sz);
		Main.tabs--;
	}
	/**Ennek a függvénynek luk esetén van feladata.*/
	public void kotellelKuld(Mezo cel) {}
	
	/**Ez a függvény a paraméterként átadott mennyiségû réteg havat takarít el a mezõrõl.*/
	public void hoTakarit(int i) {
		Main.tabs++;
		Main.log(this, "hoTakarit(" + i +")");
		Main.tabs--;
	}
	/**Ez a függvény a paraméterként átadott játékosnak adja a mezõben lévõ tárgyat.*/
	public void targyAtad(Szereplo sz) {
		Main.tabs++;
		Main.log(this, "targyAtad(" + Main.nameOf(sz) + ")");
		belefagyott_targy.osszeszed();
		Main.tabs--;
	}
	/**Ez a függvény a hóvihar hatását valósítja meg a mezõn.*/
	public void hovihar() {
		Main.tabs++;
		Main.log(this, "hovihar()");
		epitmeny.hatas();
		Main.tabs--;
	}
	/**A mezõ teherbíró képességével tér vissza.*/
	public int megvizsgal() {return 1;}
	
	public boolean ellenoriz() {return true;}
	/**Ezzel a függvénnyel tudunk iglut építeni a mezõre.*/
	public void igluEpit() {
		Main.tabs++;
		Main.log(this, "igluEpit");
		this.epitmeny = new Iglu();
		Main.tabs--;
	}
	/**Ez a függvény hívja meg a mezõn álló játékosok megfelelõ metódusait, ha elkapja õket a hóvihar.*/
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
	
	public Mezo getSzomszed(int irany) {
		Main.tabs++;
		Main.log(this, "getSzomszed(" + irany + ") : " + Main.nameOf(szomszedos_mezok.get(irany)));
		Main.tabs--;
		return szomszedos_mezok.get(irany);
	}
	
	/* Ez a metÃ³dus csak a skeletonhoz van, hogy anÃ©lkÃ¼l hozzÃ¡ tudjunk adni szereplÃµt
	 * a mezÃµhÃ¶z az inicializÃ¡lÃ¡skor, hogy a konzolra logolnÃ¡nk a jatekosFogadas() metÃ³dussal. */
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
