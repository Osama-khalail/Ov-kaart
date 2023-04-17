package OvChipKaart;
import java.util.Date;

public class Incheckpaal {
	
	public void inchecken(OVChipkaart  ovChipkaart) {
		double instaptarief = 20.00;
		double saldo = ovChipkaart.getSaldo();
		
		
		if(saldo < instaptarief) {
			System.out.println("Saldo onvoldoende. U kant helaas niet inchecken.");
		}else {
			ovChipkaart.setSaldo(saldo - instaptarief);
			System.out.println("inchecken is gelukt");
		}
		
		
		
		
	}
	

}
