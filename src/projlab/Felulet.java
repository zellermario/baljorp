package projlab;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class Felulet implements ActionListener{
	private Jatek jatek;
	private JFrame frame;
	private JPanel jatekpanel;
	private JPanel menu;
	private JPanel eredmeny;
	private CardLayout cardlayout;
	private JPanel controlpanel;
	private JButton startGomb;
	private JComboBox dropdown;
	private Object menuPoints[];
	
	
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
		menuPoints = new Object[3];
		
		menuPoints[0] = "Mindenbõl egy";
		menuPoints[1] = "Mindenbõl kettõ";
		menuPoints[2] = "Mindenbõl három";
		
		
		jatekpanel = new JPanel();
		menu = new JPanel();
		eredmeny = new JPanel();
		
		startGomb = new JButton();
		startGomb.setText("Start!");
		dropdown = new JComboBox(menuPoints);
		startGomb.addActionListener(this);
		menu.add(startGomb);
		menu.add(dropdown);
		
		
		
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

	@Override
	public void actionPerformed(ActionEvent e) {
		cardlayout.show(controlpanel, "jatekpanel");
		Main.jatekIF.executeCommand("runscript map.txt");
		int index = dropdown.getSelectedIndex();
		if(index == 0) Main.jatekIF.executeCommand("runscript 2jatekos.txt");
		if(index == 1) Main.jatekIF.executeCommand("runscript 4jatekos.txt");
		if(index == 2) Main.jatekIF.executeCommand("runscript 6jatekos.txt"); 
		//this.frissites(); ->ez itt hogy kellene?
		Main.jatekIF.executeCommand("getStatus");
		
		
	}
}
