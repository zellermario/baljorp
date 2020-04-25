package projlab;

public class TorekenyAso extends Lapat {
	private int tartossag;
	
	public TorekenyAso(int _id) {
		super(_id);
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
