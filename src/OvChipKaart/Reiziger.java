package OvChipKaart;
 import java.util.Date;
 import java.util.ArrayList;
 class Reiziger {
	private int id;
	private String naam;
	private String adres;
	private String wachtwoord;
    private ArrayList<OVChipkaart> ovChipkaarten;
	
	public Reiziger(int id,String naam, String adres,String wachtwoord) {
		this.id=id;
		this.naam=naam;
		this.adres=adres;
		this.wachtwoord=wachtwoord;	
        this.ovChipkaarten = new ArrayList<OVChipkaart>();
	}
    public void addOVChipkaart(OVChipkaart ovChipkaart) {
        ovChipkaarten.add(ovChipkaart);
    }
    
    public ArrayList<OVChipkaart> getOVChipkaarten() {
        return ovChipkaarten;
    }

	public OVChipkaart getOVKaartMetKaartNummer(int kaartNummer) {
		for (OVChipkaart ovKaart : ovChipkaarten) {
			if (ovKaart.getKaartnummer() == kaartNummer) {
				return ovKaart;
			}
		}
		return null;
	}

	 public int getId() {
	        return id;
	    }
	public void setId(int id) {
		this.id=id;
	}
	public void setNaam(String naam) {
		this.naam=naam;
	}
	   public String getNaam() {
	        return naam;
	    }
	public String getAdres() { 
		return adres;
	}	
	public void setAdres(String adres) {
		this.adres =adres;
	}
	public void setWachtwoord(String wachtwoord) {
		this.wachtwoord=wachtwoord;
	}
	public String getWachtwoord () {
		return wachtwoord;
	}
	


 public void inchecken(int kaartnummer, double bedrag) {
     // zoek de OV-chipkaart met het opgegeven kaartnummer
     OVChipkaart ovChipkaart = null;
     for (OVChipkaart kaart : ovChipkaarten) {
         if (kaart.getKaartnummer() == kaartnummer) {
             ovChipkaart = kaart;
             break;
         }
     }
     
     // als er geen OV-chipkaart is gevonden, geef een foutmelding en stop de methode
     if (ovChipkaart == null) {
         System.out.println("Fout: OV-chipkaart niet gevonden");
         return;
     }
     
     // controleer of de reiziger genoeg saldo heeft om in te checken
     double saldo = ovChipkaart.getSaldo();
     if (saldo < bedrag) {
         System.out.println("Fout: Niet genoeg saldo op de OV-chipkaart");
         return;
     }
     
     // verminder het saldo van de OV-chipkaart met het bedrag van de reis
     ovChipkaart.setSaldo(saldo - bedrag);
     
     // voer verdere incheck-activiteiten uit, zoals het registreren van de inchecktijd
     // ...
     
     System.out.println("Inchecken geslaagd");
 }
}
