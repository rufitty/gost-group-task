package task;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FactorialTest {
    private static Factorial f = new Factorial();

    @Test
    public void testFactorial() {
        assertEquals("Factorial from 5 to 7", 210, f.factorial(5,7).intValue());
    }
    @Test
    public void testCalc() {
        assertEquals("Calculation with r=2 and m=6", 15, f.calc(2,6).intValue());
    }
}
