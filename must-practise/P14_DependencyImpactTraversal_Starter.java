import java.util.*;
import java.util.function.Supplier;

/**
 * P14 - Dependency Impact Traversal
 * Evidence: Recurring | Probability: High | Difficulty: Medium
 * Map direction: service -> direct dependencies. Return services directly or
 * transitively dependent on changedService, excluding changedService itself.
 */
public class P14_DependencyImpactTraversal_Starter {
    public static Set<String> impactedServices(
            Map<String, List<String>> dependencies, String changedService) {
        // TODO
        throw new UnsupportedOperationException("TODO");
    }

    public static void main(String[] args) {
        Map<String, List<String>> graph = Map.of(
                "web", List.of("api"), "api", List.of("db"),
                "worker", List.of("db"), "db", List.of());
        run("transitive", Set.of("api", "web", "worker"),
                () -> impactedServices(graph, "db"));
        run("middle", Set.of("web"), () -> impactedServices(graph, "api"));
        run("leaf", Set.of(), () -> impactedServices(graph, "web"));
        run("unknown", Set.of(), () -> impactedServices(graph, "external"));
        run("empty", Set.of(), () -> impactedServices(Map.of(), "db"));
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

