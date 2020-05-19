package projlab;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import java.util.List;


public class Felulet implements ActionListener{

	/**Az aktuĂˇlis jĂˇtĂ©k.*/
	private Jatek jatek;
	/**Frame ami tartalmazza a jatekhoz szĂĽksĂ©ges paneleket.*/
	private JFrame frame;
	/**FĹ‘ panel ami tartalmazza a tĂ¶bbi panelt Ă­gy tudunk vĂˇltani kĂ¶zĂ¶ttĂĽk.*/
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
	/**Gombokat tratalmazĂł panel*/
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

	private JPanel vereseg;
	private JPanel gyozelem;

		
	/**Felulet konstruktora*/
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
		menuPoints[0] = "MindenbĹ‘l egy";
		menuPoints[1] = "MindenbĹ‘l kettĹ‘";
		menuPoints[2] = "MindenbĹ‘l hĂˇrom";
		
		menu = new JPanel(); menu.setBackground(new Color(204, 255, 229));
		jatekpanel = new JPanel(); jatekpanel.setBackground(new Color(204,229,255));
		vereseg = new JPanel();
		vereseg.setBackground(Color.RED);
		gyozelem = new JPanel();
		gyozelem.setBackground(Color.GREEN);
		
		//menu
		JLabel cim = new JLabel("JĂ©gmezĹ‘",SwingConstants.CENTER); cim.setFont(new Font("Serif", Font.BOLD, 60));
		cim.setBackground(menu.getBackground());

		JLabel leiras = new JLabel("GyĂĽjtsĂ©tek Ă¶ssze a jelzĹ‘rakĂ©ta rĂ©szeit a tĂˇrsaiddal, hogy megmenekĂĽljetek a jeges mezĹ‘rĹ‘l. VigyĂˇzz, ha bĂˇrki is meghal, vesztetek.", SwingConstants.CENTER);

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
		
		Dimension d = new Dimension(100,100); //ez mi a fene? kell mĂ©g?
		
		//jatĂ©kfelĂĽlet
		terkep = new JPanel();
		terkep.setBackground(jatekpanel.getBackground());
		aktiv = new JPanel();
		aktiv.setBackground(jatekpanel.getBackground());
		
		terkep.setPreferredSize(new Dimension(1100-300,800));
		jatekpanel.add(terkep, BorderLayout.WEST);
		aktiv.setPreferredSize(new Dimension(270, 800)); 
		jatekpanel.add(aktiv, BorderLayout.EAST);
		aktiv.setLayout(new BoxLayout(aktiv, BoxLayout.PAGE_AXIS));
		
		gombok = new JPanel(); gombok.setBackground(jatekpanel.getBackground());
		gombok.setPreferredSize(new Dimension(170, 200));
		bas = new JButton("JĂ©gtĂˇblĂˇbĂłl kiĂˇs");
		btakarit = new JButton("HĂł eltakarĂ­tĂˇsa");
		bpass = new JButton("KĂ¶r befejezĂ©se");
		blep = new JButton("LĂ©pĂ©s a kijelĂ¶lt mezĹ‘re");
		kepesseg = new JButton("KĂ©pessĂ©g");
		targy1 = new JButton("TĂˇrgy1"); targy2 = new JButton("TĂˇrgy2");
		targy3 = new JButton("TĂˇrgy3"); targy4 = new JButton("TĂˇrgy4");
		targy5 = new JButton("TĂˇrgy5"); targy6 = new JButton("TĂˇrgy6");
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
		mezo_tul.setPreferredSize(new Dimension(170, 120));
		JLabel mezo_cim = new JLabel("AktĂ­v mezĹ‘:"); mezo_tul.add(mezo_cim);
		m_hozzaad = new JPanel();
		m_hozzaad.setBackground(jatekpanel.getBackground());
		m_hozzaad.setLayout(new BoxLayout(m_hozzaad, BoxLayout.PAGE_AXIS));
		mezo_tul.add(m_hozzaad);
		aktiv.add(mezo_tul);
		
