import java.util.*;
import java.util.function.Supplier;

/**
 * P15 - Token-Bucket Rate Limiter
 * Evidence: Representative | Probability: High | Difficulty: Medium
 * Requests are timestamp ordered. A bucket starts full, refills whole tokens at
 * refillPerSecond up to capacity, and each allowed request consumes one token.
 * Return allow/deny decisions. Use deterministic integer-second timestamps.
 */
public class P15_TokenBucketRateLimiter_Starter {
    public static List<Boolean> allowRequests(
            List<Long> timestamps, int capacity, int refillPerSecond) {
        // TODO
        throw new UnsupportedOperationException("TODO");
    }

    public static void main(String[] args) {
        run("burst", List.of(true, true, false),
                () -> allowRequests(List.of(0L, 0L, 0L), 2, 1));
        run("refill", List.of(true, false, true),
                () -> allowRequests(List.of(0L, 0L, 1L), 1, 1));
        run("capacity cap", List.of(true, true, true, false),
                () -> allowRequests(List.of(0L, 10L, 10L, 10L), 2, 10));
        run("zero refill", List.of(true, false, false),
                () -> allowRequests(List.of(0L, 1L, 2L), 1, 0));
        run("empty", List.of(), () -> allowRequests(List.of(), 3, 1));
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
