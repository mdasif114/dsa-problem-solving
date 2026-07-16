import java.util.*;
import java.util.function.Supplier;

/**
 * P06 - Unavailable Transitive Dependencies
 * Evidence: Recurring | Probability: High | Difficulty: Medium
 * Map direction: service -> services it depends on. Given initially failed
 * services, return every service unavailable directly or transitively, including
 * the initially failed set. Clarify cycles, unknown services, and output ordering.
 */
public class P06_UnavailableTransitiveDependencies_Starter {
    public static Set<String> unavailableServices(
            Map<String, List<String>> dependencies, Set<String> failed) {
        // TODO
        throw new UnsupportedOperationException("TODO");
    }

    public static void main(String[] args) {
        Map<String, List<String>> graph = Map.of(
                "web", List.of("api"), "api", List.of("db"), "worker", List.of("queue"));
        run("transitive", Set.of("db", "api", "web"),
                () -> unavailableServices(graph, Set.of("db")));
        run("leaf failure", Set.of("web"), () -> unavailableServices(graph, Set.of("web")));
        run("multiple", Set.of("db", "api", "web", "queue", "worker"),
                () -> unavailableServices(graph, Set.of("db", "queue")));
        run("unknown failed", Set.of("external"),
                () -> unavailableServices(graph, Set.of("external")));
        run("none", Set.of(), () -> unavailableServices(graph, Set.of()));
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

