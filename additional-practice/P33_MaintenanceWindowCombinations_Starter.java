import java.util.*;
import java.util.function.Supplier;

/**
 * P33 - Maintenance-Window Combinations
 * Evidence: Representative | Probability: Lower | Difficulty: Medium
 * Given distinct positive durations, return unique nondecreasing combinations
 * that sum to target. Each duration may be used repeatedly. Sort combinations
 * lexicographically by their numeric contents.
 */
public class P33_MaintenanceWindowCombinations_Starter {
    public static List<List<Integer>> combinations(int[] durations, int target) {
        // TODO
        throw new UnsupportedOperationException("TODO");
    }

    public static void main(String[] args) {
        run("normal", List.of(List.of(2, 2, 3), List.of(7)),
                () -> combinations(new int[]{2, 3, 7}, 7));
        run("one", List.of(List.of(3, 3)), () -> combinations(new int[]{3}, 6));
        run("none", List.of(), () -> combinations(new int[]{4, 5}, 3));
        run("zero target", List.of(List.of()), () -> combinations(new int[]{2, 3}, 0));
        run("empty durations", List.of(), () -> combinations(new int[]{}, 5));
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

