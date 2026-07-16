import java.util.*;
import java.util.function.Supplier;

/**
 * P21 - Shortest Dependency Path
 * Evidence: Recurring; recent 2024 SRE report described BFS shortest path.
 * Probability: High | Difficulty: Medium
 * Return one shortest directed path including source and target. Visit neighbours
 * lexicographically so output is deterministic. Return empty when unreachable.
 */
public class P21_ShortestDependencyPath_Starter {
    public static List<String> shortestPath(
            Map<String, List<String>> graph, String source, String target) {
        // TODO
        throw new UnsupportedOperationException("TODO");
    }

    public static void main(String[] args) {
        Map<String, List<String>> graph = Map.of(
                "a", List.of("b", "c"), "b", List.of("d"), "c", List.of("d"));
        run("shortest deterministic", List.of("a", "b", "d"),
                () -> shortestPath(graph, "a", "d"));
        run("same", List.of("a"), () -> shortestPath(graph, "a", "a"));
        run("unreachable", List.of(), () -> shortestPath(graph, "d", "a"));
        run("direct", List.of("a", "b"), () -> shortestPath(graph, "a", "b"));
        run("unknown", List.of(), () -> shortestPath(graph, "x", "d"));
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

