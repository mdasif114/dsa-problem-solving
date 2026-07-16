import java.util.*;
import java.util.function.Supplier;

/**
 * P40 - Weighted Dependency Path
 * Evidence: Recurring | Probability: Medium | Difficulty: Medium
 * Find minimum nonnegative cost from source to target in a directed graph.
 * Return -1 when unreachable. Edge costs and totals use long.
 */
public class P40_WeightedDependencyPath_Starter {
    public record Edge(String to, long cost) {}

    public static long shortestCost(
            Map<String, List<Edge>> graph, String source, String target) {
        // TODO
        throw new UnsupportedOperationException("TODO");
    }

    public static void main(String[] args) {
        Map<String, List<Edge>> graph = Map.of(
                "a", List.of(new Edge("b", 5), new Edge("c", 2)),
                "c", List.of(new Edge("b", 1)), "b", List.of());
        run("cheaper indirect", 3L, () -> shortestCost(graph, "a", "b"));
        run("direct", 2L, () -> shortestCost(graph, "a", "c"));
        run("same", 0L, () -> shortestCost(graph, "a", "a"));
        run("unreachable", -1L, () -> shortestCost(graph, "b", "a"));
        run("unknown", -1L, () -> shortestCost(graph, "x", "a"));
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

