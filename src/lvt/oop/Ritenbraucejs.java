package lvt.oop;

import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JOptionPane;

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
				/*Izveidot iespēju izvēlēties vienu
				 * no trim ritenu veidiem
				 * Savadīt prasītās atribūtu vērtības
				 * Izveidot attiecīgo riteņa objektu
				 * objektu ievietot Arraylsit
				 */
				izvele = (String) JOptionPane.showInputDialog(null, "Izvēlies riteni",
						"Izvēlne", JOptionPane.QUESTION_MESSAGE, null
						,veidi, veidi[0]);
				if (izvele == null)break;
				
				int ritenaD = parbaude.skaitlaParbaudeI("Ievadi riteņa diametru", 12, 29);
				int sedeklaPoz = parbaude.skaitlaParbaudeI("Ievadi sēdeķla poziciju", 1, 30);
				double cena = parbaude.skaitlaParbaudeD("Ievadi cenu", 1);
				String razotajs = parbaude.virknesParbaude("Ievadi ražotāju");
				
				switch(izvele) {
				case "Velosipēds":
					Velosipeds velosipeds = new Velosipeds(ritenaD, sedeklaPoz, cena, razotajs);
					riteni.add(velosipeds);
					break;
					
				case "Kalnu velosipēds":
					int Atrums = parbaude.skaitlaParbaudeI("Cik ritenim būs ātrumi ", 1, 8);
				
					izvele = (String)JOptionPane.showInputDialog(null, "Vai būs atsperes",
							"Izvēlne", JOptionPane.QUESTION_MESSAGE, null
							,atbilde, atbilde[0]);
					if(izvele == null) break;
					
					boolean a;
					if(izvele == "Jā")
						a = true;
					else a = false;
					
					KalnuRitenis kRitenis = new KalnuRitenis(Atrums, a,
							ritenaD, sedeklaPoz, cena, razotajs);
					riteni.add(kRitenis);	
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
					
					BernuRitenis bRitenis = new BernuRitenis(rit, zvan,
							ritenaD, sedeklaPoz, cena, razotajs);
					riteni.add(bRitenis);
					break;
				}
			}
		}while(izvelesID != 5);
		
	}
	

}