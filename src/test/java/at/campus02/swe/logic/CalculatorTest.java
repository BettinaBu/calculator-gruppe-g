package at.campus02.swe.logic;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import at.campus02.swe.Calculator;
import at.campus02.swe.CalculatorException;
import at.campus02.swe.Calculator.Operation;

public class CalculatorTest {

    @Test
    public void testSimpleAddOperation() throws Exception {

        //setup
        Calculator calc = new CalculatorImpl();

        //execute
        calc.push(2.0);
        calc.push(3);
        double result = calc.perform(Operation.add);

        //verify
        assertEquals(5, result, 0);


    }

    @Test
    public void testSimpleMulOperation() throws Exception {

        Calculator calc = new CalculatorImpl();
        calc.push(2.0);
        calc.push(3);
        double result = calc.perform(Operation.mul);

        assertEquals(6, result, 0);

    }

    @Test
    public void testSimpleDivOperation() throws Exception {

        Calculator calc = new CalculatorImpl();
        calc.push(6.0);
        calc.push(2);
        double result = calc.perform(Operation.div);

        assertEquals(3, result, 0);

    }





    //
    @Test(expected = CalculatorException.class)
    public void testPopOnEmptyStack() throws Exception {

        Calculator calc = new CalculatorImpl();
        calc.pop();

    }

    @Test
    public void testDivisionByZero() throws Exception {

        //Setup
        Calculator calc = new CalculatorImpl();
        try {
            calc.push(2);
            calc.push(0);
            calc.perform(Operation.div);

            fail("Exception expected");


        } catch (CalculatorException e) {
            assertEquals("Division by zero", e.getMessage());
            // e.getCause()
        }

    }

    @Test
    public void testSimpleModOperation() throws Exception { //Modulo mit Rest

        Calculator calc = new CalculatorImpl();
        calc.push(7.0);
        calc.push(3);
        double result = calc.perform(Operation.mod);

        assertEquals(1, result, 0); // 1 erwartet, 0 Abweichung erlaubt
    }

    @Test
    public void testModOperationWithoutRemainder() throws Exception { //Modulo ohne Rest

        Calculator calc = new CalculatorImpl();
        calc.push(6.0);
        calc.push(3);
        double result = calc.perform(Operation.mod);

        assertEquals(0, result, 0); // 0 erwartet, 0 Abweichung erlaubt
    }

    @Test
    public void testModuloByZero() throws Exception {

        Calculator calc = new CalculatorImpl();
        try {
            calc.push(2);
            calc.push(0);
            calc.perform(Operation.mod);

            fail("Exception expected");

        } catch (CalculatorException e) {
            assertEquals("Division by zero", e.getMessage());
        }
    }

    @Test
    public void testModuloWithNegativeDividend() throws Exception {

        //Setup
        Calculator calc = new CalculatorImpl();

        //Execute
        calc.push(-7);
        calc.push(3);
        double result = calc.perform(Operation.mod);

        //Verify
        assertEquals(-1, result, 0);
    }

    // ---------- Skalarprodukt (dot) ----------

    @Test
    public void testDotProductLength1() throws Exception {

        //Setup
        Calculator calc = new CalculatorImpl();

        //Execute: (3) · (4)
        calc.push(3);   // Vektor 1
        calc.push(4);   // Vektor 2
        calc.push(1);   // Anzahl Werte pro Vektor
        double result = calc.perform(Operation.dot);

        //Verify: 3·4 = 12
        assertEquals(12, result, 0);
    }

    @Test
    public void testDotProductLength2() throws Exception {

        //Setup
        Calculator calc = new CalculatorImpl();

        //Execute: (1, 3) · (2, 4)
        calc.push(1);   // Vektor 1
        calc.push(3);
        calc.push(2);   // Vektor 2
        calc.push(4);
        calc.push(2);   // Anzahl Werte pro Vektor
        double result = calc.perform(Operation.dot);

        //Verify: 1·2 + 3·4 = 14
        assertEquals(14, result, 0);
    }

    @Test
    public void testDotProductWithZeroLength() {

        Calculator calc = new CalculatorImpl();
        try {
            calc.push(1);
            calc.push(2);
            calc.push(0);   // ungültige Anzahl
            calc.perform(Operation.dot);

            fail("Exception expected");

        } catch (CalculatorException e) {
            assertEquals("Invalid vector dimension. Check last digit.", e.getMessage());
        }
    }

    @Test(expected = CalculatorException.class)
    public void testDotProductWithNegativeLength() throws Exception {

        Calculator calc = new CalculatorImpl();
        calc.push(1);
        calc.push(2);
        calc.push(-1);  // ungültige Anzahl
        calc.perform(Operation.dot);
    }

    @Test(expected = CalculatorException.class)
    public void testDotProductWithFractionalLength() throws Exception {

        Calculator calc = new CalculatorImpl();
        calc.push(1);
        calc.push(2);
        calc.push(1.5); // ungültige Anzahl
        calc.perform(Operation.dot);
    }

    @Test
    public void testDotProductWithNotEnoughValues() {

        Calculator calc = new CalculatorImpl();
        try {
            calc.push(1);
            calc.push(2);
            calc.push(2);   // Länge 2 → 4 Werte nötig, nur 2 vorhanden
            calc.perform(Operation.dot);

            fail("Exception expected");

        } catch (CalculatorException e) {
            assertEquals("Not enough values.", e.getMessage());
        }
    }
}