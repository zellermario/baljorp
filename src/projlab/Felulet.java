package projlab;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.Border;

import java.util.List;


public class Felulet implements ActionListener{

	/**Az aktualis jatek.*/
	private Jatek jatek;
	/**Frame ami tartalmazza a jatekhoz szukseges paneleket.*/
	private JFrame frame;
	/**Fo panel ami tartalmazza a tobbi panelt igy tudunk valtani kozottuk.*/
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
	private MezoButton mezoGombok[][];
	/**Eppen aktiv panel*/
	private JPanel aktiv;
	/**Gombokat tratalmazo panel*/
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
	/**az aktiv mezorol, amit tudni lehet ide kerul*/
	private JPanel mezo_tul;
	private JPanel m_hozzaad;
	private String s_bef;
	/**a szereplok adatai*/
	private JPanel szereplo;
	private JPanel sz_hozzaad;
	/**az eppen soron levo jatekos inventoryja*/
	private JPanel inventory;
	private JPanel i_hozzaad;
	/**vegeredmenypanelek*/
	private JPanel vereseg;
	private JPanel gyozelem;

		
	/**Felulet konstruktora, felepiti a jatek kinezetet*/
	public Felulet(Jatek j) {
		jatek = j;
		frame = new JFrame();
		frame.setTitle("Jegmezo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setSize(1100, 800);
		
		controlpanel = new JPanel();
		cardlayout = new CardLayout();
		controlpanel.setLayout(cardlayout);
		
		menuPoints = new Object[3];
		mezoGombok = new MezoButton[8][8];
		mezok = new Mezo[8][8];
		menuPoints[0] = "Mindenbol egy";
		menuPoints[1] = "Mindenbol ketto";
		menuPoints[2] = "Mindenbol harom";
		
		menu = new JPanel(); menu.setBackground(new Color(204, 255, 229));
		jatekpanel = new JPanel(); jatekpanel.setBackground(new Color(85, 214, 231));
		vereseg = new JPanel();
		vereseg.setBackground(Color.RED);
		gyozelem = new JPanel();
		gyozelem.setBackground(Color.GREEN);
		
		//menu
		JLabel cim = new JLabel("Jegmezo",SwingConstants.CENTER); cim.setFont(new Font("Serif", Font.BOLD, 60));
		cim.setBackground(menu.getBackground());

		JLabel leiras = new JLabel("Gyujtsetek ossze a jelzoraketa reszeit a tarsaiddal, hogy megmenekuljetek a jeges mezorol. Vigyazz, ha barki is meghal, vesztetek.", SwingConstants.CENTER);

		leiras.setBackground(menu.getBackground()); 
		JPanel helykitolto = new JPanel();
		helykitolto.setBackground(menu.getBackground());
		helykitolto.setPreferredSize(new Dimension(500,800));
		JPanel kival = new JPanel();
		kival.setBackground(menu.getBackground());
		startGomb = new JButton();
		startGomb.setText("Start!");
		dropdown = new JComboBox(menuPoints); dropdown.setMaximumSize(new Dimension(200,200));
		startGomb.addActionListener(this);
		menu.setLayout(new BoxLayout(menu, BoxLayout.PAGE_AXIS));
		menu.add(cim);
		menu.add(leiras);
		kival.add(dropdown);
		kival.add(startGomb);
		menu.add(kival);
		menu.add(helykitolto);
		
	
		//jatekfelulet
		terkep = new JPanel();
		terkep.setBackground(jatekpanel.getBackground());
		aktiv = new JPanel();
		aktiv.setBackground(Color.WHITE);
		
		terkep.setPreferredSize(new Dimension(800,800));
		
		jatekpanel.add(terkep, BorderLayout.WEST);
		aktiv.setPreferredSize(new Dimension(270, 800)); 
		jatekpanel.add(aktiv, BorderLayout.EAST);
		aktiv.setLayout(new GridLayout(4,1));
		
		
		
		gombok = new JPanel(); gombok.setBackground(jatekpanel.getBackground());
		gombok.setPreferredSize(new Dimension(270, 200));
		bas = new JButton("Jegtablabol kias");
		btakarit = new JButton("Ho eltakaritasa");
		bpass = new JButton("Kor befejezese");
		blep = new JButton("Lepes a kijelolt mezore");
		kepesseg = new JButton("Kepesseg");
		targy1 = new JButton("Targy1"); targy2 = new JButton("Targy2");
		targy3 = new JButton("Targy3"); targy4 = new JButton("Targy4");
		targy5 = new JButton("Targy5"); targy6 = new JButton("Targy6");
		gombok.add(blep);
		gombok.add(btakarit);
		gombok.add(bas);
		gombok.add(bpass);
		gombok.add(kepesseg);
		gombok.add(targy1); 
		gombok.add(targy2); 
		gombok.add(targy3); 
		gombok.add(targy4);
		gombok.add(targy5); 
		gombok.add(targy6);
		aktiv.add(gombok);
		
		mezo_tul = new JPanel();
		mezo_tul.setBackground(jatekpanel.getBackground());
		mezo_tul.setLayout(new BoxLayout(mezo_tul, BoxLayout.PAGE_AXIS));
		mezo_tul.setSize(new Dimension(270, 120));
		JLabel mezo_cim = new JLabel("Kurrens mezo:");
		mezo_tul.add(mezo_cim);
		m_hozzaad = new JPanel();
		m_hozzaad.setBackground(jatekpanel.getBackground());
		m_hozzaad.setLayout(new BoxLayout(m_hozzaad, BoxLayout.PAGE_AXIS));
		m_hozzaad.setAlignmentX(Component.LEFT_ALIGNMENT);
		mezo_cim.setAlignmentX(Component.LEFT_ALIGNMENT);
		mezo_tul.add(m_hozzaad);
		aktiv.add(mezo_tul);
		mezo_tul.setAlignmentX(Component.RIGHT_ALIGNMENT);
		
		szereplo = new JPanel();
		szereplo.setBackground(jatekpanel.getBackground());
		szereplo.setLayout(new BoxLayout(szereplo, BoxLayout.PAGE_AXIS));
		szereplo.setSize(new Dimension(270, 100));
		JLabel lszer = new JLabel("Jatekosok:"); szereplo.add(lszer);
		sz_hozzaad = new JPanel();
		sz_hozzaad.setBackground(jatekpanel.getBackground());
		sz_hozzaad.setLayout(new BoxLayout(sz_hozzaad, BoxLayout.PAGE_AXIS));
		lszer.setAlignmentX(Component.LEFT_ALIGNMENT);
		szereplo.add(sz_hozzaad);
		aktiv.add(szereplo);
		szereplo.setAlignmentX(Component.RIGHT_ALIGNMENT);
		
		inventory = new JPanel();
		inventory.setBackground(jatekpanel.getBackground());
		inventory.setLayout(new BoxLayout(inventory, BoxLayout.PAGE_AXIS));
		inventory.setPreferredSize(new Dimension(270, 200));
		JLabel linv = new JLabel("Inventory:");	inventory.add(linv);
		linv.setAlignmentX(Component.LEFT_ALIGNMENT);
		i_hozzaad = new JPanel();
		i_hozzaad.setBackground(jatekpanel.getBackground());
		i_hozzaad.setLayout(new BoxLayout(i_hozzaad, BoxLayout.PAGE_AXIS));
		inventory.add(i_hozzaad);
		aktiv.add(inventory);
		inventory.setAlignmentX(Component.RIGHT_ALIGNMENT);

		JLabel ver = new JLabel("Meghalt egy jatekos, vesztettel!", SwingConstants.CENTER);
		ver.setFont(new Font("Serif", Font.BOLD, 60));
		vereseg.add(ver);
		JLabel gyoz = new JLabel("Gratulalunk, nyertel!", SwingConstants.CENTER);
		gyoz.setFont(new Font("Serif", Font.BOLD, 60));
		gyozelem.add(gyoz);
		
		controlpanel.add(jatekpanel,"jatekpanel");
		controlpanel.add(menu, "menu");
		controlpanel.add(vereseg,"veresegpanel");
		controlpanel.add(gyozelem, "gyozelempanel");
		controlpanel.setFocusable(true);
		
		frame.setContentPane(controlpanel);
		cardlayout.show(controlpanel, "menu");
		frame.setVisible(true);
	}
	/**Ez a fuggveny a kep ujrarajzolasaert felelos*/
	public void frissites() {
		sz_hozzaad.removeAll(); i_hozzaad.removeAll();
		for(Szereplo sz : jatek.getSzereplok()) {
			sz.rajzolSzereplo(this);
		}
		for(Mezo m : jatek.getMezok()) {
			m.rajzolMezo(this);
			m.rajtalevok = "";
			
		}
		m_hozzaad.removeAll();
		Mezo m = jatek.getSzereplok().get(jatek.getAktualis()).kurrensmezo;
		
		for(int x = 0; x < 8; x++) { /**A kijelolt es kurrens mezo kirajzolasa megfeleloen*/
			for(int y = 0; y < 8; y++) {
				if (mezoGombok[x][y].getMezo() == m) {
					mezoGombok[x][y].setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
				} else mezoGombok[x][y].setBorder(null);
				if (mezoGombok[x][y].getMezo() == jatek.getKivalasztott_mezo()) mezoGombok[x][y].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 5));
				

			}
		}
		/**Jobb oldali panelbe statusszal kapcsolatos rajzolas*/
		int ho = m.getHoreteg();
		JLabel havazott = new JLabel("Horeteg: "+ho); m_hozzaad.add(havazott);
		Targy t = m.belefagyott_targy;
		s_bef = "Belefagyott targy: ";
		if(ho == 0) {
			if (t == null)  s_bef += "-  ";
		}
		else s_bef += "?  ";
		JLabel befagyott = new JLabel(s_bef); 
		m_hozzaad.add(befagyott);
	}
	/**Ez a fuggveny a mezok betolteseert felelos*/
	public void mezo_load() {
		for(int i = 0; i < 8; i++){
			for(int j = 0; j < 8; j++) {
				mezoGombok[i][j] = new MezoButton(jatek.getMezok().get(i*8+j));
				terkep.add(mezoGombok[i][j]);
				mezoGombok[i][j].setPreferredSize(new Dimension(90,90));
				mezoGombok[i][j].mezo.setCoord(i, j);
				
			}
		}
	}
	
	public JPanel getControlPanel() {
		return controlpanel;
	}
	public CardLayout getCardLayout() {
		return cardlayout;
	}

	
	/**Ez a fuggveny egy eszkimo kirajzolasaert felelos a megfelelo mezore*/
	public void rajzolEszkimo(Mezo m) { m.rajtalevok += " E"; }
	/**Ez a fuggveny egy eszkimo kirajzolasaert felelos az oldalso panelra*/
	public void rajzolEszkimo(int hely,int heat, int munka) {
		String s = hely+1 +". Eszkimo - " + heat+ " testho, " + munka+" munka";
		JLabel l = new JLabel(s);
		if (hely == jatek.getAktualis()) l.setForeground(Color.blue);
		sz_hozzaad.add(l);
	}
	/**Ez a fuggveny egy sarkkutato kirajzolasaert felelos a megfelelo mezore*/
	public void rajzolSarkkutato(Mezo m) { m.rajtalevok += " S"; }
	/**Ez a fuggveny egy sarkkutato kirajzolasaert felelos az oldalso panelra*/
	public void rajzolSarkkutato(int hely,int heat, int munka) {
		String s =hely+1 +". Sarkkutato - " + heat + " testho, " + munka + " munka"; 
		JLabel l = new JLabel(s);
		if (hely == jatek.getAktualis()) l.setForeground(Color.blue);
		sz_hozzaad.add(l);
	}
	/**Ez a fuggveny egy jegesmedve kirajzolasaert felelos a megfelelo mezore*/
	public void rajzolJegesmedve(Mezo m) { 
		m.rajtalevok += " J"; }
	/**Ez a fuggveny egy iglu kirajzolasaert felelos a megfelelo mezore*/
	public void rajzolIglu(Mezo m) {
		m.rajtalevok += " IG";
	}
	/**Ez a fuggveny egy felepitett sator kirajzolasaert felelos a megfelelo mezore*/
	public void rajzolFelepitettSator(Mezo m) {
		m.rajtalevok += " /\\";
	}
	/**Ez a fuggveny egy lapat kirajzolasaert felelos a megfelelo mezore*/
	public void rajzolLapat(Mezo m) {
		if(m.getHoreteg() == 0) {
			m.rajtalevok += " LAP.";
			}
		s_bef+= "Lapat";
		}

	/**Ez a fuggveny egy lapat kirajzolasaert felelos a tarhelyre*/
	public void rajzolLapatInv(Szereplo sz, int hanyadik) {
		JLabel temp = new JLabel("t" + hanyadik+" - Lapat");
		i_hozzaad.add(temp);
	}
	/**Ez a fuggveny egy kotel kirajzolasaert felelos a megfelelo mezore*/
	public void rajzolKotel(Mezo m) {
		if(m.getHoreteg() == 0)
			m.rajtalevok += " KOT.";
		s_bef += "Kotel";
	}

	/**Ez a fuggveny egy kotel kirajzolasaert felelos a tarhelyre*/
	public void rajzolKotelInv(Szereplo sz, int hanyadik) {
		JLabel temp = new JLabel("t" + hanyadik+" - Kotel");
		i_hozzaad.add(temp);
		
	}
	/**Ez a fuggveny egy torekeny aso kirajzolasaert felelos a megfelelo mezore*/
	public void rajzolTorekenyAso(Mezo m) {
		if(m.getHoreteg() == 0)
			m.rajtalevok += " T.A.";
		s_bef += "Torekeny aso";
		}

	/**Ez a fuggveny egy torekeny aso kirajzolasaert felelos a tarhelyre*/
	public void rajzolTorekenyAsoInv(Szereplo sz, int hanyadik) {
		JLabel temp = new JLabel("t" + hanyadik+" - Torekeny Aso");
		i_hozzaad.add(temp);		
	}

	/**Ez a fuggveny egy etel kirajzolasaert felelos a megfelelo mezore*/
	public void rajzolEtel(Mezo m) { 
		if(m.getHoreteg() == 0)
			m.rajtalevok += "ET.";
		s_bef += "Etel";
	}
	/**Ez a fuggveny egy buvarruha kirajzolasaert felelos a megfelelo mezore*/
	public void rajzolBuvarruha(Mezo m) { 
		if(m.getHoreteg() == 0)
			m.rajtalevok += " B.R.";
		s_bef += "Buvarruha";
	}
	/**Ez a fuggveny egy buvarruha kirajzolasaert felelos a tarhelyre*/
	public void rajzolBuvarruhaInv(Szereplo sz, int hanyadik) {
		JLabel temp = new JLabel("t" + hanyadik+" - Buvarruha");
		i_hozzaad.add(temp);
	}
	/**Ez a fuggveny egy raketaalkatresz kirajzolasaert felelos a megfelelo mezore*/
	public void rajzolRaketaalkatresz(Mezo m) {
		if(m.getHoreteg() == 0)
			m.rajtalevok += " RAK.";
		s_bef += "Raketaalkatresz";
	}

	/**Ez a fuggveny egy raketaalkatresz kirajzolasaert felelos a tarhelyre*/
	public void rajzolRaketaalkatreszInv(Szereplo sz, int hanyadik) {
		JLabel temp = new JLabel("t" + hanyadik+" - Raketaalkatresz");
		i_hozzaad.add(temp);
	}
	/**Ez a fuggveny egy sator kirajzolasaert felelos a megfelelo mezore*/
	public void rajzolSator(Mezo m) {
		if(m.getHoreteg() == 0)
			m.rajtalevok += " SAT.";
		s_bef += "Sator";
		}

	/**Ez a fuggveny egy sator kirajzolasaert felelos a tarhelyre*/
	public void rajzolSatorInv(Szereplo sz, int hanyadik) {
		JLabel temp = new JLabel("t" + hanyadik+" - Sator");
		i_hozzaad.add(temp);
	}
	/**Ez a fuggveny egy stabil jegtable kirajzolasaert felelos a megfelelo helyre es megfelelo szinnel*/
	public void rajzolStabilJegtabla(int x, int y) {
	if(mezoGombok[x][y].getMezo().horeteg == 0) {
		mezoGombok[x][y].setBackground(Color.WHITE);
		mezoGombok[x][y].setText(String.valueOf(mezoGombok[x][y].getMezo().horeteg) + mezoGombok[x][y].mezo.rajtalevok);
	}
	else {
		mezoGombok[x][y].setBackground(Color.CYAN);
		mezoGombok[x][y].setText(String.valueOf(mezoGombok[x][y].getMezo().horeteg) + mezoGombok[x][y].mezo.rajtalevok);
		}
	if(mezoGombok[x][y].getMezo().getVizsgalt()) mezoGombok[x][y].setBackground(Color.GREEN);
	}

	/**Ez a fuggveny egy instabil jegtable kirajzolasaert felelos a megfelelo helyre es megfelelo szinnel*/
	public void rajzolInstabilJegtabla(int x, int y) { 
		
		if(mezoGombok[x][y].getMezo().horeteg == 0) {
			mezoGombok[x][y].setBackground(Color.WHITE);
			mezoGombok[x][y].setText(String.valueOf(mezoGombok[x][y].getMezo().horeteg) + mezoGombok[x][y].mezo.rajtalevok);
		}
		else {
			mezoGombok[x][y].setBackground(Color.CYAN);
			mezoGombok[x][y].setText(String.valueOf(mezoGombok[x][y].getMezo().horeteg) + mezoGombok[x][y].mezo.rajtalevok);
			if(mezoGombok[x][y].getMezo().getVizsgalt()) mezoGombok[x][y].setBackground(Color.GREEN);
			}
		}	
	
	/**Ez a fuggveny egy luk kirajzolasaert felelos a megfelelo helyre es megfelelo szinnel*/
	public void rajzolLuk(int x, int y) {
		if(mezoGombok[x][y].getMezo().horeteg == 0)
		{
			mezoGombok[x][y].setBackground(Color.RED); 
			mezoGombok[x][y].setText("Luk" + mezoGombok[x][y].mezo.rajtalevok);
		}
		else { 
			mezoGombok[x][y].setBackground(Color.CYAN);
			mezoGombok[x][y].setText(String.valueOf(mezoGombok[x][y].getMezo().horeteg) + mezoGombok[x][y].mezo.rajtalevok);
			if(mezoGombok[x][y].getMezo().getVizsgalt()) mezoGombok[x][y].setBackground(Color.GREEN);
		}
		}
		
	
	public void rajzolHovihar(Mezo m) {
		
	}
	/**Ez a fuggveny a gyozelem panel megjeleniteseert felelos.*/
	public void Gyozelem() {
		cardlayout.show(controlpanel, "gyozelempanel");
	}
	/**Ez a fuggveny a vereseg panel megjeleniteseert felelos.*/
	public void Vereseg() {
		cardlayout.show(controlpanel, "veresegpanel");
	}

	/**A Start ActionListenerje, felepiti a jatekteret a mellekelt szkript alapjan*/
	@Override
	public void actionPerformed(ActionEvent e) {
		cardlayout.show(controlpanel, "jatekpanel");
		Main.jatekIF.executeCommand("runscript map.txt");
		int index = dropdown.getSelectedIndex();
		if(index == 0) Main.jatekIF.executeCommand("runscript 2jatekos.txt");
		if(index == 1) Main.jatekIF.executeCommand("runscript 4jatekos.txt");
		if(index == 2) Main.jatekIF.executeCommand("runscript 6jatekos.txt"); 
		mezo_load();
		blep.addActionListener(mezoGombok[0][0]);
		btakarit.addActionListener(mezoGombok[0][0]);
		bas.addActionListener(mezoGombok[0][0]);
		bpass.addActionListener(mezoGombok[0][0]);
		kepesseg.addActionListener(mezoGombok[0][0]);
		targy1.addActionListener(mezoGombok[0][0]);
		targy2.addActionListener(mezoGombok[0][0]);
		targy3.addActionListener(mezoGombok[0][0]);
		targy4.addActionListener(mezoGombok[0][0]);
		targy5.addActionListener(mezoGombok[0][0]);
		targy6.addActionListener(mezoGombok[0][0]);
		this.frissites();
		
		
		
	}
}
