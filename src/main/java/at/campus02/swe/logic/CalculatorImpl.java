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

}
