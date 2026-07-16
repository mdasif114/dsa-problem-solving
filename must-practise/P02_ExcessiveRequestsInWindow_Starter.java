import java.util.*;
import java.util.function.Supplier;

/**
 * P02 - Excessive Requests in a Window
 * Evidence: Recurring | Probability: High | Difficulty: Medium
 * Requests are sorted by nondecreasing timestamp. Return clients that have more
 * than limit requests in any inclusive window [t-windowSeconds, t].
 * Clarify ordering, inclusive boundaries, duplicate timestamps, and invalid limits.
 */
public class P02_ExcessiveRequestsInWindow_Starter {
    public record Request(String client, long timestamp) {}

    public static Set<String> excessiveClients(
            List<Request> requests, long windowSeconds, int limit) {
        // TODO
        throw new UnsupportedOperationException("TODO");
    }

    public static void main(String[] args) {
        run("one offender", Set.of("a"), () -> excessiveClients(List.of(
                new Request("a", 1), new Request("a", 2), new Request("a", 3)), 2, 2));
        run("boundary included", Set.of("a"), () -> excessiveClients(List.of(
                new Request("a", 0), new Request("a", 10)), 10, 1));
        run("outside window", Set.of(), () -> excessiveClients(List.of(
                new Request("a", 0), new Request("a", 11)), 10, 1));
        run("multiple clients", Set.of("a", "b"), () -> excessiveClients(List.of(
                new Request("a", 1), new Request("b", 1), new Request("a", 2),
                new Request("b", 2)), 5, 1));
        run("empty", Set.of(), () -> excessiveClients(List.of(), 10, 3));
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

