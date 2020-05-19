package projlab;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
/** A mezoket reprezent√°l√≥ gombok oszt√°lya ami kezeli a gomblenyom√°sokat*/
public class MezoButton extends JButton implements ActionListener{
	/**Melyik mez≈ët reprezent√°lja a k√©peny≈ën.*/
	Mezo mezo;
	public MezoButton(Mezo m) {
		mezo = m;
		this.addActionListener(this);
		}

	/**A j√°tkban l√©v≈ë gombok ActonListenerje*/
	Mezo getMezo() {
		return mezo;
  }
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton src = (JButton)e.getSource();
		if(src.getText().equals("LÈpÈs a kijelˆlt mezıre")) {
			mezo.getJatek().lep_mezo();
		}
		else if(src.getText().equals("HÛ eltakarÌt·sa")) {
			mezo.getJatek().getSzereplok().get(mezo.getJatek().getAktualis()).hoTakaritas(1);
			mezo.getJatek().kepfrissites();
		}
		else if(src.getText().equals("Kˆr befejezÈse")) {
			mezo.getJatek().getSzereplok().get(mezo.getJatek().getAktualis()).passz();
		}
		else if(src.getText().equals("JÈgt·bl·bÛl ki·s")) {
			mezo.getJatek().getSzereplok().get(mezo.getJatek().getAktualis()).targyKiasas();
		}
		else if(src.getText().equals("T·rgy1")) {
			mezo.getJatek().targy_hasznal(1);
		}
		else if(src.getText().equals("T·rgy2")) {
			mezo.getJatek().targy_hasznal(2);
		}
		else if(src.getText().equals("T·rgy3")) {
			mezo.getJatek().targy_hasznal(3);
		}
		else if(src.getText().equals("T·rgy4")) {
			mezo.getJatek().targy_hasznal(4);
		}
		else if(src.getText().equals("T·rgy5")) {
			mezo.getJatek().targy_hasznal(5);
		}
		else if(src.getText().equals("T·rgy6")) {
			mezo.getJatek().targy_hasznal(6);
		}
		else {
			mezo.getJatek().kivalasztott(mezo);
		}
		mezo.getJatek().kepfrissites();
		
	}
}
