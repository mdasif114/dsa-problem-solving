import java.util.*;
import java.util.function.Supplier;

/**
 * P04 - Schedule Jobs Across Workers
 * Evidence: Representative | Probability: High | Difficulty: Medium
 * Jobs arrive in input order. Assign each job to the worker that becomes free
 * earliest (lowest worker ID breaks ties) and return the final completion time.
 * Clarify worker count, zero-duration jobs, overflow, and whether reordering is allowed.
 */
public class P04_ScheduleJobsAcrossWorkers_Starter {
    public static long completionTime(int[] jobDurations, int workers) {
        // TODO
        throw new UnsupportedOperationException("TODO");
    }

    public static void main(String[] args) {
        run("two workers", 9L, () -> completionTime(new int[]{5, 2, 3, 4}, 2));
        run("one worker", 10L, () -> completionTime(new int[]{1, 2, 3, 4}, 1));
        run("more workers", 5L, () -> completionTime(new int[]{5, 2}, 4));
        run("zero durations", 1L, () -> completionTime(new int[]{0, 0, 1}, 2));
        run("empty jobs", 0L, () -> completionTime(new int[]{}, 3));
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
