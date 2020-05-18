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
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton src = (JButton)e.getSource();
		if(src.getText().equals("L�p�s a kijel�lt mez�re")) {
			mezo.getJatek().lep_mezo();
			System.out.println("gfhd");
		}
		else if(src.getText().equals("H� eltakar�t�sa")) {
			mezo.getJatek().getSzereplok().get(mezo.getJatek().getAktualis()).hoTakaritas(1);
		}
		else if(src.getText().equals("K�r befejez�se")) {
			mezo.getJatek().getSzereplok().get(mezo.getJatek().getAktualis()).passz();
			System.out.println("gfhd");
		}
		else if(src.getText().equals("J�gt�bl�b�l ki�s")) {
			mezo.getJatek().getSzereplok().get(mezo.getJatek().getAktualis()).targyKiasas();
			System.out.println("gfhd");
		}
		else if(src.getText().equals("L�p�s a kijel�lt mez�re")) {
	
		}
		else {
			mezo.getJatek().kivalasztott(mezo);
		}
		mezo.getJatek().kepfrissites();
		//mezo.getJatek().getFelulet().getControlpanel().requestFocusInWindow();
		
	}
}
