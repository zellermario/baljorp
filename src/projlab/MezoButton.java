package projlab;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
/** A mezoket reprezentáló gombok osztálya ami kezeli a gomblenyomásokat*/
public class MezoButton extends JButton implements ActionListener{
	/**Melyik mezõt reprezentálja a képenyõn.*/
	Mezo mezo;
	public MezoButton(Mezo m) {
		mezo = m;
		}
<<<<<<< Updated upstream
=======
	Mezo getMezo() {
		return mezo;
	}
	/**A játkban lévõ gombok ActonListenerje*/
>>>>>>> Stashed changes
	@Override
	public void actionPerformed(ActionEvent e) {
		mezo.hoTakarit(1);
		mezo.getJatek().kepfrissites();
	}
}
