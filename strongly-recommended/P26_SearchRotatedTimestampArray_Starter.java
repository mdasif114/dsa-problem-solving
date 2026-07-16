import java.util.*;
import java.util.function.Supplier;

/**
 * P26 - Search Rotated Timestamp Array
 * Evidence: Recurring | Probability: Medium | Difficulty: Medium
 * Search a strictly increasing timestamp array rotated at an unknown pivot.
 * Return target index or -1. No duplicates are present.
 */
public class P26_SearchRotatedTimestampArray_Starter {
    public static int search(long[] timestamps, long target) {
        // TODO
        throw new UnsupportedOperationException("TODO");
    }

    public static void main(String[] args) {
        run("rotated found", 4, () -> search(new long[]{40, 50, 60, 10, 20, 30}, 20));
        run("left side", 1, () -> search(new long[]{40, 50, 60, 10, 20, 30}, 50));
        run("missing", -1, () -> search(new long[]{40, 50, 60, 10, 20, 30}, 35));
        run("not rotated", 2, () -> search(new long[]{10, 20, 30}, 30));
        run("empty", -1, () -> search(new long[]{}, 1));
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

