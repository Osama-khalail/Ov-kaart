package OvChipKaart;

import java.util.Date;
import java.util.HashMap;

public class InCheckUitCheck {
    public enum InCheckUitCheckType {
        IN,
        UIT
    }
    
    private Reiziger reiziger;
    private OVChipkaart ovChipkaart;
    private String station;
    private InCheckUitCheckType type;
    
    public InCheckUitCheck(Reiziger reiziger, OVChipkaart ovChipkaart, String station, InCheckUitCheckType type) {
        this.reiziger = reiziger;
        this.ovChipkaart = ovChipkaart;
        this.station = station;
        this.type = type;
    }
    
    public void check() {
        // Voer de incheck- of uitcheck-actie uit

    }
    
}
