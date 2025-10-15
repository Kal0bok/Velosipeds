package lvt.oop;

import java.util.regex.Pattern;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class parbaude {
	public static String virknesParbaude(String zinojums) {
		String virkne;
		do {
			virkne = JOptionPane.showInputDialog(zinojums);
			if(virkne == null)
				return null;
		}while(!Pattern.matches("^[\\p{L} .]+$", virkne));
		return virkne;
	}
	public static int skaitlaParbaudeI(String zinojums, int min, int max) {
		String ievade;
		int skaitlis;
		while(true) {
			ievade = JOptionPane.showInputDialog(null, zinojums, 
					"Datu ievade", JOptionPane.INFORMATION_MESSAGE); 
			if(ievade == null)
				return -1;
			try {
				skaitlis = Integer.parseInt(ievade);
				if(skaitlis < min && skaitlis > max) {
					JOptionPane.showMessageDialog(null, 
					"Norādīts nederīgs intervāls", "Nekorekti dati",
					JOptionPane.WARNING_MESSAGE);
					continue;
				}
				
				return skaitlis;
			}catch(NumberFormatException e) {
				JOptionPane.showMessageDialog(null,
					"Netika ievadīts vesels skaitlis", "Nekorekti dati",
					JOptionPane.WARNING_MESSAGE);
			}
		}
	}
		public static Double skaitlaParbaudeD(String zinojums, int min) {
			String ievade;
			Double skaitlis;
			while(true) {
				ievade = JOptionPane.showInputDialog(null, zinojums, 
						"Datu ievade", JOptionPane.INFORMATION_MESSAGE); 
				if(ievade == null)
					return -1.0;
				try {
					skaitlis = Double.valueOf(ievade);
					if(skaitlis < min) {
						JOptionPane.showMessageDialog(null, 
						"Norādīts nederīgs intervāls", "Nekorekti dati",
						JOptionPane.WARNING_MESSAGE);
						continue;
					}
					
					return skaitlis;
				}catch(NumberFormatException e) {
					JOptionPane.showMessageDialog(null,
						"Netika ievadīts vesels skaitlis", "Nekorekti dati",
						JOptionPane.WARNING_MESSAGE);
				}
			}
	}
		static JSlider bidjosla(JOptionPane jop, int max) {
			JSlider js = new JSlider(JSlider.HORIZONTAL, 1, max, 1);
			js.setMajorTickSpacing(1);
			js.setPaintTicks(true);
			js.setPaintLabels(true);
			jop.setInputValue(js.getValue());
			
			ChangeListener cl = new ChangeListener() {
				public void stateChanged(ChangeEvent ce) {
					JSlider sl = (JSlider) ce.getSource();
					
					if(!sl.getValueIsAdjusting()) {
						jop.setInputValue(Integer.valueOf(sl.getValue()));
					}
				}
			};
			js.addChangeListener(cl);
			return js;
		}
		static int iestatitSedekli() {
			JFrame jf = new JFrame();
			JOptionPane jop = new JOptionPane();
			JSlider js = bidjosla(jop, 6);
			jop.setMessage(new Object[] {"Kuru ātrumu iestatīt?", js});
			jop.setMessageType(JOptionPane.QUESTION_MESSAGE);
			jop.setOptionType(JOptionPane.OK_CANCEL_OPTION);
			JDialog jd = jop.createDialog(jf, "Ātruma iestatīšana");
			jd.setVisible(true);
			return (int)jop.getInputValue();
		}
}
