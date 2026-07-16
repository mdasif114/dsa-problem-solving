import java.util.*;
import java.util.function.Supplier;

/**
 * P13 - Top-K Frequent Events
 * Evidence: Recurring | Probability: High | Difficulty: Medium
 * Return up to k event names ordered by descending frequency and then ascending
 * name. Clarify k bounds, null entries, and deterministic ties.
 */
public class P13_TopKFrequentEvents_Starter {
    public static List<String> topKFrequent(List<String> events, int k) {
        // TODO
        throw new UnsupportedOperationException("TODO");
    }

    public static void main(String[] args) {
        run("normal", List.of("timeout", "reset"), () -> topKFrequent(List.of(
                "timeout", "reset", "timeout", "auth", "reset", "timeout"), 2));
        run("tie", List.of("a", "b"), () -> topKFrequent(List.of("b", "a"), 2));
        run("k too large", List.of("a", "b"), () -> topKFrequent(List.of("a", "b", "a"), 5));
        run("zero k", List.of(), () -> topKFrequent(List.of("a"), 0));
        run("empty", List.of(), () -> topKFrequent(List.of(), 3));
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

