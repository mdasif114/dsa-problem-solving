import java.util.*;
import java.util.function.Supplier;

/**
 * P03 - Merge Outage Intervals
 * Evidence: Recurring | Probability: High | Difficulty: Medium
 * Merge overlapping or touching closed intervals. Return intervals sorted by start.
 * Clarify whether touching intervals merge and how invalid start/end values behave.
 */
public class P03_MergeOutageIntervals_Starter {
    public record Interval(long start, long end) {}

    public static List<Interval> mergeOutages(List<Interval> intervals) {
        // TODO
        throw new UnsupportedOperationException("TODO");
    }

    public static void main(String[] args) {
        run("overlap", List.of(new Interval(1, 5)), () -> mergeOutages(List.of(
                new Interval(1, 3), new Interval(2, 5))));
        run("touching", List.of(new Interval(1, 4)), () -> mergeOutages(List.of(
                new Interval(1, 2), new Interval(2, 4))));
        run("disjoint", List.of(new Interval(1, 2), new Interval(5, 6)),
                () -> mergeOutages(List.of(new Interval(5, 6), new Interval(1, 2))));
        run("nested", List.of(new Interval(1, 10)), () -> mergeOutages(List.of(
                new Interval(1, 10), new Interval(2, 3))));
        run("empty", List.of(), () -> mergeOutages(List.of()));
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

