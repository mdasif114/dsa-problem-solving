import java.util.*;
import java.util.function.Supplier;

/**
 * P35 - Process-Tree Traversal
 * Evidence: Recurring; recent SRE report mentioned basic tree traversal.
 * Probability: Medium | Difficulty: Easy
 * Return process IDs in preorder from root. Children must be visited in the list
 * order supplied. The input is a tree rather than a general graph.
 */
public class P35_ProcessTreeTraversal_Starter {
    public static List<Integer> preorder(Map<Integer, List<Integer>> children, int root) {
        // TODO
        throw new UnsupportedOperationException("TODO");
    }

    public static void main(String[] args) {
        Map<Integer, List<Integer>> tree = Map.of(
                1, List.of(2, 3), 2, List.of(4), 3, List.of(), 4, List.of());
        run("normal", List.of(1, 2, 4, 3), () -> preorder(tree, 1));
        run("subtree", List.of(2, 4), () -> preorder(tree, 2));
        run("leaf", List.of(3), () -> preorder(tree, 3));
        run("root not key", List.of(9), () -> preorder(tree, 9));
        run("single", List.of(1), () -> preorder(Map.of(1, List.of()), 1));
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

