import java.util.*;
import java.util.function.Supplier;

/**
 * P34 - Minimum Restart Cost on a Service Chain
 * Evidence: Representative | Probability: Lower | Difficulty: Medium
 * Choose services to restart so every adjacent pair contains at least one chosen
 * service. Return minimum total cost. An empty or single-service chain costs zero.
 */
public class P34_MinimumRestartCost_Starter {
    public static long minimumRestartCost(long[] costs) {
        // TODO
        throw new UnsupportedOperationException("TODO");
    }

    public static void main(String[] args) {
        run("three", 2L, () -> minimumRestartCost(new long[]{5, 2, 5}));
        run("two", 3L, () -> minimumRestartCost(new long[]{3, 7}));
        run("four", 4L, () -> minimumRestartCost(new long[]{4, 2, 2, 4}));
        run("single", 0L, () -> minimumRestartCost(new long[]{9}));
        run("empty", 0L, () -> minimumRestartCost(new long[]{}));
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

