import java.util.*;
import java.util.function.Supplier;

/**
 * P23 - Service Clusters with Union-Find
 * Evidence: Representative | Probability: Medium | Difficulty: Medium
 * Given all service names and undirected connectivity links, return the number
 * of connected clusters. Duplicate links and self-links do not change the result.
 */
public class P23_ServiceClusterUnionFind_Starter {
    public record Link(String left, String right) {}

    public static int countClusters(Set<String> services, List<Link> links) {
        // TODO
        throw new UnsupportedOperationException("TODO");
    }

    public static void main(String[] args) {
        run("two clusters", 2, () -> countClusters(Set.of("a", "b", "c"),
                List.of(new Link("a", "b"))));
        run("connected", 1, () -> countClusters(Set.of("a", "b", "c"),
                List.of(new Link("a", "b"), new Link("b", "c"))));
        run("isolated", 3, () -> countClusters(Set.of("a", "b", "c"), List.of()));
        run("duplicates", 1, () -> countClusters(Set.of("a", "b"),
                List.of(new Link("a", "b"), new Link("a", "b"))));
        run("empty", 0, () -> countClusters(Set.of(), List.of()));
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

