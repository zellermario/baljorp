package projlab;

public class TorekenyAso extends Lapat {
	private int tartossag;
	
	public TorekenyAso() {
		tartossag = 3;
	}
	
	public void használ(Szereplo sz) {
		sz.hoTakaritas(2);
		tartossag--;
		if(tartossag == 0) {
			sz.targyTorol(this);
		}
	}
}
