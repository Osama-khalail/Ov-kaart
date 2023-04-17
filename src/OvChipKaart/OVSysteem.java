package OvChipKaart;

import java.util.HashMap;

public class OVSysteem {
    HashMap<Integer, String> ingecheckteOVKaarten = new HashMap<Integer, String>();
    HashMap<String, Integer> stations = new HashMap<>() {{
        put("Arnhem", 10);
        put("Nijmegen", 15);
        put("Utrecht", 20);
        put("Amsterdam", 25);
    }};


    public void inchecken(Reiziger reiziger, int kaartnummer, String station) {
        // Controleer of de reiziger voldoende saldo heeft om in te checken
        OVChipkaart ovChipkaart = reiziger.getOVKaartMetKaartNummer(kaartnummer);
        if (ovChipkaart.getSaldo() < OVChipkaart.INCHECK_TARIEF) {
            System.out.println("Onvoldoende saldo om in te checken.");
            return;
        }

        if (!stations.containsKey(station)) {
            System.out.println("Station bestaat niet!");
            return;
        }

        if (!ingecheckteOVKaarten.containsKey(kaartnummer)) {
            // hij is niet gevonden in de ingecheckte mensen dus hij is niet ingecheckt
            System.out.println("U bent ingecheckt bij station " + station);
            ovChipkaart.setSaldo(ovChipkaart.getSaldo() - OVChipkaart.INCHECK_TARIEF);
            ingecheckteOVKaarten.put(kaartnummer, station);
        }

    }

    public void uitchecken(Reiziger reiziger, int kaartnummer, String station) {
        OVChipkaart ovChipkaart = reiziger.getOVKaartMetKaartNummer(kaartnummer);

        if (ingecheckteOVKaarten.containsKey(kaartnummer)) {
            // hij is ingecheckt dus we kunnen hem uitchecken

            // als je bij zelfde station uitcheckt, niks doen alleen incheck tarief
            if (station.equals(ingecheckteOVKaarten.get(kaartnummer))) {
                ovChipkaart.setSaldo(ovChipkaart.getSaldo() + OVChipkaart.INCHECK_TARIEF);
                System.out.println("U heeft het inchecken geannuleerd. Saldo: " + ovChipkaart.getSaldo());
                return;
            }

            ovChipkaart.setSaldo(ovChipkaart.getSaldo() - (stations.get(station) - OVChipkaart.INCHECK_TARIEF));
            System.out.println("U heeft gereist van " + ingecheckteOVKaarten.get(kaartnummer) + " tot " + station);
            System.out.println("U heeft nog " + ovChipkaart.getSaldo() + " op uw ov-kaart");
            ingecheckteOVKaarten.remove(kaartnummer);
        }
    }
}

