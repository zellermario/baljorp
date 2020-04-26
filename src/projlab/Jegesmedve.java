package projlab;

public class Jegesmedve extends Szereplo {
	/**Ezzel a valtozoval tartjuk szamon, hogy a jegesmedvet kell-e mozgatni*/
	private boolean halott; 
	public Jegesmedve(Jatek j, Mezo kezdomezo) {
		super(1, 1, j, kezdomezo);
		halott = false;
	}
	/**ez a fuggveny felelos a jegesmedve mozgatasaert, de a randomsaga miatt a tesztekben nem szerepel*/
	public void kor() {
		if(!halott) {
			if(getKurrensMezo().megvizsgal() == 0) halal();
			
		}
		//a manualisan egymas utan hivogatott fuggvenyek itt jonnenek egymas utan sorban
		
	}
	/**ezzel a fuggvennyel tudjuk megolni a medvet, ha az egy lukban ragadt vagy megtamadta egy masik medve*/
	public void halal() {
		halott = true;
	}
	/**ezzel a fuggvennyel tamadjuk meg a kurrens mezon allo jatekosokat*/
	public void tamad() {
		getKurrensMezo().medvetamad();
	}
	/**ures fuggveny, hisz a medvere nem hat a hovihar*/
	public void hovihar() {}
	
	public String toString() {
		return "Jegesmedve";
	}
}