		szereplo = new JPanel();
		szereplo.setBackground(jatekpanel.getBackground());
		szereplo.setLayout(new BoxLayout(szereplo, BoxLayout.PAGE_AXIS));
		szereplo.setPreferredSize(new Dimension(170, 100));
		JLabel lszer = new JLabel("JĂˇtĂ©kosok:"); szereplo.add(lszer);
		sz_hozzaad = new JPanel();
		sz_hozzaad.setBackground(jatekpanel.getBackground());
		sz_hozzaad.setLayout(new BoxLayout(sz_hozzaad, BoxLayout.PAGE_AXIS));
		szereplo.add(sz_hozzaad);
		aktiv.add(szereplo);
		
		inventory = new JPanel();
		inventory.setBackground(jatekpanel.getBackground());
		inventory.setLayout(new BoxLayout(inventory, BoxLayout.PAGE_AXIS));
		inventory.setPreferredSize(new Dimension(170, 200));
		JLabel linv = new JLabel("Inventory:");	inventory.add(linv);
		i_hozzaad = new JPanel();
		i_hozzaad.setBackground(jatekpanel.getBackground());
		i_hozzaad.setLayout(new BoxLayout(i_hozzaad, BoxLayout.PAGE_AXIS));
		inventory.add(i_hozzaad);
    aktiv.add(inventory);

		JLabel ver = new JLabel("Meghalt egy jĂˇtĂ©kos, vesztettĂ©l!", SwingConstants.CENTER);
		ver.setFont(new Font("Serif", Font.BOLD, 60));
		vereseg.add(ver);
		JLabel gyoz = new JLabel("GratulĂˇlunk, nyertĂ©l!", SwingConstants.CENTER);
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
		int ho = m.getHoreteg();
		JLabel havazott = new JLabel("HĂłrĂ©teg: "+ho); m_hozzaad.add(havazott);
		Targy t = m.belefagyott_targy;
		s_bef = "Belefagyott tĂˇrgy: ";
		if(ho == 0) {
			if (t == null)  s_bef += "-  ";
			else t.rajzolTargy(this, m);
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
		String s = "p"+hely +" Eszkimo - " + heat+ " hĹ‘, " + munka+" munka";
		JLabel l = new JLabel(s);
		if (hely == jatek.getAktualis()) l.setForeground(Color.blue);
		sz_hozzaad.add(l);
	}
	/**Ez a fuggveny egy sarkkutato kirajzolasaert felelos a megfelelo mezore*/
	public void rajzolSarkkutato(Mezo m) { m.rajtalevok += " S"; }
	/**Ez a fuggveny egy sarkkutato kirajzolasaert felelos az oldalso panelra*/
	public void rajzolSarkkutato(int hely,int heat, int munka) {
		String s = "p"+hely +" Sarkkutato - " + heat + " hĹ‘, " + munka + " munka"; 
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
		s_bef+= "LapĂˇt";
		}

	/**Ez a fuggveny egy lapat kirajzolasaert felelos a tarhelyre*/
	public void rajzolLapatInv(Szereplo sz, int hanyadik) {
		JLabel temp = new JLabel("t" + hanyadik+" - Lapát");
		i_hozzaad.add(temp);
	}
	/**Ez a fuggveny egy kotel kirajzolasaert felelos a megfelelo mezore*/
	public void rajzolKotel(Mezo m) {
		if(m.getHoreteg() == 0)
			m.rajtalevok += " KÖT.";
		s_bef += "KĂ¶tĂ©l";
	}

	/**Ez a fuggveny egy kotel kirajzolasaert felelos a tarhelyre*/
	public void rajzolKotelInv(Szereplo sz, int hanyadik) {
		JLabel temp = new JLabel("t" + hanyadik+" - KĂ¶tĂ©l");
		i_hozzaad.add(temp);
		
	}
	/**Ez a fuggveny egy torekeny aso kirajzolasaert felelos a megfelelo mezore*/
	public void rajzolTorekenyAso(Mezo m) {
		if(m.getHoreteg() == 0)
			m.rajtalevok += " T.Ă�.";
		s_bef += "TĂ¶rĂ©keny ĂˇsĂł";
		}

	/**Ez a fuggveny egy torekeny aso kirajzolasaert felelos a tarhelyre*/
	public void rajzolTorekenyAsoInv(Szereplo sz, int hanyadik) {
		JLabel temp = new JLabel("t" + hanyadik+" - TĂ¶rĂ©keny Ă�sĂł");
		i_hozzaad.add(temp);		
	}

