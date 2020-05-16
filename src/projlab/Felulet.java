package projlab;

public class Felulet {
	private Jatek jatek;
	
	public Felulet(Jatek j) {
		jatek = j;
	}
	
	public void frissites() {
		for(Mezo m : jatek.getMezok()) {
			m.rajzolMezo(this);
		}
		
		for(Szereplo sz : jatek.getSzereplok()) {
			sz.rajzolSzereplo(this);
		}
	}
	
	public void rajzolEszkimo(Mezo m) {
		
	}
	
	public void rajzolSarkkutato(Mezo m) {
		
	}
	
	public void rajzolJegesmedve(Mezo m) {
		
	}
	
	public void rajzolIglu(Mezo m) {
		
	}
	
	public void rajzolFelepitettSator(Mezo m) {
		
	}
	
	public void rajzolLapat(Mezo m) {
		
	}
	
	public void rajzolLapatInv(Szereplo sz, int hanyadik) {
		
	}
	
	public void rajzolKotel(Mezo m) {
		
	}
	
	public void rajzolKotelInv(Szereplo sz, int hanyadik) {
		
	}
	
	public void rajzolTorekenyAso(Mezo m) {
		
	}
	
	public void rajzolTorekenyAsoInv(Szereplo sz, int hanyadik) {
		
	}

	public void rajzolEtel(Mezo m) {
		
	}
	
	public void rajzolBuvarruha(Mezo m) {
		
	}
	
	public void rajzolBuvarruhaInv(Szereplo sz, int hanyadik) {
		
	}
	
	public void rajzolRaketaalkatresz(Mezo m) {
		
	}
	
	public void rajzolRaketaalkatreszInv(Szereplo sz, int hanyadik) {
		
	}
	
	public void rajzolSator(Mezo m) {
		
	}
	
	public void rajzolSatorInv(Szereplo sz, int hanyadik) {
		
	}
	
	public void rajzolStabilJegtabla(int x, int y) {
		
	}
	
	public void rajzolInstabilJegtabla(int x, int y) {
		
	}
	
	public void rajzolLuk(int x, int y) {
		
	}
	
	public void rajzolHovihar(Mezo m) {
		
	}
	
	public void Gyozelem() {
		
	}
	
	public void Vereség() {
		
	}
}
