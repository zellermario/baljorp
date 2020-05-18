package projlab;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class SzereploKey implements KeyListener{
	private Jatek jatek;
	public SzereploKey(Jatek j) {
		jatek = j;
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();

	    if (key == KeyEvent.VK_A) {
	        jatek.getSzereplok().get(jatek.getAktualis()).hoTakaritas(1);
	        jatek.kepfrissites();
	    }
	    else if(key == KeyEvent.VK_P) {
	    	jatek.getSzereplok().get(jatek.getAktualis()).passz();
	    	jatek.kepfrissites();
	    }
	   
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}