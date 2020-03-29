package projlab;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//a mez�t�pusok viselked�s�t meghat�roz� absztrakt �soszt�ly
public abstract class Mezo {
	/**Mez�n l�v� h�r�tegek sz�ma.*/
	private int horeteg;
	/**Mez� azonos�t�ja.*/
	private int id;
	/**Szomsz�dos mez�k.*/
	private Map<Integer, Mezo> szomszedos_mezok = new HashMap<Integer, Mezo>();
	/**A j�t�k aminek a r�sz a mez�.*/
	private Jatek jatek;
	/**A mez�ben l�v� t�rgy.*/
	private Targy belefagyott_targy;
	/**A mez�n l�v� �p�let.*/
	private Epitmeny epitmeny = new Uresepulet();
	/**A mez�n l�v� j�t�kosok.*/
	protected List<Szereplo> jatekosok = new ArrayList<Szereplo>();
	
   //alap�rtelmezetten minden �p�let �res, ezt jelzi az �res�p�let is
	Mezo() {
		epitmeny = new Uresepulet();
		Main.names.put(epitmeny, "ÜresÉp�let");
		epitmeny.setMezo(this);
	}
	/**Ez a f�ggv�ny a param�terk�nt adott j�t�kost a mez�re helyezi.*/
	public void jatekosFogadas(Szereplo sz) {
		Main.tabs++;
		Main.log(this, "jatekosFogadas(" + Main.nameOf(sz) +")");
		//felveszi a Mez� a j�t�kost mag�ba �s �t�ll�tja annak megfelle� attrib�tumait
		jatekosok.add(sz);
		sz.setMezo(this);
		Main.tabs--;
	}
	/**Ez a f�ggv�ny a param�terk�nt adott j�t�kost, a param�terk�nt adott mez�re k�ldi.*/
	public void jatekosKuldes(Szereplo sz, Mezo cel) {
		Main.tabs++;
		Main.log(this, "jatekosKuldes("+ Main.nameOf(sz) +", "+ Main.nameOf(cel) +")");
		cel.jatekosFogadas(sz);
		Main.tabs--;
	}
	/**Ennek a f�ggv�nynek luk eset�n van feladata.*/
	public void kotellelKuld(Mezo cel) {}
	
	/**Ez a f�ggv�ny a param�terk�nt �tadott mennyis�g� r�teg havat takar�t el a mez�r�l.*/
	public void hoTakarit(int i) {
		Main.tabs++;
		Main.log(this, "hoTakarit(" + i +")");
		Main.tabs--;
	}
	/**Ez a f�ggv�ny a param�terk�nt �tadott j�t�kosnak adja a mez�ben l�v� t�rgyat.*/
	public void targyAtad(Szereplo sz) {
		Main.tabs++;
		Main.log(this, "targyAtad(" + Main.nameOf(sz) + ")");
		belefagyott_targy.osszeszed(sz);
		Main.tabs--;
	}
	/**Ez a f�ggv�ny a h�vihar hat�s�t val�s�tja meg a mez�n.*/
	public void hovihar() {
		Main.tabs++;
		Main.log(this, "hovihar()");
		//kifejti az �p�tm�ny a hat�s�t (ha iglu, semmiss� teszi a h�vihart)
		epitmeny.hatas();
		Main.tabs--;
	}
	/**A mez� teherb�r� k�pess�g�vel t�r vissza.*/
	public int megvizsgal() {return 1;}
	
	public boolean ellenoriz() {return true;}
	/**Ezzel a f�ggv�nnyel tudunk iglut �p�teni a mez�re.*/
	public void igluEpit() {
		Main.tabs++;
		Main.log(this, "igluEpit");
		//lecser�lj�k a standard �res�p�letet
		this.epitmeny = new Iglu();
		Main.tabs--;
	}
	/**Ez a f�ggv�ny h�vja meg a mez�n �ll� j�t�kosok megfelel� met�dusait, ha elkapja �ket a h�vihar.*/
	//az �res�p�let h�vja, hisz ez a hat�sa
	public void tovabbad() {
		Main.tabs++;
		Main.log(this, "tovabbad()");
		//a h�vihar hat�s�t kifejtj�k a mez�n �ll� �sszes j�t�kosra
		for(Szereplo sz : jatekosok) {
			sz.hovihar();	
		}
		Main.tabs--;
	}
	//�sszerendeli a szomsz�dos mez�ket az ir�nyokkal
	public void setSzomszed(int irany, Mezo szomszed) {
		szomszedos_mezok.put(irany, szomszed);
	}
	//visszaadja az ir�nyhoz tartoz� mez�t
	public Mezo getSzomszed(int irany) {
		Main.tabs++;
		Main.log(this, "getSzomszed(" + irany + ") : " + Main.nameOf(szomszedos_mezok.get(irany)));
		Main.tabs--;
		return szomszedos_mezok.get(irany);
	}
	
	/* Ez a met�dus csak a skeletonhoz van, hogy an�lk�l hozz� tudjunk adni szerepl�t
	 * a mez�h�z az inicializ�l�skor, hogy a konzolra logoln�nk a jatekosFogadas() met�dussal. */
	public void AddJatekos(Szereplo sz) {
		jatekosok.add(sz);
		sz.setMezo(this);
	}
	//standard getterek �s setterek
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
