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
	private Jatek jatek;//
	private JFrame frame;//
	private JPanel controlpanel; private CardLayout cardlayout;
	
	private JPanel menu;
	private JButton startGomb;//
	private JComboBox dropdown;
	private Object menuPoints[];
	
	private JPanel jatekpanel;
		
	private JPanel terkep;//
			//mi a k�l�nbs�g? kell mind a kett�?
	private Mezo mezok[][];//
	private MezoButton mezoGombok[][];//
		
	private JPanel aktiv;
			
	private JPanel gombok; 
	private JButton bas;//
	private JButton btakarit;//
	private JButton bpass;//
	private JButton blep;//
	private JButton kepesseg;//
	private JButton targy1, targy2;//
	private JButton targy3,targy4;//
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
	
	private SzereploKey keys;
	
	
	public Felulet(Jatek j) {
		jatek = j;
		keys = new SzereploKey(j);
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
		menuPoints[0] = "Mindenb�l egy";
		menuPoints[1] = "Mindenb�l kett�";
		menuPoints[2] = "Mindenb�l h�rom";
		
		menu = new JPanel(); menu.setBackground(new Color(204, 255, 229));
		jatekpanel = new JPanel(); jatekpanel.setBackground(new Color(204,229,255));
		vereseg = new JPanel();
		vereseg.setBackground(Color.RED);
		gyozelem = new JPanel();
		gyozelem.setBackground(Color.GREEN);
		
		//menu
		JLabel cim = new JLabel("J�gmez�",SwingConstants.CENTER); cim.setFont(new Font("Serif", Font.BOLD, 60));
		cim.setBackground(menu.getBackground());
		JLabel leiras = new JLabel("Gy�jts�tek �ssze a jelz�rak�ta r�szeit a t�rsaiddal, hogy megmenek�ljetek a jeges mez�r�l. Vigy�zz, ha b�rki is meghal, vesztetek.", SwingConstants.CENTER);
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
		
		Dimension d = new Dimension(100,100); //ez mi a fene? kell m�g?
		
		//jat�kfel�let
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
		bas = new JButton("J�gt�bl�b�l ki�s");
		btakarit = new JButton("H� eltakar�t�sa");
		bpass = new JButton("K�r befejez�se");
		blep = new JButton("L�p�s a kijel�lt mez�re");
		kepesseg = new JButton("K�pess�g");
		targy1 = new JButton("T�rgy1"); targy2 = new JButton("T�rgy2");
		targy3 = new JButton("T�rgy3"); targy4 = new JButton("T�rgy4");
		targy5 = new JButton("T�rgy5"); targy6 = new JButton("T�rgy6");
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
		mezo_tul.setPreferredSize(new Dimension(170, 120));
		mezo_tul.setLayout(new BoxLayout(mezo_tul, BoxLayout.PAGE_AXIS));
		JLabel mezo_cim = new JLabel("Akt�v mez�:"); mezo_tul.add(mezo_cim);
		m_hozzaad = new JPanel(); m_hozzaad.setBackground(jatekpanel.getBackground());
		mezo_tul.add(m_hozzaad);
		aktiv.add(mezo_tul);
		
		szereplo = new JPanel();
		szereplo.setBackground(jatekpanel.getBackground());
		szereplo.setPreferredSize(new Dimension(170, 100));
		JLabel lszer = new JLabel("J�t�kosok:"); szereplo.add(lszer);
		sz_hozzaad = new JPanel();
		sz_hozzaad.setBackground(jatekpanel.getBackground());
		sz_hozzaad.setLayout(new BoxLayout(sz_hozzaad, BoxLayout.PAGE_AXIS));
		szereplo.add(sz_hozzaad);
		aktiv.add(szereplo);
		
		inventory = new JPanel();
		inventory.setBackground(jatekpanel.getBackground());
		inventory.setPreferredSize(new Dimension(170, 200));
		aktiv.add(inventory);
		JLabel linv = new JLabel("Inventory:");
		inventory.add(linv);
		i_hozzaad = new JPanel();
		inventory.add(i_hozzaad);
		JLabel ver = new JLabel("Meghalt egy j�t�kos, vesztett�l!", SwingConstants.CENTER);
		ver.setFont(new Font("Serif", Font.BOLD, 60));
		vereseg.add(ver);
		JLabel gyoz = new JLabel("Gratul�lunk, nyert�l!", SwingConstants.CENTER);
		gyoz.setFont(new Font("Serif", Font.BOLD, 60));
		gyozelem.add(gyoz);
		
		
		controlpanel.add(jatekpanel,"jatekpanel");
		controlpanel.add(menu, "menu");
		controlpanel.add(vereseg,"veresegpanel");
		controlpanel.add(gyozelem, "gyozelempanel");
		controlpanel.setFocusable(true);
		//controlpanel.addKeyListener(keys);
		
		frame.setContentPane(controlpanel);
		cardlayout.show(controlpanel, "menu");
		frame.setVisible(true);
	}
	
	public void frissites() {
		//controlpanel.requestFocusInWindow();
		sz_hozzaad.removeAll();
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
		JLabel havazott = new JLabel("H�r�teg: "+ho); m_hozzaad.add(havazott);
		Targy t = m.belefagyott_targy;
		s_bef = "Belefagyott t�rgy: ";
		if(ho == 0) {
			if (t == null)  s_bef += "-  ";
			else t.rajzolTargy(this, m);
		}
		else s_bef += "?  ";
		JLabel befagyott = new JLabel(s_bef); 
		m_hozzaad.add(befagyott);
	}
	
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

	public void rajzolEszkimo(Mezo m) { m.rajtalevok += " E"; }
	public void rajzolEszkimo(int hely,int heat, int munka) {
		String s = "p"+hely +" Eszkimo - " + heat+ " " + munka;;
		JLabel l = new JLabel(s);
		if (hely == jatek.getAktualis()) l.setForeground(Color.blue);
		sz_hozzaad.add(l);
	}
	
	public void rajzolSarkkutato(Mezo m) { m.rajtalevok += " S"; }
	public void rajzolSarkkutato(int hely,int heat, int munka) {
		String s = "p"+hely +" Sarkkutato - " + heat + " " + munka;
		JLabel l = new JLabel(s);
		if (hely == jatek.getAktualis()) l.setForeground(Color.blue);
		sz_hozzaad.add(l);
	}
	
	public void rajzolJegesmedve(Mezo m) { 
		m.rajtalevok += " J"; }
	
	public void rajzolIglu(Mezo m) {
		m.rajtalevok += " IG";
	}
	
	public void rajzolFelepitettSator(Mezo m) {
		m.rajtalevok += " /\\";
	}
	
	public void rajzolLapat(Mezo m) {
		if(m.getHoreteg() == 0) {
			m.rajtalevok += " LAP.";
			}
		s_bef+= "Lap�t";
		}
	public void rajzolLapatInv(Szereplo sz, int hanyadik) {
		JLabel temp = new JLabel("t" + hanyadik+" - Lap�t");
		i_hozzaad.add(temp);
	}
	
	public void rajzolKotel(Mezo m) {
		if(m.getHoreteg() == 0)
			m.rajtalevok += " K�T.";
		s_bef += "K�t�l";
	}
	public void rajzolKotelInv(Szereplo sz, int hanyadik) {
		JLabel temp = new JLabel("t" + hanyadik+" - K�t�l");
		i_hozzaad.add(temp);
		
	}
	
	public void rajzolTorekenyAso(Mezo m) {
		if(m.getHoreteg() == 0)
			m.rajtalevok += " T.�.";
		s_bef += "T�r�keny �s�";
		}
	public void rajzolTorekenyAsoInv(Szereplo sz, int hanyadik) {
		JLabel temp = new JLabel("t" + hanyadik+" - T�r�keny �s�");
		i_hozzaad.add(temp);		
	}

	public void rajzolEtel(Mezo m) { 
		if(m.getHoreteg() == 0)
			m.rajtalevok += " �T.";
		s_bef += "�tel";
	}
	
	public void rajzolBuvarruha(Mezo m) { 
		if(m.getHoreteg() == 0)
			m.rajtalevok += " B.R.";
		s_bef += "B�v�rruha";
	}
	public void rajzolBuvarruhaInv(Szereplo sz, int hanyadik) {
		JLabel temp = new JLabel("t" + hanyadik+" - Buv�rruha");
		i_hozzaad.add(temp);
	}
	
	public void rajzolRaketaalkatresz(Mezo m) {
		if(m.getHoreteg() == 0)
			m.rajtalevok += " RAK.";
		s_bef += "Rak�taalkatr�sz";
	}
	public void rajzolRaketaalkatreszInv(Szereplo sz, int hanyadik) {
		JLabel temp = new JLabel("t" + hanyadik+" - Rak�taalkatr�sz");
		i_hozzaad.add(temp);
	}
	
	public void rajzolSator(Mezo m) {
		if(m.getHoreteg() == 0)
			m.rajtalevok += " S�T.";
		s_bef += "S�tor";
		}
	public void rajzolSatorInv(Szereplo sz, int hanyadik) {
		JLabel temp = new JLabel("t" + hanyadik+" - S�tor");
		i_hozzaad.add(temp);
	}
	
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
	
	/**
	 * @param x
	 * @param y
	 */
	public void rajzolInstabilJegtabla(int x, int y) { 
		
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
	
	public void Gyozelem() {
		
	}
	
	public void Veres�g() {
		
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
