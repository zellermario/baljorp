package projlab;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import java.util.List;


public class Felulet implements ActionListener{
<<<<<<< Updated upstream
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
	
	
=======
	/**Az aktuális játék.*/
	private Jatek jatek;
	/**Frame ami tartalmazza a jatekhoz szükséges paneleket.*/
	private JFrame frame;
	/**Fõ panel ami tartalmazza a többi panelt így tudunk váltani közöttük.*/
	private JPanel controlpanel; private CardLayout cardlayout;
	/**Menu panelje*/
	private JPanel menu;
	/**Menu Start gombja*/
	private JButton startGomb;
	/**Menu ComboBox-a*/
	private JComboBox dropdown;
	private Object menuPoints[];
	/**Panel amin a jatek zajlik*/
	private JPanel jatekpanel;
	/**Panel amin az informaciok megjelennek.*/
	private JPanel terkep;
	/**A palyan levo mezok*/
	private Mezo mezok[][];
	/**A mezoket reprezentalo gombok*/
	private MezoButton mezoGombok[][];//
	/**Eppen aktiv panel*/
	private JPanel aktiv;
	/**Gombokat tratalmazó panel*/
	private JPanel gombok; 
	/**Targy asas gomb*/
	private JButton bas;
	/**Ho takaritas gomb*/
	private JButton btakarit;
	/**Kor vege gomb*/
	private JButton bpass;
	/**Lepes gomb*/
	private JButton blep;
	/**Kepesseg hasznalat gomb*/
	private JButton kepesseg;
	/**Targy hasznalat gombjai.*/
	private JButton targy1, targy2;
	private JButton targy3,targy4;
	private JButton targy5,targy6;
	
	private JPanel mezo_tul;
	private JPanel m_hozzaad;
	private String s_bef;
		
	private JPanel szereplo;
	private JPanel sz_hozzaad;
				
	private JPanel inventory;
	private JPanel i_hozzaad;
	
	private JPanel eredmeny;
		
	/**Felulet konstruktora*/
>>>>>>> Stashed changes
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
	/**Ez a fuggveny a kep ujrarajzolasaert felelos*/
	public void frissites() {
<<<<<<< Updated upstream
=======
		sz_hozzaad.removeAll();
		for(Szereplo sz : jatek.getSzereplok()) {
			sz.rajzolSzereplo(this);
		}
>>>>>>> Stashed changes
		for(Mezo m : jatek.getMezok()) {
			m.rajzolMezo(this);
		}
		
		for(Szereplo sz : jatek.getSzereplok()) {
			sz.rajzolSzereplo(this);
		}
	}
	/**Ez a fuggveny a mezok betolteseert felelos*/
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
<<<<<<< Updated upstream
	public void rajzolEszkimo(Mezo m) {
		
	}
	
	public void rajzolSarkkutato(Mezo m) {
		
	}
	
	public void rajzolJegesmedve(Mezo m) {
		
	}
	
=======
	/**Ez a fuggveny egy eszkimo kirajzolasaert felelos a megfelelo mezore*/
	public void rajzolEszkimo(Mezo m) { m.rajtalevok += " E"; }
	/**Ez a fuggveny egy eszkimo kirajzolasaert felelos az oldalso panelra*/
	public void rajzolEszkimo(int hely,int heat, int munka) {
		String s = "p"+hely +" Eszkimo - " + heat+ " " + munka;;
		JLabel l = new JLabel(s);
		if (hely == jatek.getAktualis()) l.setForeground(Color.blue);
		sz_hozzaad.add(l);
	}
	/**Ez a fuggveny egy sarkkutato kirajzolasaert felelos a megfelelo mezore*/
	public void rajzolSarkkutato(Mezo m) { m.rajtalevok += " S"; }
	/**Ez a fuggveny egy sarkkutato kirajzolasaert felelos az oldalso panelra*/
	public void rajzolSarkkutato(int hely,int heat, int munka) {
		String s = "p"+hely +" Sarkkutato - " + heat + " " + munka;
		JLabel l = new JLabel(s);
		if (hely == jatek.getAktualis()) l.setForeground(Color.blue);
		sz_hozzaad.add(l);
	}
	/**Ez a fuggveny egy jegesmedve kirajzolasaert felelos a megfelelo mezore*/
	public void rajzolJegesmedve(Mezo m) { 
		m.rajtalevok += " J"; }
	/**Ez a fuggveny egy iglu kirajzolasaert felelos a megfelelo mezore*/
>>>>>>> Stashed changes
	public void rajzolIglu(Mezo m) {
		
	}
	/**Ez a fuggveny egy felepitett sator kirajzolasaert felelos a megfelelo mezore*/
	public void rajzolFelepitettSator(Mezo m) {
		
	}
	/**Ez a fuggveny egy lapat kirajzolasaert felelos a megfelelo mezore*/
	public void rajzolLapat(Mezo m) {
<<<<<<< Updated upstream
		
	}
	
=======
		if(m.getHoreteg() == 0) {
			m.rajtalevok += " LAP.";
			}
		s_bef+= "Lapát";
		}
	/**Ez a fuggveny egy lapat kirajzolasaert felelos a tarhelyre*/
>>>>>>> Stashed changes
	public void rajzolLapatInv(Szereplo sz, int hanyadik) {
		
	}
	/**Ez a fuggveny egy kotel kirajzolasaert felelos a megfelelo mezore*/
	public void rajzolKotel(Mezo m) {
		
	}
