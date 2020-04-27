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
	private Jatek jatek;
	/**A mezoben levo targy.*/
	private Targy belefagyott_targy;
	/**A mezon levo epulet.*/
	private Epitmeny epitmeny;
	/**A mezon levo jatekosok.*/
	protected List<Szereplo> jatekosok = new ArrayList<Szereplo>();
	
  //todo valasz: szerintem edesmindegy
	public Mezo(int _id, Jatek j) {
		id = _id;
		epitmeny = new Uresepulet(this);
		jatek = j;
		//Random rand = new Random();
		//horeteg = rand.nextInt(3) + 1;
	}
	/**visszaadja a szomszedossagot tarolo strukturat*/
	public Map<Integer, Mezo> getSzomszedos_mezok() {
		return szomszedos_mezok;
	}

	/**Ez a fuggveny a parameterkent adott jatekost a mezore helyezi.*/
	public void jatekosFogadas(Szereplo sz) {
		jatekosok.add(sz);
		sz.setKurrensMezo(this);
		ellenoriz();
	}
	/**Ez a fuggveny a parameterkent adott jatekost, a parameterkent adott mezore kuldi.*/
	public void jatekosKuldes(Szereplo sz, Mezo cel) {
		 cel.jatekosFogadas(sz);
		 jatekosok.remove(sz);
	}
	
	/**Ez a fuggveny a parameterkent atadott mennyisegu reteg havat takarit el a mezorol.*/
	public void hoTakarit(int i) {
		horeteg -= i;
		if(horeteg < 0) horeteg = 0;
	}
	/**Ez a fuggveny a parameterkent atadott jatekosnak adja a mezoben levo targyat.*/
	public void targyAtad(Szereplo sz) {
		if(horeteg == 0) {
			sz.AddTargy(belefagyott_targy);;
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
		for(Szereplo i : jatekosok)
			i.hovihar();
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
		for(Szereplo i : jatekosok)
			i.halal();
	}
	/**az ideiglenes epitmenyt lerombolja a mezon*/
	void epuletRombol() {
		epitmeny.rombol();
	}
	/**olyan fuggveny, ami mindenkeppen atmozgatja a szereplot - csak a lukban kell*/
	public void atleptet(Szereplo sz, Mezo cel) {}

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
	
	
	/**a kotellel valo menekitest valositja meg ez a fuggveny*/
	public void kiment_mindenkit(Mezo cel) {
		for(Szereplo sz : jatekosok) {
			atleptet(sz,cel);
			jatekosok.remove(sz);
		}
	}

	public int getId() {
		return id;
	}

	public int getHoreteg() {
		return horeteg;
	}
	
  
}
