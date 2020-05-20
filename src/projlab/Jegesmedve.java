package projlab;

import java.util.Random;

/**A jegesmedve viselkedeset megvalosito osztaly*/
public class Jegesmedve extends Szereplo {
	/**Ezzel a valtozoval tartjuk szamon, hogy a jegesmedvet kell-e mozgatni*/
	private boolean halott; 
	public Jegesmedve(Jatek j, Mezo kezdomezo) {
        super(4, 1, j, kezdomezo);
        testho = 1;
        halott = false;
    }
    /*ez a fuggveny felelos a jegesmedve automatikus mozgatasaert*/
    public void kor() {
        if(!halott) {
            if(getKurrensMezo().megvizsgal() == 0) halal();
            Random rand = new Random();
            int irany = rand.nextInt(4)+1;
            lepes(irany);
            tamad();
        }
        passz();
    }
	/**ezzel a fuggvennyel tudjuk megolni a medvet, ha az egy lukban ragadt vagy megtamadta egy masik medve*/
	public void halal() {
		halott = true;
		testho = 0;
	}
	/**ezzel a fuggvennyel tamadjuk meg a kurrens mezon allo jatekosokat*/
	public void tamad() {
		getKurrensMezo().medvetamad();
	}
	/**ures fuggveny, hisz a medvere nem hat a hovihar*/
	public void hovihar() {}
	
	/**Tesztelest segito fuggveny*/
	public String toString() {
		return "Jegesmedve";
	}
	
	/**A leptetest vegzo fuggveny*/
	public void lepes(int irany) {
		if(sorszam != jatek.getAktualis()) return;
		Mezo cel = kurrensmezo.getSzomszed(irany);
		kurrensmezo.jatekosKuldes(this, cel);
		tamad();
	}
	/**Megfelelo kirajzolas*/
	public void rajzolSzereplo(Felulet f){
		if(!halott)
			f.rajzolJegesmedve(kurrensmezo);
	}
}
