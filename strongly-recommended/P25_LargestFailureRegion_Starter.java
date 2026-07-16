import java.util.*;
import java.util.function.Supplier;

/**
 * P25 - Largest Failure Region
 * Evidence: Recurring | Probability: Medium | Difficulty: Medium
 * A 1 is a failed host and 0 is healthy. Return the largest 4-directionally
 * connected failure region. Do not mutate the input grid.
 */
public class P25_LargestFailureRegion_Starter {
    public static int largestFailureRegion(int[][] grid) {
        // TODO
        throw new UnsupportedOperationException("TODO");
    }

    public static void main(String[] args) {
        run("normal", 3, () -> largestFailureRegion(new int[][]{
                {1, 1, 0}, {0, 1, 0}, {1, 0, 1}}));
        run("diagonal separate", 1, () -> largestFailureRegion(new int[][]{
                {1, 0}, {0, 1}}));
        run("all failed", 4, () -> largestFailureRegion(new int[][]{
                {1, 1}, {1, 1}}));
        run("none", 0, () -> largestFailureRegion(new int[][]{{0, 0}}));
        run("empty", 0, () -> largestFailureRegion(new int[][]{}));
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

