import java.util.*;
import java.util.function.Supplier;

/**
 * P12 - LRU Cache
 * Evidence: Recurring | Probability: High | Difficulty: Medium
 * Simulate GET and PUT operations on a fixed-capacity integer cache. GET returns
 * -1 when absent. Return the GET results in operation order. PUT updates recency.
 */
public class P12_LruCache_Starter {
    public record Operation(String type, int key, int value) {
        public static Operation get(int key) { return new Operation("GET", key, 0); }
        public static Operation put(int key, int value) { return new Operation("PUT", key, value); }
    }

    public static List<Integer> simulate(int capacity, List<Operation> operations) {
        // TODO: target O(1) average GET and PUT using owned data structures.
        throw new UnsupportedOperationException("TODO");
    }

    public static void main(String[] args) {
        run("eviction", List.of(1, -1, 3), () -> simulate(2, List.of(
                Operation.put(1, 1), Operation.put(2, 2), Operation.get(1),
                Operation.put(3, 3), Operation.get(2), Operation.get(3))));
        run("update", List.of(9), () -> simulate(1, List.of(
                Operation.put(1, 1), Operation.put(1, 9), Operation.get(1))));
        run("missing", List.of(-1), () -> simulate(2, List.of(Operation.get(4))));
        run("get refreshes", List.of(1, -1), () -> simulate(2, List.of(
                Operation.put(1, 1), Operation.put(2, 2), Operation.get(1),
                Operation.put(3, 3), Operation.get(2))));
        run("no operations", List.of(), () -> simulate(2, List.of()));
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