	/**Ez a fuggveny egy etel kirajzolasaert felelos a megfelelo mezore*/
	public void rajzolEtel(Mezo m) { 
		if(m.getHoreteg() == 0)
			m.rajtalevok += " Ă‰T.";
		s_bef += "Ă‰tel";
	}
	/**Ez a fuggveny egy buvarruha kirajzolasaert felelos a megfelelo mezore*/
	public void rajzolBuvarruha(Mezo m) { 
		if(m.getHoreteg() == 0)
			m.rajtalevok += " B.R.";
		s_bef += "BĂşvĂˇrruha";
	}
	/**Ez a fuggveny egy buvarruha kirajzolasaert felelos a tarhelyre*/
	public void rajzolBuvarruhaInv(Szereplo sz, int hanyadik) {
		JLabel temp = new JLabel("t" + hanyadik+" - BuvĂˇrruha");
		i_hozzaad.add(temp);
	}
	/**Ez a fuggveny egy raketaalkatresz kirajzolasaert felelos a megfelelo mezore*/
	public void rajzolRaketaalkatresz(Mezo m) {
		if(m.getHoreteg() == 0)
			m.rajtalevok += " RAK.";
		s_bef += "RakĂ©taalkatrĂ©sz";
	}

	/**Ez a fuggveny egy raketaalkatresz kirajzolasaert felelos a tarhelyre*/
	public void rajzolRaketaalkatreszInv(Szereplo sz, int hanyadik) {
		JLabel temp = new JLabel("t" + hanyadik+" - RakĂ©taalkatrĂ©sz");
		i_hozzaad.add(temp);
	}
	/**Ez a fuggveny egy sator kirajzolasaert felelos a megfelelo mezore*/
	public void rajzolSator(Mezo m) {
		if(m.getHoreteg() == 0)
			m.rajtalevok += " SĂ�T.";
		s_bef += "SĂˇtor";
		}

	/**Ez a fuggveny egy sator kirajzolasaert felelos a tarhelyre*/
	public void rajzolSatorInv(Szereplo sz, int hanyadik) {
		JLabel temp = new JLabel("t" + hanyadik+" - SĂˇtor");
		i_hozzaad.add(temp);
	}
	/**Ez a fuggveny egy stabil jegtable kirajzolasaert felelos a megfelelo helyre*/
	public void rajzolStabilJegtabla(int x, int y) {
	if(mezoGombok[x][y].getMezo().horeteg == 0) {
		mezoGombok[x][y].setBackground(Color.WHITE);
		mezoGombok[x][y].setText("0" + mezoGombok[x][y].mezo.rajtalevok);
	}
	else {
		mezoGombok[x][y].setBackground(Color.BLUE);
		mezoGombok[x][y].setText("?" + mezoGombok[x][y].mezo.rajtalevok);
		}
	if(mezoGombok[x][y].getMezo().getVizsgalt()) mezoGombok[x][y].setBackground(Color.GREEN);
	}

	/**Ez a fuggveny egy instabil jegtable kirajzolasaert felelos a megfelelo helyre*/
	public void rajzolInstabilJegtabla(int x, int y) { 
		
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
	public void rajzolLuk(int x, int y) {
		if(mezoGombok[x][y].getMezo().horeteg == 0)
		{
			mezoGombok[x][y].setBackground(Color.RED);
			mezoGombok[x][y].setText("Luk" + mezoGombok[x][y].mezo.rajtalevok);
		}
		else {
			mezoGombok[x][y].setBackground(Color.BLUE);
			mezoGombok[x][y].setText("?" + mezoGombok[x][y].mezo.rajtalevok);
			if(mezoGombok[x][y].getMezo().getVizsgalt()) mezoGombok[x][y].setBackground(Color.GREEN);
		}
		}
		
	
	public void rajzolHovihar(Mezo m) {
		
	}
	/**Ez a fuggveny a gyozelem panel megjeleniteseert felelos.*/
	public void Gyozelem() {
		cardlayout.show(controlpanel, "gyozlempanel");
	}
	/**Ez a fuggveny a vereseg panel megjeleniteseert felelos.*/
	public void Vereseg() {
		cardlayout.show(controlpanel, "veresegpanel");
	}

	/**A menuben levo gombok ActionListenerje*/
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
