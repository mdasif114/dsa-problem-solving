import java.util.*;
import java.util.function.Supplier;

/**
 * P39 - Streaming Median Latency
 * Evidence: Recurring | Probability: Lower | Difficulty: Hard
 * After each latency arrives, return the median of all values seen. For an even
 * count, median is the arithmetic mean of the two middle values.
 */
public class P39_StreamingMedianLatency_Starter {
    public static List<Double> runningMedians(int[] latencies) {
        // TODO
        throw new UnsupportedOperationException("TODO");
    }

    public static void main(String[] args) {
        run("normal", List.of(5.0, 3.0, 5.0, 4.0),
                () -> runningMedians(new int[]{5, 1, 9, 3}));
        run("increasing", List.of(1.0, 1.5, 2.0),
                () -> runningMedians(new int[]{1, 2, 3}));
        run("duplicates", List.of(2.0, 2.0, 2.0),
                () -> runningMedians(new int[]{2, 2, 2}));
        run("negative", List.of(-1.0, -1.5),
                () -> runningMedians(new int[]{-1, -2}));
        run("empty", List.of(), () -> runningMedians(new int[]{}));
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

