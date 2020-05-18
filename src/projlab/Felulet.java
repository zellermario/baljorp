package projlab;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
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
	private JPanel terkep;
	private JPanel aktiv;
	private JPanel lehetoseg, szereplo, inventory;
	private SzereploKey keys;
	private JPanel i1, i2, i3, i4, i5;
	
	
	public Felulet(Jatek j) {
		jatek = j;
		keys = new SzereploKey(j);
		frame = new JFrame();
		frame.setTitle("Jegmezo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setSize(1100, 900);
		
		controlpanel = new JPanel();;
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
		terkep = new JPanel(); aktiv = new JPanel();
		
		terkep.setPreferredSize(new Dimension(1100-200,900));
		jatekpanel.add(terkep, BorderLayout.WEST);
		
		aktiv.setPreferredSize(new Dimension(170, 900)); 
		jatekpanel.add(aktiv, BorderLayout.EAST);
		
		lehetoseg = new JPanel();
		lehetoseg.setPreferredSize(new Dimension(170, 400));
		String sl = "Gombok:\n\nA-hótakarítás\nP-passz\n";
		JTextArea tipp = new JTextArea(sl);
		lehetoseg.add(tipp);
		aktiv.add(lehetoseg, BorderLayout.NORTH);
		szereplo = new JPanel();
		szereplo.setPreferredSize(new Dimension(150, 200));
		aktiv.add(szereplo, BorderLayout.CENTER);
		inventory = new JPanel();
		inventory.setPreferredSize(new Dimension(200, 200));
		aktiv.add(inventory, BorderLayout.SOUTH);
		JLabel linv = new JLabel("Inventory:");
		inventory.add(linv);
		
		i1 = new JPanel(); i2 = new JPanel(); i3 = new JPanel();
		i4 = new JPanel(); i5 = new JPanel();
		Dimension inv = new Dimension (65,65);
		i1.setPreferredSize(inv); i2.setPreferredSize(inv);
		i3.setPreferredSize(inv); i4.setPreferredSize(inv);
		i5.setPreferredSize(inv);
		i1.setBackground(Color.LIGHT_GRAY); i2.setBackground(Color.LIGHT_GRAY);
		i3.setBackground(Color.LIGHT_GRAY); i4.setBackground(Color.LIGHT_GRAY);
		i5.setBackground(Color.LIGHT_GRAY); 
		inventory.add(i1); inventory.add(i2);
		inventory.add(i3); inventory.add(i4);
		inventory.add(i5);
		
		controlpanel.add(jatekpanel,"jatekpanel");
		controlpanel.add(menu, "menu");
		controlpanel.add(eredmeny,"eredmeny");
		controlpanel.setFocusable(true);
		controlpanel.addKeyListener(keys);
		
		frame.setContentPane(controlpanel);
		cardlayout.show(controlpanel, "menu");
		frame.setVisible(true);
		
	}
	
	public void frissites() {
		controlpanel.requestFocusInWindow();
		szereplo.removeAll();
		for(Szereplo sz : jatek.getSzereplok()) {
			sz.rajzolSzereplo(this);
		}
		for(Mezo m : jatek.getMezok()) {
			m.rajzolMezo(this);
			m.rajzalevok = "";
		}
	}
	
	public void mezo_load() {
		for(int i = 0; i < 8; i++){
			for(int j = 0; j < 8; j++) {
				mezoGombok[i][j] = new MezoButton(jatek.getMezok().get(i*8+j));
				mezoGombok[i][j].setText(String.valueOf(jatek.getMezok().get(i*8+j).getHoreteg()));
				terkep.add(mezoGombok[i][j]);
				mezoGombok[i][j].setPreferredSize(new Dimension(100,100));
				mezoGombok[i][j].mezo.setCoord(i, j);
				
			}
		}
	}

	public void rajzolEszkimo(Mezo m) { m.rajzalevok += " E"; }
	public void rajzolEszkimo(int hely,int heat) {
		String s = "p"+hely +" Eszkimo - " + heat;
		JLabel l = new JLabel(s);
		if (hely == jatek.getAktualis()) l.setForeground(Color.RED);
		szereplo.add(l);
	}
	
	public void rajzolSarkkutato(Mezo m) { m.rajzalevok += " S"; }
	public void rajzolSarkkutato(int hely,int heat) {
		String s = "p"+hely +" Sarkkutato - " + heat;
		JLabel l = new JLabel(s);
		if (hely == jatek.getAktualis()) l.setForeground(Color.RED);
		szereplo.add(l);
	}
	
	public void rajzolJegesmedve(Mezo m) { m.rajzalevok += " J"; }
	
	public void rajzolIglu(Mezo m) { }
	
	public void rajzolFelepitettSator(Mezo m) { }
	
	public void rajzolLapat(Mezo m) { }
	public void rajzolLapatInv(Szereplo sz, int hanyadik) {
		JLabel temp = new JLabel("Lapát");
		switch (hanyadik) {
		case 0:
			i1.add(temp);
			break;
		case 1:
			i2.add(temp);
			break;
		case 2:
			i3.add(temp);
			break;
		case 3:
			i4.add(temp);
			break;
		case 4:
			i5.add(temp);
			break;
		}
	}
	
	public void rajzolKotel(Mezo m) { }
	public void rajzolKotelInv(Szereplo sz, int hanyadik) {
		JLabel temp = new JLabel("Kotel");
		switch (hanyadik) {
		case 0:
			i1.add(temp);
			break;
		case 1:
			i2.add(temp);
			break;
		case 2:
			i3.add(temp);
			break;
		case 3:
			i4.add(temp);
			break;
		case 4:
			i5.add(temp);
			break;
		}
	}
	
	public void rajzolTorekenyAso(Mezo m) {	}
	public void rajzolTorekenyAsoInv(Szereplo sz, int hanyadik) {
		JLabel temp = new JLabel("Törékeny Ásó");
		switch (hanyadik) {
		case 0:
			i1.add(temp);
			break;
		case 1:
			i2.add(temp);
			break;
		case 2:
			i3.add(temp);
			break;
		case 3:
			i4.add(temp);
			break;
		case 4:
			i5.add(temp);
			break;
		}		
	}

	public void rajzolEtel(Mezo m) { }
	
	public void rajzolBuvarruha(Mezo m) { }
	public void rajzolBuvarruhaInv(Szereplo sz, int hanyadik) {
		JLabel temp = new JLabel("Buvárruha");
		switch (hanyadik) {
		case 0:
			i1.add(temp);
			break;
		case 1:
			i2.add(temp);
			break;
		case 2:
			i3.add(temp);
			break;
		case 3:
			i4.add(temp);
			break;
		case 4:
			i5.add(temp);
			break;
		}
	}
	
	public void rajzolRaketaalkatresz(Mezo m) {	}
	public void rajzolRaketaalkatreszInv(Szereplo sz, int hanyadik) {
		JLabel temp = new JLabel("Rakétaalkatrész");
		switch (hanyadik) {
		case 0:
			i1.add(temp);
			break;
		case 1:
			i2.add(temp);
			break;
		case 2:
			i3.add(temp);
			break;
		case 3:
			i4.add(temp);
			break;
		case 4:
			i5.add(temp);
			break;
		}
	}
	
	public void rajzolSator(Mezo m) { }
	
	public void rajzolSatorInv(Szereplo sz, int hanyadik) {
		JLabel temp = new JLabel("Sátor");
		switch (hanyadik) {
		case 0:
			i1.add(temp);
			break;
		case 1:
			i2.add(temp);
			break;
		case 2:
			i3.add(temp);
			break;
		case 3:
			i4.add(temp);
			break;
		case 4:
			i5.add(temp);
			break;
		}
	}
	
	public void rajzolStabilJegtabla(int x, int y) {mezoGombok[x][y].setText(String.valueOf(mezoGombok[x][y].mezo.getHoreteg()+ mezoGombok[x][y].mezo.rajzalevok));}
	
	/**
	 * @param x
	 * @param y
	 */
	public void rajzolInstabilJegtabla(int x, int y) { mezoGombok[x][y].setText(String.valueOf(mezoGombok[x][y].mezo.getHoreteg() + mezoGombok[x][y].mezo.rajzalevok));}
	
	public void rajzolLuk(int x, int y) {mezoGombok[x][y].setText(mezoGombok[x][y].mezo.rajzalevok);}
	
	public void rajzolHovihar(Mezo m) {
		
	}
	
	public void Gyozelem() {
		
	}
	
	public void Vereség() {
		
	}


	public JPanel getControlpanel() {
		return controlpanel;
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
		this.frissites();
		
		Main.jatekIF.executeCommand("getStatus");
		
		
	}
}
