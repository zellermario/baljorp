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
		mezo.getJatek().kivalasztott_mezo(mezo);
		mezo.getJatek().kepfrissites();
		mezo.getJatek().getFelulet().getControlpanel().requestFocusInWindow();
	}
}
