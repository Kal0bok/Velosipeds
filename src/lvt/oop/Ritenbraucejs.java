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
				
				switch(izvele) {
				case "Velosipēds":
					int ritenaD = Parbaude.skaitlaParbaudeI("Ievadi riteņa diametru", 12, 29);
					int sedeklaPoz = Parbaude.skaitlaParbaudeI("Ievadi sēdeķla poziciju", 1, 30);
					double cena = Parbaude.skaitlaParbaudeD("Ievadi cenu", 1);
					String razotajs = Parbaude.virknesParbaude("Ievadi ražotāju");
					break;
				case "Kalnu velosipēds":
					break;
				case "Bērnu velosipēds":
					break;
				}
			}
		}while(izvelesID != 5);
		
	}
	

}