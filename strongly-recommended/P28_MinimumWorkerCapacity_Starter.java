import java.util.*;
import java.util.function.Supplier;

/**
 * P28 - Minimum Worker Capacity
 * Evidence: Recurring | Probability: Medium | Difficulty: Medium
 * Jobs must remain in order. Split them across at most shifts contiguous groups.
 * Return the minimum capacity needed so each group sum is at most capacity.
 */
public class P28_MinimumWorkerCapacity_Starter {
    public static long minimumCapacity(int[] jobs, int shifts) {
        // TODO
        throw new UnsupportedOperationException("TODO");
    }

    public static void main(String[] args) {
        run("normal", 6L, () -> minimumCapacity(new int[]{1, 2, 3, 4, 5}, 3));
        run("one shift", 15L, () -> minimumCapacity(new int[]{1, 2, 3, 4, 5}, 1));
        run("many shifts", 5L, () -> minimumCapacity(new int[]{1, 2, 3, 4, 5}, 8));
        run("single", 9L, () -> minimumCapacity(new int[]{9}, 2));
        run("empty", 0L, () -> minimumCapacity(new int[]{}, 3));
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

