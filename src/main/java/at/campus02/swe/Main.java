package at.campus02.swe;
import at.campus02.swe.logic.CalculatorImpl;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {

        Calculator calc = new CalculatorImpl();
        System.out.println("===============================================");
        System.out.println("Neuer Calculator erfolgreich gestartet");

        Scanner userInput = new Scanner(System.in);
        System.out.print("Wähle die gewünschte Operation durch Eingabe -> add, sub, mul, div, mod: ");

        Calculator.Operation operation;

        try {
            operation = Calculator.Operation.valueOf(userInput.nextLine().trim());
        } catch (IllegalArgumentException e) {
            System.out.println("Unbekannte Operation.");
            return;
        }

        //HIER später Logik für sin, cos hinzufügen

        // add, sub, div, mul, mod -> erwarten zwei Doublewerte
        if (operation == Calculator.Operation.add || operation == Calculator.Operation.sub || operation == Calculator.Operation.div
                || operation == Calculator.Operation.mul || operation == Calculator.Operation.mod){
            try {
                System.out.print("Bitte gib die erste Zahl ein: ");
                calc.push(Double.parseDouble(userInput.nextLine().trim())); //erste Zahl auf Stack pushen
                System.out.print("Bitte gib die zweite Zahl ein: ");
                calc.push(Double.parseDouble(userInput.nextLine().trim())); //zweite Zahl auf Stack pushen
            } catch (NumberFormatException e) {
                System.out.println("Ungültige Zahleingabe.");
            }
        }

        // Hauptlogik - Rechnen mit den Zahlen
        try {
            System.out.println("Ergebnis: " + calc.perform(operation));
        } catch (CalculatorException e){
            System.out.println("Fehler: " + e.getMessage());
        }
    }
}
