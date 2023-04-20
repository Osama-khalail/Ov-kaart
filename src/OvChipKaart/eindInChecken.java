package OvChipKaart;

import java.util.Scanner;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

public class eindInChecken {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Reiziger> reizigers = new ArrayList<>(); // declareer en initialiseer de lijst van reizigers
        Reiziger reiziger = new Reiziger(11228833, "Erik", "Straatweg 1", "mijnwachtwoord");
        reizigers.add(reiziger); // voeg de reiziger toe aan de lijst

        // Maak een nieuwe OV-chipkaart
        Date geldigTot = new Date(123, 3, 25); //jaar, maand, dag
        OVChipkaart ovChipkaartErik = new OVChipkaart(1122334, 20.0, geldigTot);
        reiziger.addOVChipkaart(ovChipkaartErik);
        // Maak een lijst van incheckpalen
        List<Incheckpaal> incheckpalen = new ArrayList<>();
        Incheckpaal incheckpaal1 = new Incheckpaal(1, "Utrecht Centraal");
        Incheckpaal incheckpaal2 = new Incheckpaal(2, "Amsterdam Centraal" );
        Incheckpaal incheckpaal3 = new Incheckpaal(3, "Rotterdam Centraal");
        Incheckpaal incheckpaal4 = new Incheckpaal(4, "Arnhem Centraal");
        Incheckpaal incheckpaal5 = new Incheckpaal(5, "Eindhoven Centraal");
        Incheckpaal incheckpaal6 = new Incheckpaal(6,"Nijmegen Centraal");
        incheckpalen.add(incheckpaal1);
        incheckpalen.add(incheckpaal2);
        incheckpalen.add(incheckpaal3);
        incheckpalen.add(incheckpaal4);
        incheckpalen.add(incheckpaal5);
        incheckpalen.add(incheckpaal6);
        
        // Toon de lijst van incheckpalen
        System.out.println("Beschikbare incheckpalen:");
        for (Incheckpaal incheckpaal : incheckpalen) {
            System.out.println(incheckpaal.getId() + " - " + incheckpaal.getStation());
        }
        // Vraag de gebruiker om een incheckpaal te selecteren
        System.out.print("Selecteer een incheckpaal: ");
        int incheckpaalId = scanner.nextInt();
        scanner.nextLine(); // lees de newline karakter na de input uit de input buffer

        // Zoek de geselecteerde incheckpaal
        Incheckpaal geselecteerdeIncheckpaal = null;
        for (Incheckpaal incheckpaal : incheckpalen) {
            if (incheckpaal.getId() == incheckpaalId) {
                geselecteerdeIncheckpaal = incheckpaal;
                break;
            }
        }
        if (geselecteerdeIncheckpaal == null) {
            System.out.println("Ongeldige incheckpaal geselecteerd.");
            return;
        }
        System.out.print("Wilt u inchecken (i) of uitchecken (u)? ");
        String actie = scanner.nextLine();
        if (actie.equals("i")) {
            System.out.print("Hou je OV tegen de paal aan: ");
            geselecteerdeIncheckpaal.inchecken(ovChipkaartErik);
            if(ovChipkaartErik.isIngecheckt()) {
            	ovChipkaartErik.setIngecheckt(false); // de kaart wordt uitgecheckt
            	ovChipkaartErik.setSaldo(kosten); // schrijf het bedrag af van het saldo van de kaart
                System.out.println("U heeft uitgecheckt. " + kosten + " euro is van uw saldo afgeschreven.");  
                    System.out.println("U kunt niet uitchecken, want u heeft niet ingecheckt.");
                }
       
        }
        System.out.println("om te uitchecken hou je OV tegen de paal aan: ");
   
     
    }
}
