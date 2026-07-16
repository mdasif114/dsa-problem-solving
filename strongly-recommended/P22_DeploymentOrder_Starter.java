import java.util.*;
import java.util.function.Supplier;

/**
 * P22 - Deployment Order
 * Evidence: Recurring | Probability: High | Difficulty: Medium
 * Map direction: service -> prerequisites. Return a valid order with every
 * prerequisite before its service. When several are ready, choose lexical order.
 * Return empty if a cycle makes deployment impossible.
 */
public class P22_DeploymentOrder_Starter {
    public static List<String> deploymentOrder(Map<String, List<String>> prerequisites) {
        // TODO
        throw new UnsupportedOperationException("TODO");
    }

    public static void main(String[] args) {
        run("chain", List.of("db", "api", "web"), () -> deploymentOrder(Map.of(
                "web", List.of("api"), "api", List.of("db"), "db", List.of())));
        run("lexical", List.of("a", "b", "c"), () -> deploymentOrder(Map.of(
                "a", List.of(), "b", List.of(), "c", List.of("a", "b"))));
        run("cycle", List.of(), () -> deploymentOrder(Map.of(
                "a", List.of("b"), "b", List.of("a"))));
        run("dependency only", List.of("db", "api"),
                () -> deploymentOrder(Map.of("api", List.of("db"))));
        run("empty", List.of(), () -> deploymentOrder(Map.of()));
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

