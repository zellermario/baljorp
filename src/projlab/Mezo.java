package projlab;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

public abstract class Mezo {
	/**Mezon levo horetegek szama.*/
	protected int horeteg;
	/**Mezo azonositoja.*/
	private int id;
	/**Szomszedos mezok.*/
	private Map<Integer, Mezo> szomszedos_mezok = new TreeMap<Integer, Mezo>();
	/**A jatek aminek a resz a mezo.*/
	protected Jatek jatek;
	/**A mezoben levo targy.*/
	protected Targy belefagyott_targy;
	/**A mezon levo epulet.*/
	protected Epitmeny epitmeny;
	/**A mezon levo jatekosok.*/
	protected List<Szereplo> jatekosok = new ArrayList<Szereplo>();
	
	public String rajtalevok = "";
	
	protected int x, y;
	
	public void setCoord(int _x, int _y) {
		x = _x;
		y = _y;
		id = _x * 8 + _y;
	}
  //todo valasz: szerintem edesmindegy
	public Mezo(int _id, Jatek j) {
		id = _id;
		epitmeny = new Uresepulet(this);
		jatek = j;
		//Random rand = new Random();
		//horeteg = rand.nextInt(3) + 1;
	}
	public Jatek getJatek() {
		return jatek;
	}
	/**visszaadja a szomszedossagot tarolo strukturat*/
	public Map<Integer, Mezo> getSzomszedos_mezok() {
		return szomszedos_mezok;
	}
	/**ezzel a fuggvennyel adhatunk "kivulrol" hozza jatekost a mezohoz*/
	public void addJatekos(Szereplo sz) {
		jatekosok.add(sz);
	}
	/**Ez a fuggveny a parameterkent adott jatekost a mezore helyezi.*/
	public void jatekosFogadas(Szereplo sz) {
		jatekosok.add(sz);
		sz.setKurrensMezo(this);
		sz.munkamennyiseg = sz.munkamennyiseg - 1;
		jatek.addToCounter(1);
		if(sz.munkamennyiseg == 0) sz.munkamennyiseg = sz.maxmunka;
		ellenoriz();
		jatek.kepfrissites();
	}
	/**Ez a fuggveny a parameterkent adott jatekost, a parameterkent adott mezore kuldi.*/
	public void jatekosKuldes(Szereplo sz, Mezo cel) {
		if(cel == null) return;
		for( Map.Entry<Integer, Mezo> entry : szomszedos_mezok.entrySet()) {
			if(entry.getValue().getId() == cel.getId()) {
				cel.jatekosFogadas(sz);
				jatekosok.remove(sz);
				return;
			}
		} 
	}
	
	/**Ez a fuggveny a parameterkent atadott mennyisegu reteg havat takarit el a mezorol.*/
	public void hoTakarit(int i) {
		horeteg -= i;
		if(horeteg < 0) horeteg = 0;
	}
	/**Ez a fuggveny a parameterkent atadott jatekosnak adja a mezoben levo targyat.*/
	public void targyAtad(Szereplo sz) {
		if(horeteg == 0 && belefagyott_targy != null) {
			sz.AddTargy(belefagyott_targy);
			belefagyott_targy.osszeszed(sz);
			belefagyott_targy = null;
		}
	}
	/**Ez a fuggveny a hovihar hatasat valositja meg a mezon.*/
	public void hovihar() {
		horeteg++;
		epitmeny.hatas();
	}
	/**A mezo teherbiro kepessegevel ter vissza.*/
	abstract int megvizsgal();
	/**ellenorizzuk, hogy minden jatekos egy mezon all-e - ez a gyozelmi feltetelek egyike*/
	public void ellenoriz() {
		if(jatekosok.size() == jatek.jatekosszam()) jatek.gyozelem();
	}
	/**Ezzel a fuggvennyel tudunk kulonbozo epitmenyeket epiteni a mezore.*/
	public void epit(Epitmeny e) {
		epitmeny = e;
	}
	/**Ez a fuggveny hivja meg a mezon allo jatekosok megfelelo metodusait, ha elkapja oket a hovihar.*/
	public void tovabbad() {
		for(int i = 0; i < jatekosok.size(); i++) {
			jatekosok.get(i).hovihar();
		}
	}
	/**beallitja a mezo szomszedossagi kapcsolatat*/
	public void setSzomszed(int irany, Mezo szomszed) {
		szomszedos_mezok.put(irany, szomszed);
	}
	/**visszaadja a mezo adott iranyban levo szomszedjat*/
	public Mezo getSzomszed(int irany) {
		return szomszedos_mezok.get(irany);
	}
	
	/**a medvetamadast kezelo fuggveny, megnezi, az epuletek milyen hatassal vannak a medvere*/
	public void medvetamad() {
		epitmeny.medve();
	}
	/**ha az epulet nem vedi meg a jatekosokat, meghivodik ez a fuggveny es megoli oket*/
	void medvemegol() {
		for(int i = 0; i < jatekosok.size()-1; i++)
			jatekosok.get(i).halal();
	}
	/**az ideiglenes epitmenyt lerombolja a mezon*/
	void epuletRombol() {
		epitmeny.rombol();
	}
	/**olyan fuggveny, ami mindenkeppen atmozgatja a szereplot - csak a lukban kell*/
	/*public void atleptet(Szereplo sz, Mezo cel) {}*/

	/**visszaadja, hogy milyen targy van belefagyva a jegbe*/
	public Targy getTargy() {
		return belefagyott_targy;
	}
	/**beallitja a jegbefagyott targyat*/
	public void setTargy(Targy t) {
		this.belefagyott_targy = t;
	}
	/**beallitja a horeteget a mezon*/
	public void setHoreteg(int i) {
		horeteg = i;
	}
	/**visszaadja a mezon allo jatekosok szamat*/
	public int rajta_levo_jatekosok() {return jatekosok.size();}
	
	
	/**egyszeru getter*/
	public int getId() {
		return id;
	}
	/**egyszeru getter*/
	public int getHoreteg() {
		return horeteg;
	}
	
	/**egyszeru getter*/
	public Epitmeny getEpitmeny() {
		return epitmeny;
	}
	
	public void rajzolMezo(Felulet f) {
		
	}
	
	public void jatekostorol(Szereplo sz) {
		jatekosok.remove(sz);
	}
  
}
