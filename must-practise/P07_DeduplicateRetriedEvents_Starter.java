import java.util.*;
import java.util.function.Supplier;

/**
 * P07 - Deduplicate Retried Events
 * Evidence: Recurring | Probability: High | Difficulty: Medium
 * Events are timestamp ordered. Keep the first event for an ID and discard later
 * occurrences within retentionSeconds of the last accepted occurrence. An event
 * after the retention window is accepted again. Boundary is inclusive.
 */
public class P07_DeduplicateRetriedEvents_Starter {
    public record Event(String id, long timestamp, String payload) {}

    public static List<Event> deduplicate(List<Event> events, long retentionSeconds) {
        // TODO
        throw new UnsupportedOperationException("TODO");
    }

    public static void main(String[] args) {
        Event a1 = new Event("a", 0, "one");
        Event a2 = new Event("a", 5, "retry");
        Event a3 = new Event("a", 11, "new");
        run("retry removed", List.of(a1), () -> deduplicate(List.of(a1, a2), 10));
        run("outside accepted", List.of(a1, a3), () -> deduplicate(List.of(a1, a3), 10));
        run("boundary removed", List.of(a1),
                () -> deduplicate(List.of(a1, new Event("a", 10, "boundary")), 10));
        run("different ids", List.of(a1, new Event("b", 1, "two")),
                () -> deduplicate(List.of(a1, new Event("b", 1, "two")), 10));
        run("empty", List.of(), () -> deduplicate(List.of(), 10));
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

