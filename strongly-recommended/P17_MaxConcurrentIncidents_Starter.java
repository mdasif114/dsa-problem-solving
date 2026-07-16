import java.util.*;
import java.util.function.Supplier;

/**
 * P17 - Maximum Concurrent Incidents
 * Evidence: Recurring | Probability: High | Difficulty: Medium
 * Incidents use half-open intervals [start, end), so one ending exactly when
 * another starts does not overlap. Return the peak concurrent count.
 */
public class P17_MaxConcurrentIncidents_Starter {
    public record Incident(long start, long end) {}

    public static int maxConcurrent(List<Incident> incidents) {
        // TODO
        throw new UnsupportedOperationException("TODO");
    }

    public static void main(String[] args) {
        run("overlap", 2, () -> maxConcurrent(List.of(
                new Incident(1, 5), new Incident(2, 3))));
        run("touching", 1, () -> maxConcurrent(List.of(
                new Incident(1, 2), new Incident(2, 3))));
        run("three", 3, () -> maxConcurrent(List.of(
                new Incident(1, 5), new Incident(2, 6), new Incident(3, 4))));
        run("single", 1, () -> maxConcurrent(List.of(new Incident(1, 2))));
        run("empty", 0, () -> maxConcurrent(List.of()));
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

