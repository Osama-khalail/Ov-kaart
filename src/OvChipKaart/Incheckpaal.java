package OvChipKaart;
import java.util.Date;
import java.util.HashMap;

public class Incheckpaal {
    HashMap<Integer, String> ingecheckteOVKaarten = new HashMap<Integer, String>();
	   private String station;
	    private OVChipkaart ovChipkaart;
	   private int id;
	   
		public static final double INCHECK_KOSTEN = 10;
	    public Incheckpaal(int id,String station ) {
	    	this.station = station;
	    	
	    	this.id=id;
	    	}
	    
	  
	    public String getStation() {
	        return station;
	    }
	    public int getId() {
	        return id;
	    }

	    public void inchecken(OVChipkaart inchecken) {
	    	if (inchecken.getSaldo() < INCHECK_KOSTEN) {
	    		System.out.println("Onvoldoende saldo om in te checken.");
	    	}else {
	    		inchecken.setstationstart(this.getStation());
	    		inchecken.setSaldo(INCHECK_KOSTEN);
	    		System.out.println("je bent in geceheckt in : "+inchecken.getstationstart());
	    		System.out.println("jou saldo is : "+inchecken.getSaldo());
	    	}
	    	
	    	
	    }
	    public void uitchecken(OVChipkaart ovChipkaart) {
	    	
	        if (ovChipkaart.isIngecheckt()) {
	            double teBetalenBedrag = 10.0;
	            double saldo = ovChipkaart.getSaldo();
	            if (saldo >= teBetalenBedrag) {
	                ovChipkaart.setSaldo(saldo - teBetalenBedrag);
	                ovChipkaart.setIngecheckt(false);
	                System.out.println("Uitchecken geslaagd. Er is " + teBetalenBedrag + " euro van uw saldo afgeschreven.");
	            } else {
	                System.out.println("Uitchecken mislukt. Niet voldoende saldo op de kaart.");
	            }
	        } else {
	            System.out.println("Uitchecken mislukt. Kaart is niet ingecheckt.");
	        }
	    }



	    
	    

		
		
	}
	


