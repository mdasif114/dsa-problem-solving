import java.util.*;
import java.util.function.Supplier;

/**
 * P18 - Longest Stable Metrics Window
 * Evidence: Recurring | Probability: High | Difficulty: Medium
 * Return the longest contiguous window whose maximum minus minimum value is at
 * most maxRange. Values may be negative. Target O(n) time.
 */
public class P18_LongestStableMetricsWindow_Starter {
    public static int longestStableWindow(int[] values, int maxRange) {
        // TODO
        throw new UnsupportedOperationException("TODO");
    }

    public static void main(String[] args) {
        run("normal", 3, () -> longestStableWindow(new int[]{8, 2, 4, 7}, 5));
        run("all stable", 4, () -> longestStableWindow(new int[]{1, 2, 3, 4}, 3));
        run("single", 1, () -> longestStableWindow(new int[]{9}, 0));
        run("negative", 3, () -> longestStableWindow(new int[]{-3, -2, -1, 5}, 2));
        run("empty", 0, () -> longestStableWindow(new int[]{}, 2));
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

