package lvt.oop;

public class KalnuRitenis extends Velosipeds {
	// Atributi
	private int iestatAtrums;
	private boolean atsperes;
	
	//Konstruktors
	public KalnuRitenis(int iestatAtrums, boolean atsperes, 
			int ritenaD, int sedeklaPoz, double cena, String razotajs) {
		super( ritenaD,  sedeklaPoz,  cena,  razotajs);//Lai ņemt no citas klases
		this.iestatAtrums = iestatAtrums;
		this.atsperes = atsperes;
	}
	
	//Metodes
	public int noteiktIestatAtr() {
		return iestatAtrums;
	}
	
	public void parslegtAtr(int atr) {
		iestatAtrums = atr;
	}
	
	public String izvadit() {
		return "Riteņa ražotājs: "+noteiktRaz()+
				"\nRiteņa cena: "+noteiktCenu()+" EUR"+
				"\nRiteņa lielums collās: "+noteiktRitenaD()+
				"\nIestatītais sēdekļa augstums: "+noteiktSedeklaPoz()+
				"\nKustības ātrums: "+noteiktAtr()+"m/s"+
				"\nIestatītais ātrums: "+noteiktIestatAtr()+
				"\nPapildus amortizacija: "+((atsperes)? "Ir" : "Nav");
	}
 
		
}
