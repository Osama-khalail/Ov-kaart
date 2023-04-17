package OvChipKaart;

import java.util.Scanner;
import java.util.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class eindInChecken {

    public static void main(String[] args) {
        OVSysteem ovSysteem = new OVSysteem();
        Scanner scanner = new Scanner(System.in);
        List<Reiziger> reizigers = new ArrayList<>(); // declareer en initialiseer de lijst van reizigers
        Reiziger reiziger = new Reiziger(11228833, "Erik", "Straatweg 1", "mijnwachtwoord");
        reizigers.add(reiziger); // voeg de reiziger toe aan de lijst

        // Maak een nieuwe OV-chipkaart
        Date geldigTot = new Date(123, 3, 25); //jaar, maand, dag
        OVChipkaart ovChipkaartErik = new OVChipkaart(1122334, 20.0, geldigTot);
        reiziger.addOVChipkaart(ovChipkaartErik);

        // Vraag de gebruiker om hun naam, kaartnummer en station
        System.out.print("Voer uw naam in: ");
        String naam = scanner.nextLine();

        System.out.print("Voer uw kaartnummer in: ");
        int kaartnummer = scanner.nextInt();

        scanner.nextLine(); // lees de newline karakter na het kaartnummer uit de input buffer

        System.out.print("Voer uw station in: ");
        String station = scanner.nextLine();

        // Zoek de reiziger op basis van naam en kaartnummer
        Reiziger gevondenReiziger = null;


        for (Reiziger r : reizigers) {
            if (r.getNaam().equals(naam)) {
                for (OVChipkaart ovkaart : r.getOVChipkaarten()) {
                    if (ovkaart.getKaartnummer() == kaartnummer) {
                        gevondenReiziger = r;
                        break;
                    }
                }
            }
        }

        if (gevondenReiziger == null) {
            System.out.println("Onbekende reiziger of kaartnummer.");
            return;
        }

        // Inchecken
        ovSysteem.inchecken(reiziger, kaartnummer, station);

        // Uitchecken
        System.out.print("Voer ur uitcheck station in: ");
        String uitcheckStation = scanner.nextLine();
        ovSysteem.uitchecken(reiziger, kaartnummer, uitcheckStation);

    }
}
