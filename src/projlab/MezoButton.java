package projlab;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class MezoButton extends JButton implements ActionListener{
	Mezo mezo;
	public MezoButton(Mezo m) {
		mezo = m;
		this.addActionListener(this);
		}
	Mezo getMezo() {
		return mezo;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton src = (JButton)e.getSource();
		if(src.getText().equals("Lépés a kijelölt mezõre")) {
			mezo.getJatek().lep_mezo();
		}
		else if(src.getText().equals("Hó eltakarítása")) {
			mezo.getJatek().getSzereplok().get(mezo.getJatek().getAktualis()).hoTakaritas(1);
			mezo.getJatek().kepfrissites();
		}
		else if(src.getText().equals("Kör befejezése")) {
			mezo.getJatek().getSzereplok().get(mezo.getJatek().getAktualis()).passz();
		}
		else if(src.getText().equals("Jégtáblából kiás")) {
			mezo.getJatek().getSzereplok().get(mezo.getJatek().getAktualis()).targyKiasas();
		}
		else if(src.getText().equals("Képesség")) {
			mezo.getJatek().getSzereplok().get(mezo.getJatek().getAktualis()).kepessegHasznal();
		}
		else if(src.getText().equals("Kör befejezése")) {
			mezo.getJatek().getSzereplok().get(mezo.getJatek().getAktualis()).passz();
		}
		else if(src.getText().equals("Kör befejezése")) {
			mezo.getJatek().getSzereplok().get(mezo.getJatek().getAktualis()).passz();
		}
		else if(src.getText().equals("Tárgy1")) {
			mezo.getJatek().targy_hasznal(1);
		}
		else if(src.getText().equals("Tárgy2")) {
			mezo.getJatek().targy_hasznal(2);
		}
		else if(src.getText().equals("Tárgy3")) {
			mezo.getJatek().targy_hasznal(3);
		}
		else if(src.getText().equals("Tárgy4")) {
			mezo.getJatek().targy_hasznal(4);
		}
		else if(src.getText().equals("Tárgy5")) {
			mezo.getJatek().targy_hasznal(5);
		}
		else if(src.getText().equals("Tárgy6")) {
			mezo.getJatek().targy_hasznal(6);
		}
		else {
			mezo.getJatek().kivalasztott(mezo);
		}
		mezo.getJatek().kepfrissites();
		//mezo.getJatek().getFelulet().getControlpanel().requestFocusInWindow();
		
	}
}
