import java.util.*;
import java.util.function.Supplier;

/**
 * P08 - Health-Check Stream Processor
 * Evidence: Recurring, adapted from a 2024 SRE moving-average report.
 * Probability: High | Difficulty: Medium
 * For every check, return the fraction of successful checks among the most
 * recent windowSize checks, including the current item.
 */
public class P08_HealthCheckStreamProcessor_Starter {
    public static List<Double> rollingAvailability(List<Boolean> checks, int windowSize) {
        // TODO
        throw new UnsupportedOperationException("TODO");
    }

    public static void main(String[] args) {
        run("window three", List.of(1.0, 0.5, 2.0 / 3.0, 1.0 / 3.0),
                () -> rollingAvailability(List.of(true, false, true, false), 3));
        run("window one", List.of(1.0, 0.0),
                () -> rollingAvailability(List.of(true, false), 1));
        run("larger than input", List.of(0.0, 0.5),
                () -> rollingAvailability(List.of(false, true), 5));
        run("all healthy", List.of(1.0, 1.0, 1.0),
                () -> rollingAvailability(List.of(true, true, true), 2));
        run("empty", List.of(), () -> rollingAvailability(List.of(), 3));
    }

    private static void run(String name, Object expected, Supplier<Object> attempt) {
        try {
            Object actual = attempt.get();
            System.out.printf("%s %s expected=%s actual=%s%n",
                    Objects.deepEquals(expected, actual) ? "PASS" : "FAIL", name, expected, actual);
        } catch (UnsupportedOperationException e) {
            System.out.printf("FAIL %s expected=%s actual=TODO%n", name, expected);
        }
    }
}

