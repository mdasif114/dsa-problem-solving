import java.util.*;
import java.util.function.Supplier;

/**
 * P32 - Sparse Metric Matrix
 * Evidence: Representative | Probability: Lower | Difficulty: Medium
 * Add two sparse matrices represented as nonzero Cell -> value maps. Omit cells
 * whose resulting value is zero. Matrix dimensions are assumed compatible.
 */
public class P32_SparseMetricMatrix_Starter {
    public record Cell(int row, int column) {}

    public static Map<Cell, Long> add(Map<Cell, Long> left, Map<Cell, Long> right) {
        // TODO
        throw new UnsupportedOperationException("TODO");
    }

    public static void main(String[] args) {
        Cell a = new Cell(0, 0);
        Cell b = new Cell(1, 2);
        run("disjoint", Map.of(a, 2L, b, 3L), () -> add(Map.of(a, 2L), Map.of(b, 3L)));
        run("same cell", Map.of(a, 5L), () -> add(Map.of(a, 2L), Map.of(a, 3L)));
        run("cancels", Map.of(), () -> add(Map.of(a, 2L), Map.of(a, -2L)));
        run("one empty", Map.of(a, 2L), () -> add(Map.of(a, 2L), Map.of()));
        run("both empty", Map.of(), () -> add(Map.of(), Map.of()));
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

