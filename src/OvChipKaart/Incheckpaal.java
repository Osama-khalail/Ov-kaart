import java.util.Scanner;

public class IncheckenUI {
    public static void main(String[] args) {
        // Maak nieuwe reiziger en OV-chipkaart aan
        Reiziger reiziger = new Reiziger("Henk", "de Vries", "01-01-2000");
        OVChipkaart ovChipkaart = new OVChipkaart(123456789, 50.0, reiziger);
        
        // Maak nieuwe incheckpaal aan en stel OV-chipkaart in
        Incheckpaal incheckpaal = new Incheckpaal();
        incheckpaal.setOVChipkaart(ovChipkaart);
        
        // Voer incheckproces uit
        inchecken(incheckpaal);
    }
    
    public static void inchecken(Incheckpaal incheckpaal) {
        Scanner input = new Scanner(System.in);
        System.out.println("Wilt u inchecken of uitchecken? (I/U)");
        String inOfUit = input.nextLine();
        
        if (inOfUit.equalsIgnoreCase("I")) {
            // Voer incheckproces uit
            incheckpaal.inchecken();
        } else if (inOfUit.equalsIgnoreCase("U")) {
            // Voer uitcheckproces uit
            incheckpaal.uitchecken();
        } else {
            System.out.println("Ongeldige invoer. Probeer het opnieuw.");
            inchecken(incheckpaal);
        }
    }
}
