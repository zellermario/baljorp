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
	    }
	    else if(key == KeyEvent.VK_P) {
	    	//jatek.getSzereplok().get(jatek.getAktualis()).passz();
	    }
	    else if(key == KeyEvent.VK_L) {
	    	jatek.lep_mezo();
	    }
	    else if(key == KeyEvent.VK_D) {
	    	jatek.getSzereplok().get(jatek.getAktualis()).targyKiasas();
	    }
	    else if(key == KeyEvent.VK_1) {
	    	jatek.targy_hasznal(1);
	    }
	    else if(key == KeyEvent.VK_2) {
	    	jatek.targy_hasznal(2);
	    }
	    else if(key == KeyEvent.VK_3) {
	    	jatek.targy_hasznal(3);
	    }
	    else if(key == KeyEvent.VK_4) {
	    	jatek.targy_hasznal(4);
	    }
	    else if(key == KeyEvent.VK_5) {
	    	jatek.targy_hasznal(5);
	    }
	    else if(key == KeyEvent.VK_6) {
	    	jatek.targy_hasznal(6);
	    }
	    jatek.getFelulet().getControlPanel().requestFocusInWindow();
	    jatek.kepfrissites();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}