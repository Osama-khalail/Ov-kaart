package OvChipKaart;

import java.util.ArrayList;

class Reiziger {
    private int id;
    private String naam;
    private String adres;
    private String wachtwoord;
    private ArrayList<OVChipkaart> ovChipkaarten;

    public Reiziger(int id, String naam, String adres, String wachtwoord) {
        this.id = id;
        this.naam = naam;
        this.adres = adres;
        this.wachtwoord = wachtwoord;
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
            if (ovKaart.getKaartNummer() == kaartNummer) {
                return ovKaart;
            }
        }
        return null;
    }

    public int getId() {
        return id;
    }
    public String getNaam() {
        return naam;
    }
    public String getAdres() {
        return adres;
    }
    public String getWachtwoord() {
        return wachtwoord;
    }
}
