import java.util.*;
import java.util.function.Supplier;

/**
 * P09 - Aggregate Metrics by Service and Window
 * Evidence: Representative | Probability: High | Difficulty: Medium
 * Bucket timestamp t into floor(t / bucketSeconds) * bucketSeconds. Return sums
 * by service and bucket. Inputs use nonnegative timestamps and positive buckets.
 */
public class P09_AggregateMetricsByWindow_Starter {
    public record Metric(String service, long timestamp, long value) {}

    public static Map<String, Map<Long, Long>> aggregate(
            List<Metric> metrics, long bucketSeconds) {
        // TODO
        throw new UnsupportedOperationException("TODO");
    }

    public static void main(String[] args) {
        run("same bucket", Map.of("api", Map.of(0L, 7L)), () -> aggregate(List.of(
                new Metric("api", 1, 3), new Metric("api", 9, 4)), 10));
        run("two buckets", Map.of("api", Map.of(0L, 3L, 10L, 4L)), () -> aggregate(List.of(
                new Metric("api", 9, 3), new Metric("api", 10, 4)), 10));
        run("two services", Map.of("api", Map.of(0L, 1L), "web", Map.of(0L, 2L)),
                () -> aggregate(List.of(new Metric("api", 1, 1), new Metric("web", 2, 2)), 10));
        run("negative values", Map.of("api", Map.of(0L, -2L)), () -> aggregate(List.of(
                new Metric("api", 1, 3), new Metric("api", 2, -5)), 10));
        run("empty", Map.of(), () -> aggregate(List.of(), 10));
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

