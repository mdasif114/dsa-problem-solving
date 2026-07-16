import java.util.*;
import java.util.function.Supplier;

/**
 * P10 - First Threshold Breach
 * Evidence: Representative | Probability: High | Difficulty: Medium
 * Samples are timestamp ordered with nonnegative error counts. Return the first
 * timestamp where cumulative errors become strictly greater than threshold, or -1.
 */
public class P10_FirstThresholdBreach_Starter {
    public record Sample(long timestamp, long errors) {}

    public static long firstBreachTimestamp(List<Sample> samples, long threshold) {
        // TODO
        throw new UnsupportedOperationException("TODO");
    }

    public static void main(String[] args) {
        run("middle", 20L, () -> firstBreachTimestamp(List.of(
                new Sample(10, 2), new Sample(20, 4), new Sample(30, 1)), 5));
        run("equal is not breach", -1L,
                () -> firstBreachTimestamp(List.of(new Sample(10, 5)), 5));
        run("first", 10L, () -> firstBreachTimestamp(List.of(new Sample(10, 6)), 5));
        run("never", -1L, () -> firstBreachTimestamp(List.of(
                new Sample(10, 1), new Sample(20, 1)), 5));
        run("empty", -1L, () -> firstBreachTimestamp(List.of(), 0));
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

