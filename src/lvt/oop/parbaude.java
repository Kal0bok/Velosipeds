package lvt.oop;

import java.util.regex.Pattern;

import javax.swing.JOptionPane;

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
}