<<<<<<< Updated upstream
	
=======
	/**Ez a fuggveny egy kotel kirajzolasaert felelos a tarhelyre*/
>>>>>>> Stashed changes
	public void rajzolKotelInv(Szereplo sz, int hanyadik) {
		
	}
	/**Ez a fuggveny egy torekeny aso kirajzolasaert felelos a megfelelo mezore*/
	public void rajzolTorekenyAso(Mezo m) {
<<<<<<< Updated upstream
		
	}
	
=======
		if(m.getHoreteg() == 0)
			m.rajtalevok += " T.Á.";
		s_bef += "Törékeny ásó";
		}
	/**Ez a fuggveny egy torekeny aso kirajzolasaert felelos a tarhelyre*/
>>>>>>> Stashed changes
	public void rajzolTorekenyAsoInv(Szereplo sz, int hanyadik) {
		
	}
<<<<<<< Updated upstream

	public void rajzolEtel(Mezo m) {
		
	}
	
	public void rajzolBuvarruha(Mezo m) {
		
	}
	
=======
	/**Ez a fuggveny egy etel kirajzolasaert felelos a megfelelo mezore*/
	public void rajzolEtel(Mezo m) { 
		if(m.getHoreteg() == 0)
			m.rajtalevok += " ÉT.";
		s_bef += "Étel";
	}
	/**Ez a fuggveny egy buvarruha kirajzolasaert felelos a megfelelo mezore*/
	public void rajzolBuvarruha(Mezo m) { 
		if(m.getHoreteg() == 0)
			m.rajtalevok += " B.R.";
		s_bef += "Búvárruha";
	}
	/**Ez a fuggveny egy buvarruha kirajzolasaert felelos a tarhelyre*/
>>>>>>> Stashed changes
	public void rajzolBuvarruhaInv(Szereplo sz, int hanyadik) {
		
	}
	/**Ez a fuggveny egy raketaalkatresz kirajzolasaert felelos a megfelelo mezore*/
	public void rajzolRaketaalkatresz(Mezo m) {
		
	}
<<<<<<< Updated upstream
	
=======
	/**Ez a fuggveny egy raketaalkatresz kirajzolasaert felelos a tarhelyre*/
>>>>>>> Stashed changes
	public void rajzolRaketaalkatreszInv(Szereplo sz, int hanyadik) {
		
	}
	/**Ez a fuggveny egy sator kirajzolasaert felelos a megfelelo mezore*/
	public void rajzolSator(Mezo m) {
<<<<<<< Updated upstream
		
	}
	
=======
		if(m.getHoreteg() == 0)
			m.rajtalevok += " SÁT.";
		s_bef += "Sátor";
		}
	/**Ez a fuggveny egy sator kirajzolasaert felelos a tarhelyre*/
>>>>>>> Stashed changes
	public void rajzolSatorInv(Szereplo sz, int hanyadik) {
		
	}
	/**Ez a fuggveny egy stabil jegtable kirajzolasaert felelos a megfelelo helyre*/
	public void rajzolStabilJegtabla(int x, int y) {
		mezoGombok[x][y].setText(String.valueOf(mezoGombok[x][y].mezo.getHoreteg()));
	}
<<<<<<< Updated upstream
	
	/**
	 * @param x
	 * @param y
	 */
	public void rajzolInstabilJegtabla(int x, int y) {
		mezoGombok[x][y].setText(String.valueOf(mezoGombok[x][y].mezo.getHoreteg()));
	}
	
=======
	/**Ez a fuggveny egy instabil jegtable kirajzolasaert felelos a megfelelo helyre*/
	public void rajzolInstabilJegtabla(int x, int y) { 
		/*if(mezoGombok[x][y].getMezo().horeteg == 0)
			mezoGombok[x][y].setText("" + mezoGombok[x][y].mezo.rajtalevok);
		else mezoGombok[x][y].setText("?" + mezoGombok[x][y].mezo.rajtalevok);
		}
		//mezoGombok[x][y].setText(mezoGombok[x][y].mezo.rajtalevok);*/
		if(mezoGombok[x][y].getMezo().horeteg == 0) {
			mezoGombok[x][y].setBackground(Color.WHITE);
			mezoGombok[x][y].setText("0" + mezoGombok[x][y].mezo.rajtalevok);
		}
		else {
			mezoGombok[x][y].setBackground(Color.BLUE);
			mezoGombok[x][y].setText("?" + mezoGombok[x][y].mezo.rajtalevok);
			}
		}	
	
	/**Ez a fuggveny egy luk kirajzolasaert felelos a megfelelo helyre*/
>>>>>>> Stashed changes
	public void rajzolLuk(int x, int y) {
		mezoGombok[x][y].setText(String.valueOf(mezoGombok[x][y].mezo.getHoreteg()));
	}
	
	public void rajzolHovihar(Mezo m) {
		
	}
	/**Ez a fuggveny a gyozelem panel megjeleniteseert felelos.*/
	public void Gyozelem() {
		
	}
	/**Ez a fuggveny a vereseg panel megjeleniteseert felelos.*/
	public void Vereség() {
		
	}

<<<<<<< Updated upstream
=======

	public JPanel getControlpanel() {
		return controlpanel;
	}
	/**A menuben levo gombok ActionListenerje*/
>>>>>>> Stashed changes
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
