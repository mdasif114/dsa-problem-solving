import java.util.*;
import java.util.function.Supplier;

/**
 * P38 - K Closest Datacentres
 * Evidence: Recurring | Probability: Medium | Difficulty: Medium
 * Return up to k points closest to the origin by squared Euclidean distance.
 * Break ties by x then y and return the final list in that deterministic order.
 */
public class P38_KClosestDatacenters_Starter {
    public record Point(int x, int y) {}

    public static List<Point> kClosest(List<Point> points, int k) {
        // TODO
        throw new UnsupportedOperationException("TODO");
    }

    public static void main(String[] args) {
        run("normal", List.of(new Point(0, 1), new Point(1, 1)), () -> kClosest(List.of(
                new Point(3, 4), new Point(1, 1), new Point(0, 1)), 2));
        run("tie", List.of(new Point(-1, 0), new Point(0, -1), new Point(0, 1)),
                () -> kClosest(List.of(new Point(0, 1), new Point(-1, 0), new Point(0, -1)), 3));
        run("k too large", List.of(new Point(1, 0)),
                () -> kClosest(List.of(new Point(1, 0)), 4));
        run("zero k", List.of(), () -> kClosest(List.of(new Point(1, 0)), 0));
        run("empty", List.of(), () -> kClosest(List.of(), 2));
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

