package projlab;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
/** A mezoket reprezent�l� gombok oszt�lya ami kezeli a gomblenyom�sokat*/
public class MezoButton extends JButton implements ActionListener{
	/**Melyik mez�t reprezent�lja a k�peny�n.*/
	Mezo mezo;
	public MezoButton(Mezo m) {
		mezo = m;
		}
<<<<<<< Updated upstream
=======
	Mezo getMezo() {
		return mezo;
	}
	/**A j�tkban l�v� gombok ActonListenerje*/
>>>>>>> Stashed changes
	@Override
	public void actionPerformed(ActionEvent e) {
		mezo.hoTakarit(1);
		mezo.getJatek().kepfrissites();
	}
}
