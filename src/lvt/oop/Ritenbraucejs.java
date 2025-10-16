package lvt.oop;

import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

public class Ritenbraucejs {

	public static void main(String[] args) {
		String izvele;
		int izvelesID;
		String[] darbibas = {"Jauns ritenis", "Noņemt riteni",
				"Riteņu saraksts", "Kārtot pēc cenas", "Izsaukt metodi",
				"Aizvērt programmu"};
		String[] veidi = {"Velosipēds", "Kalnu velosipēds", "Bērnu velosipēds"};
		String[] atbilde = {"Jā", "Nē"};
		ArrayList<Object> riteni = new ArrayList<>();
		
		do {
			izvele = (String) JOptionPane.showInputDialog(null, "Izvēlies darbību",
					"Izvēlne", JOptionPane.QUESTION_MESSAGE, null
					,darbibas, darbibas[0]);
			if(izvele == null) break;
			
			izvelesID = Arrays.asList(darbibas).indexOf(izvele);
			
			switch(izvelesID) {
			case 0:
				izvele = (String) JOptionPane.showInputDialog(null, "Izvēlies riteni",
						"Izvēlne", JOptionPane.QUESTION_MESSAGE, null
						,veidi, veidi[0]);
				if (izvele == null)break;
				
				double ritenaD = Metodes.skaitlaParbaude("Ievadi riteņa diametru", 12, 29);
				int sedeklaPoz = Metodes.iestatitSedekli();
				double cena = Metodes.skaitlaParbaude("Ievadi cenu", 1.0, 9999.99);
				String razotajs = Metodes.virknesParbaude("Ievadi ražotāju");
				
				switch(izvele) {
				case "Velosipēds":
					riteni.add(new Velosipeds((int)ritenaD, sedeklaPoz, cena, razotajs));
					JOptionPane.showMessageDialog(null, "Veiksmīgi uztaisīts velosipēds",
							"Paziņojums", JOptionPane.INFORMATION_MESSAGE);
					break;
					
				case "Kalnu velosipēds":
					int Atrums = Metodes.iestatitAtrumu();
				
					izvele = (String)JOptionPane.showInputDialog(null, "Vai būs atsperes",
							"Izvēlne", JOptionPane.QUESTION_MESSAGE, null
							,atbilde, atbilde[0]);
					if(izvele == null) break;
					
					boolean a;
					if(izvele == "Jā")
						a = true;
					else a = false;
					
					riteni.add(new KalnuRitenis(Atrums, a,
							(int)ritenaD, sedeklaPoz, cena, razotajs));	
					JOptionPane.showMessageDialog(null, "Veiksmīgi uztaisīts kalnu ritenis",
							"Paziņojums", JOptionPane.INFORMATION_MESSAGE);
					break;
					
				case "Bērnu velosipēds":
					izvele = (String)JOptionPane.showInputDialog(null, "Vai būs papildriteņi?",
							"Izvēlne", JOptionPane.QUESTION_MESSAGE, null
							,atbilde, atbilde[0]);
					if(izvele == null) break;
					
					boolean rit;
					if(izvele == "Jā") rit = true;
					else rit = false;
					
					izvele = (String)JOptionPane.showInputDialog(null, "Vai būs zvaniņš?",
							"Izvēlne", JOptionPane.QUESTION_MESSAGE, null
							,atbilde, atbilde[0]);
					if(izvele == null) break;
					
					boolean zvan;
					if(izvele == "Jā") zvan = true;
					else zvan = false;
					
					riteni.add(new BernuRitenis(rit, zvan,
							(int)ritenaD, sedeklaPoz, cena, razotajs));
					JOptionPane.showMessageDialog(null, "Veiksmīgi uztaisīts bērnu ritenis",
							"Paziņojums", JOptionPane.INFORMATION_MESSAGE);
					break;
				}
				break;
			case 1:
				if(riteni.size() > 0) { 
					int ritID = Metodes.ritenaIzvele(riteni);
					
				}else {
					JOptionPane.showMessageDialog(null, "Nav ievadīts neviens ritenis",
							"Kļūda", JOptionPane.ERROR_MESSAGE);
					break;
				}
				
				break;
				
			case 2:
				break;
			case 3:
				break;
			case 4:
				String str = "";
				if(riteni.size()>0) {
				for(int i=0; i<riteni.size(); i++) {
					
					
				}
				JTextArea ta = new JTextArea (str, 10, 40);
				ta.setEditable(false);
				JScrollPane sp = new JScrollPane(ta);
				sp.setVerticalScrollBarPolicy(
						ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
				JOptionPane.showMessageDialog(ta, sp, "Riteņi",
						JOptionPane.PLAIN_MESSAGE);
				}
				break;
			case 5:
				JOptionPane.showMessageDialog(null, "Programma apturēta", "Apturēta",
						JOptionPane.PLAIN_MESSAGE);
				break;
			}
		}while(izvelesID != 5);
		
	}
	

}