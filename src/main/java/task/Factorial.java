package task;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.stream.LongStream;

/*
m!/r!/(m-r)! = r+1 *... * m/(m-r)!
 */
public class Factorial {
    public static final String HELP = "Expected two integers r and m";

    public static void main(String[] arg) {
        if (arg.length != 2) {
            System.err.printf(String.format("Wrong number of arguments: %s. %s\n", arg.length, HELP));
            return;
        }
        int r;
        int m;
        try {
            r = Integer.valueOf(arg[0]);
            m = Integer.valueOf(arg[1]);
        } catch (NumberFormatException e) {
            System.err.printf(String.format("Some arguments have wrong format: %s. %s\n", Arrays.toString(arg), HELP));
            return;
        }
        System.out.printf("Calculation result for \"m!/r!/(m-r)!\" with r=%s and m=%s:\n", r, m);
        System.out.println(new Factorial().calc(r, m));
    }

    public BigDecimal calc(int r, int m) {
        int numeratorStart = r + 1;
        int numeratorEnd = m;
        int denominator = m - r;
        if (numeratorStart >= denominator) {
            numeratorStart = denominator;
            denominator = numeratorStart;
        }
        return factorial(numeratorStart, numeratorEnd).divide(factorial(1, denominator));
    }

    protected BigDecimal factorial(int start, int end) {
        return LongStream.rangeClosed(start, end).parallel().
                mapToObj(BigDecimal::valueOf).
                reduce(BigDecimal.valueOf(1L), (x, y) -> x.multiply(y));
    }

}
