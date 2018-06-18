package task;

import java.io.PrintStream;

public class TwoSeven {
    public static void main(String[] arg) {
        new TwoSeven().print(20, System.out);
    }

    protected void print(int max, PrintStream out) {
        boolean twoCounter = true;
        int sevenCounter = 0;
        for (int i = 1; i <= max; i++) {
            twoCounter = !twoCounter;
            sevenCounter++;

            if (sevenCounter == 7) {
                if (twoCounter) {
                    out.print("Two");
                }
                out.println("Seven");
                sevenCounter = 0;
            } else if (twoCounter) {
                out.println("Two");
            } else {
                out.println(i);
            }
        }
    }
}
