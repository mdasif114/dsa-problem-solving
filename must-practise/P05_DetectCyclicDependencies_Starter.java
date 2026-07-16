import java.util.*;
import java.util.function.Supplier;

/**
 * P05 - Detect Cyclic Service Dependencies
 * Evidence: Recurring | Probability: High | Difficulty: Medium
 * The map stores service -> direct dependencies. Return true if any directed
 * cycle exists, including a self-cycle. Services may appear only as dependencies.
 */
public class P05_DetectCyclicDependencies_Starter {
    public static boolean hasCycle(Map<String, List<String>> dependencies) {
        // TODO
        throw new UnsupportedOperationException("TODO");
    }

    public static void main(String[] args) {
        run("simple cycle", true, () -> hasCycle(Map.of(
                "a", List.of("b"), "b", List.of("a"))));
        run("acyclic", false, () -> hasCycle(Map.of(
                "a", List.of("b"), "b", List.of("c"), "c", List.of())));
        run("self cycle", true, () -> hasCycle(Map.of("a", List.of("a"))));
        run("disconnected cycle", true, () -> hasCycle(Map.of(
                "a", List.of("b"), "x", List.of("y"), "y", List.of("x"))));
        run("empty", false, () -> hasCycle(Map.of()));
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

