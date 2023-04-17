package OvChipKaart;
import java.util.Date;

public class OVChipkaart {
	private int kaartnummer;
	private double saldo;
	private Date geldigTot;
	private String stationstart;
	public static final double INCHECK_KOSTEN = 2.5;
	private boolean ingecheckt = false;


	
	public OVChipkaart(int kaartnummer, double saldo, Date geldigTot) {
		
		 this.kaartnummer = kaartnummer;
	     this.saldo = saldo;
	     this.geldigTot = geldigTot;
	    
	}
	public boolean isIngecheckt() {
	    return ingecheckt;
	}
	public void setIngecheckt(boolean ingecheckt) {
	    this.ingecheckt = ingecheckt;
	}
	public String getstationstart() {
		return stationstart;
	}
	
	public void setstationstart(String stationstart) {
		this.stationstart=stationstart;
	}
    public int getKaartnummer() {
        return kaartnummer;
    }
    
    public void setKaartnummer(int kaartnummer) {
        this.kaartnummer = kaartnummer;
    }
    
    public double getSaldo() {
        return saldo;
    }
    
    public void setSaldo(double saldo) {
        this.saldo = this.saldo -saldo;
    }
    
    public Date getGeldigTot() {
        return geldigTot;
    }
    
    public void setGeldigTot(Date geldigTot) {
        this.geldigTot = geldigTot;
    }
    


}
