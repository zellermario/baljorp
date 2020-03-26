package projlab;

public class Mezo {
	private int horeteg;
	private int id;
	private Mezo szomszedos_mezok[];
	private Jatek jatek;
	private Targy belefagyott[];
	private Epitmeny epitmeny;
	private Szereplo jatekosok;
	
	public void jatekosFogadas(Szereplo sz) {}
	public void jatekosKuldes(Mezo cel) {}
	public void kotellelKüld(Mezo cel) {}
	public void targyAtad(Szereplo sz) {}
	public void hovihar() {}
	public void hoTakarit() {}
	public int megvizsgal() {return 1;}
	public boolean ellenoriz() {return true;}
	public void igluEpit() {}
	public void tovabbad() {}
}
