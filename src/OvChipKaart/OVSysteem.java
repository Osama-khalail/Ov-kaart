package OvChipKaart;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class OVSysteem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // reiziger(s) aanmaken
        List<Reiziger> reizigers = new ArrayList<>(); // declareer en initialiseer de lijst van reizigers
        Reiziger reiziger = new Reiziger(11228833, "Erik", "Straatweg 1", "mijnwachtwoord");
        reizigers.add(reiziger); // voeg de reiziger toe aan de lijst

        // Maak een nieuwe OV-chipkaart
        Date geldigTot = new Date(123, 3, 25); //jaar, maand, dag
        OVChipkaart ovChipkaartErik = new OVChipkaart(1122334, 40.0, geldigTot);
        reiziger.addOVChipkaart(ovChipkaartErik);

        // Maak een lijst van stations
        // parameters are: stadnaam, latitude, longitude
        List<Station> stations = new ArrayList<>();
        // maak stations
        stations.add(new Station("Utrecht Centraal", 52.0907, 5.1221));
        stations.add(new Station("Amsterdam Centraal", 52.3738, 4.8909));
        stations.add(new Station("Rotterdam Centraal", 51.9244, 4.4777));
        stations.add(new Station("Arnhem Centraal", 51.9840, 5.8987));
        stations.add(new Station("Eindhoven Centraal", 51.4416, 5.4697));
        stations.add(new Station("Nijmegen Centraal", 51.8425, 5.8520));
        stations.add(new Station("Den Haag Centraal", 52.0786, 4.2887));
        stations.add(new Station("Maastricht Centraal", 50.8514, 5.6902));

        // Maak een lijst van incheckpalen
        List<IncheckPaal> incheckpalen = new ArrayList<>();
        // maak incheckpalen
        int stationId = 1;
        for (Station station : stations) {
            incheckpalen.add(new IncheckPaal(stationId, station));
            stationId++;
        }

        // OVChipkaart opladen, vragen of je wilt opladen en hoeveel
        System.out.print("Wilt u uw OV opladen? (y/n) ");
        String opladen = scanner.nextLine();
        if (opladen.equals("y")) {
            System.out.print("Hoeveel wilt u opladen? ");
            int bedrag = scanner.nextInt();
            ovChipkaartErik.setSaldo(ovChipkaartErik.getSaldo() + bedrag);
            System.out.println("Uw saldo is nu: " + ovChipkaartErik.getSaldo());
        }

        // Toon de lijst van incheckpalen
        System.out.println("Beschikbare incheckpalen:");
        for (IncheckPaal incheckpaal : incheckpalen) {
            System.out.println(incheckpaal.getId() + " - " + incheckpaal.getStation().getStad());
        }
        // Vraag de gebruiker om een incheckpaal te selecteren
        System.out.print("Selecteer een incheckpaal: ");
        int incheckpaalId = scanner.nextInt();
        scanner.nextLine(); // lees de newline karakter na de input uit de input buffer

        // Zoek de geselecteerde incheckpaal
        IncheckPaal geselecteerdeIncheckPaal = null;
        for (IncheckPaal incheckpaal : incheckpalen) {
            if (incheckpaal.getId() == incheckpaalId) {
                geselecteerdeIncheckPaal = incheckpaal;
                break;
            }
        }
        if (geselecteerdeIncheckPaal == null) {
            System.out.println("Ongeldige incheckpaal geselecteerd.");
            return;
        }

        System.out.print("Wilt u inchecken? (y/n) ");
        String actie = scanner.nextLine();
        if (actie.equals("y")) {
            System.out.print("Hou je OV tegen de paal aan: ");
            geselecteerdeIncheckPaal.inchecken(ovChipkaartErik);
        } else if (actie.equals("n")) {
            System.exit(500);
        }

        // Toon de lijst van incheckpalen
        System.out.println("Kies een paal om uit te checken:");
        System.out.println("Beschikbare uitcheckpalen:");
        for (IncheckPaal incheckpaal : incheckpalen) {
            System.out.println(incheckpaal.getId() + " - " + incheckpaal.getStation().getStad());
        }

        // Vraag de gebruiker om een uitcheckpaal te selecteren
        System.out.print("Selecteer een uitcheckpaal: ");
        int uitcheckpaalId = scanner.nextInt();
        scanner.nextLine(); // lees de newline karakter na de input uit de input buffer

        // Zoek de geselecteerde incheckpaal
        IncheckPaal geselecteerdeUitcheckpaal = null;
        for (IncheckPaal uitcheckpaal : incheckpalen) {
            if (uitcheckpaal.getId() == uitcheckpaalId) {
                geselecteerdeUitcheckpaal = uitcheckpaal;
                break;
            }
        }

        geselecteerdeUitcheckpaal.uitchecken(ovChipkaartErik);
    }
}
