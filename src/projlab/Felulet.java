package projlab;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import java.util.List;


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
	private Mezo mezok[][];
	private MezoButton mezoGombok[][];
	
	
	public Felulet(Jatek j) {
		jatek = j;
		frame = new JFrame();
		frame.setTitle("Jegmezo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setSize(900, 900);
		
		controlpanel = new JPanel();
		cardlayout = new CardLayout();
		controlpanel.setLayout(cardlayout);
		menuPoints = new Object[3];
		mezoGombok = new MezoButton[8][8];
		mezok = new Mezo[8][8];
		
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
		
		Dimension d = new Dimension(100,100);
/*(int i = 0; i < 8; i++){
			for(int l = 0; l < 8; l++) {
				MezoButton b = new MezoButton();
				b.setPreferredSize(d);
				jatekpanel.add(b);
				mezoGombok[i][l] = b;
			}
		}*/
		
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
	
	public void mezo_load() {
		for(int i = 0; i < 8; i++){
			for(int j = 0; j < 8; j++) {
				mezoGombok[i][j] = new MezoButton(jatek.getMezok().get(i*8+j));
				mezoGombok[i][j].setText(String.valueOf(jatek.getMezok().get(i*8+j).getHoreteg()));
				jatekpanel.add(mezoGombok[i][j]);
				mezoGombok[i][j].setPreferredSize(new Dimension(100,100));
				mezoGombok[i][j].mezo.setCoord(i, j);
			}
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
		mezoGombok[x][y].setText(String.valueOf(mezoGombok[x][y].mezo.getHoreteg()));
	}
	
	/**
	 * @param x
	 * @param y
	 */
	public void rajzolInstabilJegtabla(int x, int y) {
		mezoGombok[x][y].setText(String.valueOf(mezoGombok[x][y].mezo.getHoreteg()));
	}
	
	public void rajzolLuk(int x, int y) {
		mezoGombok[x][y].setText(String.valueOf(mezoGombok[x][y].mezo.getHoreteg()));
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
		mezo_load();
		this.frissites(); //->ez itt hogy kellene?
		
		Main.jatekIF.executeCommand("getStatus");
		
		
	}
}
