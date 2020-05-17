package projlab;

import java.awt.CardLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Felulet {
	private Jatek jatek;
	private JFrame frame;
	private JPanel jatekpanel;
	private JPanel menu;
	private JPanel eredmeny;
	private CardLayout cardlayout;
	private JPanel controlpanel;
	
	public Felulet(Jatek j) {
		jatek = j;
		frame = new JFrame();
		frame.setTitle("Jegmezo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setSize(800, 500);
		
		controlpanel = new JPanel();
		cardlayout = new CardLayout();
		controlpanel.setLayout(cardlayout);
		
		jatekpanel = new JPanel();
		menu = new JPanel();
		eredmeny = new JPanel();
		
		controlpanel.add(jatekpanel,"jatekpanel");
		controlpanel.add(menu, "menu");
		controlpanel.add(eredmeny,"eredmeny");
		
		controlpanel.setFocusable(true);
		
		frame.setContentPane(controlpanel);
		cardlayout.show(controlpanel, "menu");
		frame.setVisible(true);
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
