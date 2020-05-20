package projlab;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
/**A jatekban talalhato, mezoket reprezentalo gombok es azok listenerje*/
public class MezoButton extends JButton implements ActionListener{
	/**Melyik mezo reprezentalja a kepernyon.*/
	Mezo mezo;
	public MezoButton(Mezo m) {
		mezo = m;
		this.addActionListener(this);
		}

	
	Mezo getMezo() {
		return mezo;
  }
	/**Esemenykezelo fuggveny, elsuti a megfelelot gombnyomaskor*/
	public void actionPerformed(ActionEvent e) {
		JButton src = (JButton)e.getSource();
		if(src.getText().equals("Lepes a kijelolt mezore")) {
			mezo.getJatek().lep_mezo();
		}
		else if(src.getText().equals("Ho eltakaritasa")) {
			mezo.getJatek().getSzereplok().get(mezo.getJatek().getAktualis()).hoTakaritas(1);
			mezo.getJatek().kepfrissites();
		}
		else if(src.getText().equals("Kor befejezese")) {
			mezo.getJatek().getSzereplok().get(mezo.getJatek().getAktualis()).passz();
		}
		else if(src.getText().equals("Kepesseg")) {
			mezo.getJatek().getSzereplok().get(mezo.getJatek().getAktualis()).kepessegHasznal();
		}
		else if(src.getText().equals("Jegtablabol kias")) {
			mezo.getJatek().getSzereplok().get(mezo.getJatek().getAktualis()).targyKiasas();
		}
		else if(src.getText().equals("Targy1")) {
			mezo.getJatek().targy_hasznal(1);
		}
		else if(src.getText().equals("Targy2")) {
			mezo.getJatek().targy_hasznal(2);
		}
		else if(src.getText().equals("Targy3")) {
			mezo.getJatek().targy_hasznal(3);
		}
		else if(src.getText().equals("Targy4")) {
			mezo.getJatek().targy_hasznal(4);
		}
		else if(src.getText().equals("Targy5")) {
			mezo.getJatek().targy_hasznal(5);
		}
		else if(src.getText().equals("Targy6")) {
			mezo.getJatek().targy_hasznal(6);
		}
		else {
			mezo.getJatek().kivalasztott(mezo);
		}
		mezo.getJatek().kepfrissites();
		
	}
}
