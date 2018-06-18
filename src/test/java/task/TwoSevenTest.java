package task;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class TwoSevenTest {
    private static TwoSeven twoSeven = new TwoSeven();

    @Test
    public void testTwoSeven() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        twoSeven.print(15, new PrintStream(out));
        assertEquals("Count to 15", "1\n" +
                "Two\n" +
                "3\n" +
                "Two\n" +
                "5\n" +
                "Two\n" +
                "Seven\n" +
                "Two\n" +
                "9\n" +
                "Two\n" +
                "11\n" +
                "Two\n" +
                "13\n" +
                "TwoSeven\n" +
                "15\n", new String(out.toByteArray()));
    }
}
