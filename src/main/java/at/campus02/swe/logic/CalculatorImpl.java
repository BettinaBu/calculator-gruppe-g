package at.campus02.swe.logic;


import at.campus02.swe.Calculator;
import at.campus02.swe.CalculatorException;

import java.util.Stack;

public class CalculatorImpl implements Calculator {

    private Stack<Double> stack_ = new Stack<Double>();

    @Override
    public double perform(Operation op) throws CalculatorException {

        //für einstellige Operationen nur eine Zahl vom Stapel nehmen, deshalb vorgereiht und nicht unten ergänzt
        // Input Erwartung: Winkel im Bogenmaß, keine Umrechnung
        switch(op) {
            case sin:
                return Math.sin(pop());
            case cos:
                return Math.cos(pop());
            case dot:
                return dotProduct(); //Hilfsmethode
            default:                        //einfach unten weitergehen mit zweistelligen Operationen
        }

        double b = pop();
        double a = pop();

        switch (op) {
            case add:
                return a + b;
            case sub:
                return a - b;
            case div:
                double c = a / b;
                if (Double.isInfinite(c))
                    throw new CalculatorException("Division by zero");
                return c;
            case mul:
                return a * b;

            case mod:
                if (b == 0) {
                    throw new CalculatorException("Division by zero");
                }
                return a % b;

            default:
        }
        return 0;
    }

    @Override
    public double pop() throws CalculatorException {
        if (stack_.isEmpty())
            throw new CalculatorException();
        return stack_.pop();
    }

    @Override
    public void push(double v) {
        stack_.push(v);
    }

    @Override
    public void clear() {
        stack_.clear();
    }


    private double dotProduct() throws CalculatorException {
        double vektordimension = pop(); // oberste Zahl am Stapel -> sagt uns, wieviele Werte zu jedem Vektor gehören

                                   //Math.floor checkt, ob es eine Kommazahl ist
        if (vektordimension < 1 || vektordimension != Math.floor(vektordimension)){
            throw new CalculatorException("Invalid vector dimension. Check last digit.");
        }

        if (stack_.size() < 2 * vektordimension){
            throw new CalculatorException("Not enough values.");
        }

        int components = (int) vektordimension; //casten, weil pop() ein double liefert. Hier ist casten unproblematisch, weil wir mit erster if schon kommazahlen abgefangen haben

        // neue leere Vektoren anlegen je nach Anzahl Vektor-Komponenten [0.0, 0.0, 0.0]
        double[] vektor1 = new double[components];
        double[] vektor2 = new double[components];

        //rückwärts denken, vektor 2 ist später draufgekommen also als erstes runternehmen
        for (int i = components - 1; i >= 0; i--) {
            vektor2[i] = pop();
        }

        for (int i = components - 1; i >= 0; i--) {
            vektor1[i] = pop();
        }

        double skalarprodukt = 0;
        for (int i = 0; i < components; i++){
            skalarprodukt += vektor1[i] * vektor2[i];
        }

        return skalarprodukt;
    }
}
