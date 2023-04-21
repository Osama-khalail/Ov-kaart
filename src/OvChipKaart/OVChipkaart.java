package OvChipKaart;
import java.util.Date;

public class OVChipkaart {
	public static final double INCHECK_KOSTEN = 2.5;
	private int kaartNummer;
	private double saldo;
	private Date geldigTot;
	private Station startStation;

	public OVChipkaart(int kaartNummer, double saldo, Date geldigTot) {
		 this.kaartNummer = kaartNummer;
	     this.saldo = saldo;
	     this.geldigTot = geldigTot;
	}

	public int getKaartNummer() {
		return kaartNummer;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public Station getStartStation() {
		return startStation;
	}

	public void setStartStation(Station startStation) {
		this.startStation = startStation;
	}

	public Date getGeldigTot() {
		return geldigTot;
	}
}
