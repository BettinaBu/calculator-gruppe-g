package at.campus02.swe;
import at.campus02.swe.logic.CalculatorImpl;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {

        Calculator calc = new CalculatorImpl();
        System.out.println("===============================================");
        System.out.println("Neuer Calculator erfolgreich gestartet\n");

        Scanner userInput = new Scanner(System.in);
        System.out.print("Wähle die gewünschte Operation durch Eingabe -> add, sub, mul, div, mod, sin, cos, dot: ");

        Calculator.Operation operation;

        try {
            operation = Calculator.Operation.valueOf(userInput.nextLine().trim());
        } catch (IllegalArgumentException e) {
            System.out.println("Unbekannte Operation.");
            return;
        }

        if (operation == Calculator.Operation.sin || operation == Calculator.Operation.cos) {
            try {
                System.out.print("Bitte gib das Winkelmaß (Radiant) ein: ");
                calc.push(Double.parseDouble(userInput.nextLine().trim()));
            } catch (NumberFormatException e) {
                System.out.println("Ungültige Zahleingabe.");
                return;
            }
        }

        if (operation == Calculator.Operation.dot) {
            try {
                System.out.print("Bitte gib die Dimension (Anzahl Vektorkomponenten) ein: "); //Dimension als erstes Abfragen, aber als letztes Pushen!!
                int dimension = Integer.parseInt(userInput.nextLine().trim());

                for (int i = 1; i <= 2; i++){ //Vektor 1 dann Vektor 2
                    System.out.println("\nGib nacheinander die Komponenten des Vektors " + i + " ein:");
                    for (int j = 1; j <= dimension; j++){ // Komponente 1, 2, 3, 4...
                        System.out.print("Komponente " + j + ": ");
                        calc.push(Double.parseDouble(userInput.nextLine().trim()));
                    }
                }
                calc.push(dimension);

            } catch (NumberFormatException e) {
                System.out.println("Ungültige Zahleingabe.");
                return;
            }
        }

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
                return;
            }
        }

        // Hauptlogik - Rechnen mit den Zahlen
        try {
            System.out.println();
            System.out.println("Ergebnis: " + calc.perform(operation));
        } catch (CalculatorException e){
            System.out.println();
            System.out.println("Fehler: " + e.getMessage());
        }
    }
}
