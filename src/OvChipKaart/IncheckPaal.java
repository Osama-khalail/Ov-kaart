package OvChipKaart;


import java.text.DecimalFormat;

public class IncheckPaal {
    private Station station;
    private int id;
    public static final double INCHECK_KOSTEN = 10;

    public IncheckPaal(int id, Station station) {
        this.station = station;
        this.id = id;
    }

    public Station getStation() {
        return station;
    }

    public int getId() {
        return id;
    }

    public void inchecken(OVChipkaart ovChipkaart) {
        if (ovChipkaart.getSaldo() < INCHECK_KOSTEN) {
            System.out.println("Onvoldoende saldo om in te checken.");
            return;
        }

        ovChipkaart.setSaldo(ovChipkaart.getSaldo() - INCHECK_KOSTEN);
        ovChipkaart.setStartStation(station);
        System.out.println("Je bent in gecheckt in: " + station.getStad());
        System.out.println("Jouw huidige saldo is: " + ovChipkaart.getSaldo());
    }

    public void uitchecken(OVChipkaart uitchecken) {
        if (uitchecken.getStartStation() == null) {
            System.out.println("Je bent niet ingecheckt.");
            return;
        }

        double afstand = getAfstand(uitchecken.getStartStation(), station);
        double kosten = Math.round(afstand * 0.23 * 100.0) / 100.0;

        uitchecken.setSaldo(uitchecken.getSaldo() - kosten);
        uitchecken.setStartStation(null);
        System.out.println("De reis kostte: " + kosten);
        System.out.println("Je bent uitgecheckt in: " + station.getStad());
        System.out.println("Jouw huidige saldo is: " + uitchecken.getSaldo());
    }


    public double getAfstand(Station startStation, Station eindStation) {
        double earthRadius = 6371; // aarde straal in kilometers
        double lat1 = Math.toRadians(startStation.getLatitude());
        double lon1 = Math.toRadians(startStation.getLongitude());
        double lat2 = Math.toRadians(eindStation.getLatitude());
        double lon2 = Math.toRadians(eindStation.getLongitude());

        double dlon = lon2 - lon1;
        double dlat = lat2 - lat1;

        double a = Math.pow(Math.sin(dlat / 2), 2)
                + Math.cos(lat1) * Math.cos(lat2) * Math.pow(Math.sin(dlon / 2), 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distance = earthRadius * c;

        return distance;
    }
}
	
