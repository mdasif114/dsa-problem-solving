import java.util.*;
import java.util.function.Supplier;

/**
 * P27 - Weighted Job Scheduling
 * Evidence: Representative | Probability: Medium | Difficulty: Hard
 * Select non-overlapping half-open jobs [start,end) with maximum total value.
 * Jobs ending exactly when another begins are compatible.
 */
public class P27_WeightedJobScheduling_Starter {
    public record Job(long start, long end, long value) {}

    public static long maximumValue(List<Job> jobs) {
        // TODO
        throw new UnsupportedOperationException("TODO");
    }

    public static void main(String[] args) {
        run("choose two", 120L, () -> maximumValue(List.of(
                new Job(1, 3, 50), new Job(2, 4, 10), new Job(3, 5, 70))));
        run("choose one", 100L, () -> maximumValue(List.of(
                new Job(1, 5, 100), new Job(1, 2, 10), new Job(2, 5, 20))));
        run("touching", 30L, () -> maximumValue(List.of(
                new Job(1, 2, 10), new Job(2, 3, 20))));
        run("single", 7L, () -> maximumValue(List.of(new Job(1, 2, 7))));
        run("empty", 0L, () -> maximumValue(List.of()));
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

