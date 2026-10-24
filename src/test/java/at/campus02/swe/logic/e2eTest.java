package at.campus02.swe.logic;

import at.campus02.swe.Calculator;
import at.campus02.swe.parser.Parser;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertEquals;

public class e2eTest {

    private Calculator calculator;
    private Parser parser;


    @Before
    public void setUp() throws Exception {

        calculator = new CalculatorImpl();
        parser = new Parser(calculator);
    }

    @Test
    public void testParserTest05Xml() throws Exception {

        double result = parser.parse(new File("src/test/resources/test05_e2e.xml"));
        assertEquals(3.0, result, 0);


    }

    @Test
    public void testParserTest06Xml() throws Exception {

        double result = parser.parse(new File("src/test/resources/test06_e2e.xml"));
        assertEquals(3.0, result, 0);


    }





}
