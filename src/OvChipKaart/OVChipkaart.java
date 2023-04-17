package OvChipKaart;
import java.util.Date;

public class OVChipkaart {
	private int kaartnummer;
	private double saldo;
	private Date geldigTot;
	public static final double INCHECK_TARIEF = 2.50;

	
	public OVChipkaart(int kaartnummer, double saldo, Date geldigTot) {
		
		 this.kaartnummer = kaartnummer;
	     this.saldo = saldo;
	     this.geldigTot = geldigTot;
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
        this.saldo = saldo;
    }
    
    public Date getGeldigTot() {
        return geldigTot;
    }
    
    public void setGeldigTot(Date geldigTot) {
        this.geldigTot = geldigTot;
    }


}
